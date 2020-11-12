FROM openjdk:8
EXPOSE 8080
ADD target/shopping-cart-0.0.1-SNAPSHOT.jar shopping-cart-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/shopping-cart-0.0.1-SNAPSHOT.jar"]
