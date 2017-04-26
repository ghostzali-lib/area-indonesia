FROM lwieske/java-8:server-jre-8u121-slim

ENV PROD_VERSION 1.0

VOLUME $HOME/.log
VOLUME $HOME/.lucene

ADD productions/$PROD_VERSION/area-indonesia-$PROD_VERSION.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app.jar"]
