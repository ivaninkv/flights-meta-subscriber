FROM openjdk:11-jre-buster
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java",
            "-jar", "app.jar"]
