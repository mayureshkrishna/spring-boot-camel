FROM lwieske/java-8:server-jre-8u121-slim
MAINTAINER Mayuresh Krishna:0.1
VOLUME /tmp
ADD customer-comments-0.0.1-snapshot.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]