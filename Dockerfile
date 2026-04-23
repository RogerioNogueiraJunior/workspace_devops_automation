# Imagem oficial mantida pela Eclipse Foundation / Adoptium
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/devops-api-1.0.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]