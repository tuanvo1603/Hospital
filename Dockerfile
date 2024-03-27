FROM openjdk:17

EXPOSE 8090

COPY target/hospital.jar hospital.jar

ENTRYPOINT [ "java", "-jar", "hospital.jar" ]