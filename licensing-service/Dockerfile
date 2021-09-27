FROM openjdk:17-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} licensing-service.jar
EXPOSE 8001
ENTRYPOINT ["java","-jar","/licensing-service.jar"]
ENV ENCRYPT_KEY: "damu"
