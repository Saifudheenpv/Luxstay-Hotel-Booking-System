#!/bin/bash

# Hotel Booking System - Build and Run Script

echo "=== Hotel Booking System ==="
echo "Starting build process..."

# Check if MySQL is running
echo "Checking MySQL status..."
sudo systemctl start mysql

# Build the project
echo "Building the project with Maven..."
mvn clean package -DskipTests

if [ $? -eq 0 ]; then
    echo "Build successful!"
    echo "Starting the application..."
    java -jar target/hotel-booking-system-1.0.0.jar
else
    echo "Build failed! Please check the errors above."
    exit 1
fi
