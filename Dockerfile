FROM cvcbrasil/java:8u141-jre
RUN mkdir /var/customer-register
WORKDIR /var/customer-register
COPY ./target/customer-register-0.0.1-SNAPSHOT.jar customer-register.jar
EXPOSE 8084
ENTRYPOINT ["java","-jar","customer-register.jar"]

