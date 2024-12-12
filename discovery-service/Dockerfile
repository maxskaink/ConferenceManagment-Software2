# Etapa de construcción
FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /app

# Instalar bash para ejecutar scripts si no está disponible
RUN apk add --no-cache bash

# Copiar el proyecto
COPY . /app

# Dar permisos ejecutables a mvnw y asegurar compatibilidad de formato
RUN chmod +x ./mvnw
RUN dos2unix ./mvnw

# Construir el proyecto sin ejecutar pruebas
RUN ./mvnw clean package -DskipTests

# Etapa principal
FROM eclipse-temurin:17-jre-alpine AS main
WORKDIR /app

# Copiar el jar generado al contenedor final
COPY --from=builder /app/target/*.jar /usr/local/springboot-app.jar

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "/usr/local/springboot-app.jar"]
