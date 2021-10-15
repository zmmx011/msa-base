FROM openjdk:17-jdk-alpine AS gradle-build
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew bootJar

FROM openjdk:17-jdk-alpine
COPY --from=gradle-build build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
