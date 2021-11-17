FROM openjdk:11
ENV TZ=America/Bogota
ADD ./target/mutantsN1-1.0-SNAPSHOT.jar mutantsN1.jar
ENTRYPOINT ["java", "-jar","./mutantsN1.jar"]