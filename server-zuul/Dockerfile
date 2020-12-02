FROM openjdk:11-jre
MAINTAINER siwonpawel
EXPOSE 8080
COPY target/*.jar /service/zuul-server.jar
CMD java -Dspring.profiles.active="docker" -jar /service/zuul-server.jar server