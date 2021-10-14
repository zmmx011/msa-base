FROM openjdk:17-jdk-alpine
ARG JAR_FILE=api-gateway/build/libs/*.jar
COPY ${JAR_FILE} api-gateway.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar","/api-gateway.jar"]
ENV EUREKASERVER_URI: "http://eurekaserver:8761/eureka/"
ENV EUREKASERVER_PORT: "8761"
ENV ENCRYPT_KEY: "damu"
