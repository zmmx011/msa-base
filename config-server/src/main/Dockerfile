FROM openjdk:17-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar","/app.jar"]
ENV EUREKASERVER_URI: "http://eurekaserver:8761/eureka/"
ENV EUREKASERVER_PORT: "8761"
ENV ENCRYPT_KEY: "damu"
