FROM openjdk:8
COPY target/weave-service.jar weave-service.jar
ENV JAVA_HOME /usr/local/bin/jdk-11.0.22
ENV PATH $PATH:$JAVA_HOME/bin
ENTRYPOINT java -jar weave-service.jar