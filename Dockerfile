FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn package -Dmaven.test.skip=true

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /target/user-service.jar user-service.jar
ENTRYPOINT ["java", "-jar", "user-service.jar"]