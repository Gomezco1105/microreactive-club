FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .
COPY teams-service/pom.xml ./teams-service/
RUN mvn -q -f teams-service/pom.xml -DskipTests dependency:go-offline

COPY teams-service/src ./teams-service/src
RUN mvn -q -f teams-service/pom.xml -DskipTests clean package

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/teams-service/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
