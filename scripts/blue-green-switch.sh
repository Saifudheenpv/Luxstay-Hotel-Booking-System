#!/bin/bash

set -e

NAMESPACE="hotel-booking"
APP_NAME="hotel-booking-system"
BLUE_DEPLOYMENT="${APP_NAME}-blue"
GREEN_DEPLOYMENT="${APP_NAME}-green"

echo "🔵🔴 Starting Blue-Green Deployment Switch..."
echo "=============================================="

# Get current active version
CURRENT_VERSION=$(kubectl get svc $APP_NAME -n $NAMESPACE -o jsonpath='{.spec.selector.version}' 2>/dev/null || echo "blue")

echo "Current active version: $CURRENT_VERSION"

if [ "$CURRENT_VERSION" = "blue" ]; then
    NEW_VERSION="green"
    OLD_DEPLOYMENT=$BLUE_DEPLOYMENT
    NEW_DEPLOYMENT=$GREEN_DEPLOYMENT
else
    NEW_VERSION="blue"
    OLD_DEPLOYMENT=$GREEN_DEPLOYMENT
    NEW_DEPLOYMENT=$BLUE_DEPLOYMENT
fi

echo "🔄 Switching from $CURRENT_VERSION to $NEW_VERSION"

# Scale up new version
echo "📈 Scaling up $NEW_DEPLOYMENT..."
kubectl scale deployment $NEW_DEPLOYMENT -n $NAMESPACE --replicas=2

# Wait for new version to be ready
echo "⏳ Waiting for $NEW_DEPLOYMENT to be ready..."
kubectl rollout status deployment/$NEW_DEPLOYMENT -n $NAMESPACE --timeout=300s

if [ $? -ne 0 ]; then
    echo "❌ $NEW_DEPLOYMENT failed to become ready. Aborting switch."
    exit 1
fi

# Switch traffic to new version
echo "🔄 Switching traffic to $NEW_VERSION..."
kubectl patch service $APP_NAME -n $NAMESPACE -p "{\"spec\":{\"selector\":{\"version\":\"$NEW_VERSION\"}}}"

# Wait for service to stabilize
echo "⏳ Waiting for service to stabilize..."
sleep 30

# Verify new version is receiving traffic
echo "✅ Verifying new version..."
kubectl get pods -n $NAMESPACE -l app=$APP_NAME,version=$NEW_VERSION

# Scale down old version
echo "📉 Scaling down $OLD_DEPLOYMENT..."
kubectl scale deployment $OLD_DEPLOYMENT -n $NAMESPACE --replicas=0

echo ""
echo "🎉 Successfully switched from $CURRENT_VERSION to $NEW_VERSION"
echo "🚀 Blue-Green deployment completed successfully!"

# Show final status
echo ""
echo "📊 Final Deployment Status:"
kubectl get deployments -n $NAMESPACE
kubectl get pods -n $NAMESPACE -l app=$APP_NAME
