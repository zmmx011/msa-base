FROM openjdk:17-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=config-server/build/libs/*.jar
COPY ${JAR_FILE} config-server.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar","/config-server.jar"]
ENV EUREKASERVER_URI: "http://eurekaserver:8761/eureka/"
ENV EUREKASERVER_PORT: "8761"
ENV ENCRYPT_KEY: "damu"
