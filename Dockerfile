FROM eclipse-temurin:17

LABEL mentainer="w7moises@gmail.com"

WORKDIR /app

COPY target/management-0.0.1-SNAPSHOT.jar /app/management.jar

ENTRYPOINT ["java", "-jar", "management.jar"]