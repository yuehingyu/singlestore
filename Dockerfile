FROM openjdk:8-jdk-alpine
LABEL maintainer="yu.yuehing@gmail.com"
VOLUME /target
ADD    target/SingleStore-1.0.0-SNAPSHOT.jar singlestore_demo_app.jar
ENTRYPOINT ["java", "-jar","/singlestore_demo_app.jar"]
