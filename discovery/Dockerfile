FROM openjdk:11-jdk
#RUN echo "America/Sao_Paulo" > /etc/timezone && dpkg-reconfigure -f noninteractive tzdata
#LABEL maintainer="Fabiano Góes <fabianogoes@gmail.com>"
ADD target/*-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Xmx64m", "-Xss512k", "-jar", "-Dserver.port=8761", "-Dspring.profiles.active=staging", "-Djava.security.egd=file:/dev/./urandom", "/app.jar"]
EXPOSE 8761