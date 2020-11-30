FROM openjdk:11-jre
MAINTAINER siwonpawel
EXPOSE 8080
COPY target/*.jar /service/booking-service.jar
CMD java -Dspring.profiles.active="docker" -jar /service/booking-service.jar server