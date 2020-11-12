FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
ENTRYPOINT ["java","-jar","/shopping-cart-0.0.1-SNAPSHOT.jar"]
