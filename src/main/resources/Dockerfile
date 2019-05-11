FROM openjdk:8-jdk-alpine
ADD spring-boot*.jar spring-boot-docker.jar
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /spring-boot-docker.jar
