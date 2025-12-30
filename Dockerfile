FROM openjdk:21-jdk

WORKDIR/app
COPY target/superMarket.jar /app/superMarket.jar
EXPOSE 8080
CMD ["java", "-jar", "superMarket.jar"]