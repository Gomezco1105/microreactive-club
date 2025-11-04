FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY teams-service/pom.xml .
RUN mvn -q -DskipTests dependency:go-offline
COPY teams-service/src ./src
RUN mvn -q -DskipTests clean package

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
