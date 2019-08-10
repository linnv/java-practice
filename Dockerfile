FROM openjdk:8-jdk-alpine
VOLUME /data/java/msg
# ARG JAR_FILE
# COPY ${JAR_FILE} app.jar
COPY build/libs/msg-spring-boot-docker-1.0.0.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
