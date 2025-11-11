# 🏨 Luxstay Hotel Booking System — CI/CD Pipeline (Jenkins + DevSecOps)

A **fully automated CI/CD DevSecOps pipeline** built using **Jenkins Declarative Pipeline** for the **Hotel Booking System (Spring Boot + Maven)** project.  
It integrates **SonarQube**, **OWASP Security Scan**, **Trivy**, **Docker**, and **AWS EKS (Kubernetes)** for zero-downtime deployment.

---

## 🚀 **Pipeline Overview**

flowchart TD
  A[Developer Push Code to GitHub] --> B[Jenkins Trigger]
  B --> C[Build & Unit Test (Maven)]
  C --> D[OWASP Dependency Check]
  D --> E[SonarQube Code Analysis]
  E --> F[Docker Build & Push to DockerHub]
  F --> G[Trivy Image Security Scan]
  G --> H[Deploy to AWS EKS (Kubernetes)]
  H --> I{Deployment Strategy}
  I -->|Blue-Green| J[Switch Traffic to Green]
  I -->|Rolling| K[Rolling Update]
  J --> L[Email Notification: Success]
  K --> L
  B --> M[Email Notification: Failure]
