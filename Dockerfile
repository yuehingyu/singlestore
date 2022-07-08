FROM openjdk:8-jdk-alpine as build
LABEL maintainer="yu.yuehing@gmail.com"
ADD   taregt/SingleStore-1.0.0-SNAPSHOT.jar singlestore_demo_app.jar
ENTRYPOINT ["java", "-jar","/singlestore_demo_app.jar"]
