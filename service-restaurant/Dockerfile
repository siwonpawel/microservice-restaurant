FROM openjdk:11-jre
MAINTAINER siwonpawel
EXPOSE 8080
COPY target/*.jar /service/restaurant-service.jar
CMD java -Dspring.profiles.active="docker" -jar /service/restaurant-service.jar server