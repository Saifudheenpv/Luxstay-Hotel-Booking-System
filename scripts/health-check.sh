#!/bin/bash

set -e

NAMESPACE="hotel-booking"
APP_NAME="hotel-booking-system"

echo "🏥 Starting comprehensive health check..."
echo "========================================"

# Check Kubernetes resources
echo "1. 📋 Checking Kubernetes resources..."
kubectl get pods,svc,deploy -n $NAMESPACE

# Check application health
echo ""
echo "2. 🔍 Checking application health..."
SERVICE_IP=$(kubectl get svc $APP_NAME -n $NAMESPACE -o jsonpath='{.status.loadBalancer.ingress[0].ip}')

if [ -z "$SERVICE_IP" ]; then
    SERVICE_IP=$(kubectl get svc $APP_NAME -n $NAMESPACE -o jsonpath='{.spec.clusterIP}')
fi

echo "Service IP: $SERVICE_IP"

# Health check with retry
echo "3. 🩺 Performing health checks..."
for i in {1..15}; do
    response=$(curl -s -o /dev/null -w "%{http_code}" http://$SERVICE_IP/actuator/health || true)
    
    if [ "$response" = "200" ]; then
        echo "✅ Application health check PASSED"
        break
    fi
    
    if [ $i -eq 15 ]; then
        echo "❌ Application health check FAILED after 15 attempts"
        exit 1
    fi
    
    echo "Attempt $i/15: Application not ready yet (HTTP $response)..."
    sleep 10
done

# Check database connection through application
echo ""
echo "4. 🗄️ Checking database connectivity..."
DB_CHECK=$(curl -s http://$SERVICE_IP/actuator/health | grep -o '"status":"UP"' || true)

if [ ! -z "$DB_CHECK" ]; then
    echo "✅ Database connectivity successful"
else
    echo "❌ Database connectivity check failed"
    exit 1
fi

echo ""
echo "🎉 All health checks passed! Deployment is successful and healthy."
echo "🌐 Application is ready at: http://$SERVICE_IP"
