FROM openjdk:17-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=organization-service/build/libs/*.jar
COPY ${JAR_FILE} organization-service.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","/organization-service.jar"]
