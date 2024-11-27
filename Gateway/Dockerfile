# Etapa 1: Compilación
FROM maven:3.9.4-eclipse-temurin-21 AS build

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo de configuración de Maven (pom.xml) y el script wait-for-it
COPY pom.xml .
COPY wait-for-it.sh ./wait-for-it.sh

# Descarga las dependencias (esto se cacheará si no cambia el pom.xml)
RUN mvn dependency:go-offline -B

# Copia el resto del código fuente del microservicio
COPY src ./src

# Compila el proyecto y empaqueta el archivo JAR
RUN chmod +x wait-for-it.sh && mvn clean package -DskipTests

# Etapa 2: Generación de la imagen final
FROM eclipse-temurin:21-jre-alpine

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR y el script wait-for-it desde la etapa de compilación
COPY --from=build /app/target/*.jar app.jar
COPY --from=build /app/wait-for-it.sh wait-for-it.sh

# Instala bash y curl, necesarios para ejecutar wait-for-it.sh
RUN apk add --no-cache bash curl && chmod +x wait-for-it.sh

# Configuración de variables de entorno, opcional según tus necesidades
ENV JAVA_OPTS=""

# Exponer el puerto en el que corre la aplicación
EXPOSE 8081

# Comando de inicio para esperar a que el discovery-service esté disponible y luego iniciar la aplicación
ENTRYPOINT ["./wait-for-it.sh", "discovery-service:8761", "--", "java", "-jar", "app.jar"]
