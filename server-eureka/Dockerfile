FROM openjdk:11-jre
MAINTAINER siwonpawel
EXPOSE 8761
COPY target/*.jar /service/eureka-server.jar
CMD java -Dspring.profiles.active="docker" -jar /service/eureka-server.jar server