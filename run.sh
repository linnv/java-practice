./gradlew build && java -jar build/libs/msg-spring-boot-docker-1.0.0.jar
docker build -t javamsg:1.0 .
# docker run -d --restart=unless-stopped --net=host -v /data/java/msg:/data/java/msg --name jmsg -p 8080:8080 -it --rm javamsg:1.0
docker run --restart=unless-stopped --net=host --name jmsg -p 8080:8080 -it --rm javamsg:1.0
