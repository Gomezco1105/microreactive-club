FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copiar el POM raíz (parent)
COPY pom.xml .

# Copiar el POM del servicio
COPY players-service/pom.xml ./players-service/

# Resolver dependencias
RUN mvn -q -f players-service/pom.xml -DskipTests dependency:go-offline

# Copiar código fuente
COPY players-service/src ./players-service/src

# Build
RUN mvn -q -f players-service/pom.xml -DskipTests clean package

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/players-service/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
