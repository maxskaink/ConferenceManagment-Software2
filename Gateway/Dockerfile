# Etapa 1: Compilación
FROM maven:3.9.4-eclipse-temurin-21 AS build

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo de configuración de Maven (pom.xml)
COPY pom.xml .

# Descarga las dependencias (esto se cacheará si no cambia el pom.xml)
RUN mvn dependency:go-offline -B

# Copia el resto del código fuente del microservicio
COPY src ./src

# Compila el proyecto y empaqueta el archivo JAR
RUN mvn clean package -DskipTests

# Etapa 2: Generación de la imagen final
FROM eclipse-temurin:21-jre-alpine

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR desde la etapa de compilación
COPY --from=build /app/target/*.jar app.jar

# Configuración de variables de entorno, opcional según tus necesidades
ENV JAVA_OPTS=""

# Exponer el puerto en el que corre la aplicación
EXPOSE 8081

# Comando de inicio para la aplicación Spring Boot
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
