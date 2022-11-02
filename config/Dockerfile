FROM openjdk:11-jdk
#RUN echo "America/Sao_Paulo" > /etc/timezone && dpkg-reconfigure -f noninteractive tzdata
#LABEL maintainer="Fabiano Góes <fabianogoes@gmail.com>"
ADD target/*-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 9090