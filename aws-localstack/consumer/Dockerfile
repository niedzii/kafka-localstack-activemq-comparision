FROM adoptopenjdk/openjdk11
VOLUME /tmp
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar","-Dcom.amazonaws.sdk.disableCertChecking"]