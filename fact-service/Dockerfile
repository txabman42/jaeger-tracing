FROM openjdk:11-jre-slim

ARG JAR_FILE=target/fact-service-*.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT java -jar -Dspring.profiles.active=${ACTIVE_PROFILE} app.jar