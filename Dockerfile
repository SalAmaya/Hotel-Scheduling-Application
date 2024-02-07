FROM openjdk:17-jdk-slim

# Copy project to image
COPY target/D387_sample_code-0.0.2-SNAPSHOT.jar /app/myApp.jar

# Expose the front-end & backend ports
EXPOSE 8080 4200

# Run our app when image is started
CMD ["java","-jar","/app/myApp.jar"]
