FROM openjdk:11
ENV TZ=America/Bogota
EXPOSE 8002
ADD ./target/ms-mutantsN3-0.0.1-SNAPSHOT.jar mutantsN3.jar
ENTRYPOINT ["java", "-jar","./mutantsN3.jar"]
