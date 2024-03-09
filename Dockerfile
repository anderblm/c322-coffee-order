FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/coffee-order-0.0.1-SNAPSHOT.jar coffee.jar
ENTRYPOINT ["java", "-jar", "coffee.jar"]
