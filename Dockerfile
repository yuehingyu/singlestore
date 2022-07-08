FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN

FROM openjdk:8-jdk-alpine
LABEL maintainer="yu.yuehing@gmail.com"
RUN mvn package
ADD   /target/SingleStore-1.0.0-SNAPSHOT.jar singlestore_demo_app.jar
ENTRYPOINT ["java", "-jar","/singlestore_demo_app.jar"]
