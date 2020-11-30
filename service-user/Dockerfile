FROM openjdk:11-jre
MAINTAINER siwonpawel
EXPOSE 8080
COPY target/*.jar /service/user-service.jar
CMD java -Dspring.profiles.active="docker" -jar /service/user-service.jar server