FROM openjdk:17-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8001
ENTRYPOINT ["java","-jar","/app.jar"]
ENV ENCRYPT_KEY: "damu"
