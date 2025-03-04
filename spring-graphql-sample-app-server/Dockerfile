FROM amazoncorretto:21.0.6-al2023

ARG JAR_FILE=target/spring-graphql-sample-app-server-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
