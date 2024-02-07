FROM openjdk:17-jdk-slim

ARG JAR_FILE=target/*.jar

COPY target/D387_sample_code-0.0.2-SNAPSHOT.jar app.jar


ENTRYPOINT ["java","-jar","app.jar"]

EXPOSE 8080

#CMD ["java","-jar","/app/myApp.jar"]


