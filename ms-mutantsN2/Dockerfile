FROM openjdk:11
ENV TZ=America/Bogota
EXPOSE 8001
ADD ./target/ms-mutantsN2-0.0.1-SNAPSHOT.jar mutantsN2.jar
ENTRYPOINT ["java", "-jar","./mutantsN2.jar"]
