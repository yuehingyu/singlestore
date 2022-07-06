FROM openjdk:8-jdk-alpine
LABEL maintainer="yu.yuehing@gmail.com"
VOLUME /singlestore-app
ADD target/SingleStore-1.0.0-SNAPSHOT.jar singlestore_demo_app.jar
EXPOSE 5000
ENTRYPOINT ["java", "-jar","/singlestore_demo_app.jar"]
