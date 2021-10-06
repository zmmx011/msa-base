FROM openjdk:17-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=user-service/build/libs/*.jar
COPY ${JAR_FILE} user-service.jar
EXPOSE 8005
ENTRYPOINT ["java","-jar","/user-service.jar"]
ENV ENCRYPT_KEY: "damu"
