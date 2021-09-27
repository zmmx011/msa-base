FROM openjdk:17-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=eureka-server/build/libs/*.jar
COPY ${JAR_FILE} eureka-server.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","/eureka-server.jar"]
