        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
pipeline {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
  agent any
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }

        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
  tools {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    jdk 'JDK17'
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    maven 'Maven3'
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
  }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }

        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
  environment {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    SONARQUBE_URL     = '13.203.26.99'
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    DOCKER_NAMESPACE  = 'saifudheenpv'
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    APP_NAME          = 'hotel-booking-system'
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    APP_VERSION       = "${env.BUILD_ID}"
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    K8S_NAMESPACE     = 'hotel-booking'
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    REGION            = 'ap-south-1'
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    CLUSTER_NAME      = 'devops-cluster'
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    APP_URL           = 'URL not available'
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
  }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }

        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
  options {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    timestamps()
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    disableConcurrentBuilds()
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    timeout(time: 60, unit: 'MINUTES')  // 60 min for NLB DNS
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    buildDiscarder(logRotator(numToKeepStr: '10'))
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
  }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }

        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
  parameters {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    choice(name: 'DEPLOYMENT_STRATEGY', choices: ['blue-green', 'rolling'], description: 'Select deployment strategy')
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    booleanParam(name: 'AUTO_SWITCH', defaultValue: true, description: 'Auto switch traffic to new version?')
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    booleanParam(name: 'AUTO_MIGRATE_JAKARTA', defaultValue: false, description: 'Auto-convert javax.* imports to jakarta.*')
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
  }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }

        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
  stages {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    stage('Environment Setup') {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      steps {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
        sh '''
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          echo "Java: $(java -version 2>&1 | head -1)"
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          echo "Maven: $(mvn -version | head -1)"
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          echo "Docker: $(docker --version)"
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          echo "Kubectl: $(kubectl version --client --short)"
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
        '''
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }

        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    stage('Checkout Code') {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      steps { checkout scm }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }

        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    stage('Auto-Migrate to Jakarta') {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      when { expression { params.AUTO_MIGRATE_JAKARTA } }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      steps {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
        sh '''
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          find src -name "*.java" -type f -print0 | xargs -0 sed -i \
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            -e 's/import javax\\.persistence\\./import jakarta.persistence./g' \
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            -e 's/import javax\\.validation\\./import jakarta.validation./g' \
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            -e 's/import javax\\.servlet\\./import jakarta.servlet./g' \
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            -e 's/import javax\\.annotation\\./import jakarta.annotation./g'
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
        '''
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }

        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    stage('Build & Test') {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      steps {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
        sh 'mvn -U -B clean test -Dspring.profiles.active=test'
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }

        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    stage('OWASP Security Scan') {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      steps {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
        withCredentials([string(credentialsId: 'nvd-api-key', variable: 'NVD_API_KEY')]) {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          sh '''
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            mvn -B org.owasp:dependency-check-maven:check \
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
              -Dnvd.api.key="$NVD_API_KEY" \
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
              -DfailBuildOnCVSS=11 \
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
              -Danalyzer.ossindex.enabled=false
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          '''
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
        }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }

        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    stage('SonarQube Analysis') {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      steps {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
        withSonarQubeEnv('Sonar-Server') {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_AUTH_TOKEN')]) {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            sh '''
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
              mvn -B sonar:sonar \
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
                -Dsonar.projectKey='hotel-booking-system' \
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
                -Dsonar.host.url=http://${SONARQUBE_URL}:9000 \
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
                -Dsonar.login="$SONAR_AUTH_TOKEN"
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            '''
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
        }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }

        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    stage('Docker Build & Push') {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      steps {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
        withCredentials([usernamePassword(credentialsId: 'docker-token', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          sh '''
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            docker build -t ${DOCKER_NAMESPACE}/${APP_NAME}:${APP_VERSION} .
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            docker push ${DOCKER_NAMESPACE}/${APP_NAME}:${APP_VERSION}
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            echo "Pushed v${APP_VERSION}"
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          '''
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
        }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }

        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    stage('Deploy to EKS') {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      steps {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
        withCredentials([
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          [$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-eks-creds'],
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
        ]) {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          sh '''
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            mkdir -p .kube && cp "$KUBECONFIG_FILE" .kube/config && chmod 600 .kube/config
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            export KUBECONFIG=.kube/config
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            aws eks update-kubeconfig --name ${CLUSTER_NAME} --region ${REGION}
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }

        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            kubectl apply -f k8s/mysql-deployment.yaml -n ${K8S_NAMESPACE}
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            kubectl apply -f k8s/mysql-service.yaml -n ${K8S_NAMESPACE}
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }

        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            export APP_VERSION=${APP_VERSION}
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            envsubst < k8s/app-deployment-blue.yaml | kubectl apply -f - -n ${K8S_NAMESPACE}
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            envsubst < k8s/app-deployment-green.yaml | kubectl apply -f - -n ${K8S_NAMESPACE}
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            kubectl apply -f k8s/app-service.yaml -n ${K8S_NAMESPACE}
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          '''
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
        }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }

        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    stage('Blue-Green Switch') {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      when { expression { params.DEPLOYMENT_STRATEGY == 'blue-green' && params.AUTO_SWITCH } }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      steps {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
        withCredentials([
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          [$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-eks-creds'],
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
        ]) {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          sh '''
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            export KUBECONFIG=.kube/config
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            aws eks update-kubeconfig --name ${CLUSTER_NAME} --region ${REGION}
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }

        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            echo "Waiting for GREEN pods..."
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            kubectl wait --for=condition=ready pod -l app=hotel-booking,version=green -n ${K8S_NAMESPACE} --timeout=300s
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }

        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            echo "Switching traffic to GREEN..."
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            kubectl patch service hotel-booking-service -n ${K8S_NAMESPACE} \
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
              -p '{"spec":{"selector":{"app":"hotel-booking","version":"green"}}}'
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }

        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            echo "Scaling BLUE to 0..."
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            kubectl scale deployment hotel-booking-blue --replicas=0 -n ${K8S_NAMESPACE} || true
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          '''
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
        }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }

        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    stage('Get App URL') {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      steps {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
        withCredentials([
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          [$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-eks-creds'],
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
        ]) {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          script {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            def dns = ""
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            def maxRetries = 40  // 40 × 10s = 6.6 minutes
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            def retryDelay = 10
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }

        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            sh 'mkdir -p .kube && cp "$KUBECONFIG_FILE" .kube/config && chmod 600 .kube/config'
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            sh 'export KUBECONFIG=.kube/config'
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            sh "aws eks update-kubeconfig --name ${CLUSTER_NAME} --region ${REGION}"
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }

        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }

        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            // 100% DYNAMIC — NO HARDCODED URL
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          echo "OPEN YOUR SITE: ${env.APP_URL}"
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
        }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
  }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }

        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
  post {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    success {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      echo "SUCCESS: Deployed v${APP_VERSION}!"
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      echo "LIVE URL: ${env.APP_URL}"
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      echo "OPEN IN BROWSER: ${env.APP_URL}"
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      cleanWs()
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    failure {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      echo "FAILED: Rolling back..."
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      withCredentials([
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
        [$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-eks-creds'],
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
        file(credentialsId: 'kubeconfig', variable: 'KUBECONFIG_FILE')
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      ]) {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
        sh '''
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          export KUBECONFIG=.kube/config
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          aws eks update-kubeconfig --name ${CLUSTER_NAME} --region ${REGION}
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
          kubectl patch service hotel-booking-service -n ${K8S_NAMESPACE} \
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
            -p '{"spec":{"selector":{"app":"hotel-booking","version":"blue"}}}' || true
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
        '''
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      cleanWs()
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    always {
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
      echo "Pipeline finished at: ${new Date().format('yyyy-MM-dd HH:mm:ss z')}"
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
    }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
  }
        for (int i = 0; i < maxRetries; i++) {
          dns = sh(
            script: "kubectl get svc hotel-booking-service -n ${K8S_NAMESPACE} -o wide | awk '/hotel-booking-service/ {print $7}' 2>/dev/null || echo ''",
            returnStdout: true
          ).trim()

          if (dns && dns =~ /elb\.ap-south-1\.amazonaws\.com/) {
            env.APP_URL = "http://$dns"
            echo "LIVE URL DETECTED (via EXTERNAL-IP): ${env.APP_URL}"
            break
          } else {
            echo "Waiting for NLB DNS... (attempt ${i + 1}/${maxRetries})"
            sleep(retryDelay)
          }
        }

        if (!dns || !dns.contains('elb.ap-south-1')) {
          error "NLB DNS not available after ${maxRetries * retryDelay} seconds. Check AWS Console."
        }
}
