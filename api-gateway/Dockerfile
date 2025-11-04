FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .
COPY gateway/pom.xml ./gateway/
RUN mvn -q -f gateway/pom.xml -DskipTests dependency:go-offline

COPY gateway/src ./gateway/src
RUN mvn -q -f gateway/pom.xml -DskipTests clean package

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/gateway/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
