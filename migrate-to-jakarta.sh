#!/bin/bash
echo "Migrating javax.* imports to jakarta.*..."

# Migrate JPA imports
find src -name "*.java" -type f -exec sed -i 's/import javax.persistence./import jakarta.persistence./g' {} +
find src -name "*.java" -type f -exec sed -i 's/javax.persistence./jakarta.persistence./g' {} +

# Migrate Validation imports
find src -name "*.java" -type f -exec sed -i 's/import javax.validation./import jakarta.validation./g' {} +
find src -name "*.java" -type f -exec sed -i 's/javax.validation./jakarta.validation./g' {} +

# Migrate Servlet imports
find src -name "*.java" -type f -exec sed -i 's/import javax.servlet./import jakarta.servlet./g' {} +
find src -name "*.java" -type f -exec sed -i 's/javax.servlet./jakarta.servlet./g' {} +

# Migrate Thymeleaf imports from spring5 to spring6
find src -name "*.java" -type f -exec sed -i 's/org.thymeleaf.spring5/org.thymeleaf.spring6/g' {} +
find src -name "*.java" -type f -exec sed -i 's/org.thymeleaf.spring5.templateresolver/org.thymeleaf.spring6.templateresolver/g' {} +

echo "Migration completed!"
