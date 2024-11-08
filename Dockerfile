FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8080
COPY target/demo-0.0.1-SNAPSHOT.jar lifeline.jar
ENTRYPOINT [ "java","-jar","lifeline.jar" ]