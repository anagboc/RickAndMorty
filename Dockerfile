FROM openjdk:17-oracle

WORKDIR /app

COPY target/rick_and_morty-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 3456

CMD ["java", "-jar", "app.jar"]