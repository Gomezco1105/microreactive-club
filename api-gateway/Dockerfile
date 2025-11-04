FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copiar parent POM desde el root (un nivel arriba)
COPY ../pom.xml ./pom.xml

# Copiar POM del gateway (desde el directorio actual)
COPY pom.xml ./gateway/pom.xml

# Resolver dependencias
RUN mvn -q -f gateway/pom.xml -DskipTests dependency:go-offline

# Copiar código fuente
COPY src ./gateway/src

# Build
RUN mvn -q -f gateway/pom.xml -DskipTests clean package

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/gateway/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
