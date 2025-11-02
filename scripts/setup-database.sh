#!/bin/bash

# Database setup script for Hotel Booking System

DB_USER="root"
DB_PASSWORD="Shanu@9090!"
DB_NAME="hotel_booking_system"
APP_USER="hotel_user"
APP_PASSWORD="Hotel@123"

echo "Setting up database for Hotel Booking System..."

# Create database and user
mysql -u $DB_USER -p$DB_PASSWORD << MYSQL_SCRIPT
CREATE DATABASE IF NOT EXISTS $DB_NAME;
CREATE USER IF NOT EXISTS '$APP_USER'@'localhost' IDENTIFIED BY '$APP_PASSWORD';
GRANT ALL PRIVILEGES ON $DB_NAME.* TO '$APP_USER'@'localhost';
FLUSH PRIVILEGES;
MYSQL_SCRIPT

if [ $? -eq 0 ]; then
    echo "Database setup completed successfully!"
    echo "Database: $DB_NAME"
    echo "Username: $APP_USER"
else
    echo "Error: Database setup failed!"
    exit 1
fi
