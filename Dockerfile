FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /workspace

COPY pom.xml mvnw ./
COPY .mvn .mvn

COPY src src

RUN mvn -B -DskipTests package

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

COPY --from=build /workspace/target/*.jar app.jar

EXPOSE 8080

ENV JAVA_OPTS="-Xms256m -Xmx512m"

ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /app/app.jar"]

LABEL authors="criss"