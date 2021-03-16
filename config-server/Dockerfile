#FROM: As the base for our image we will take the Java-enabled Alpine Linux, created in the previous section.
FROM adoptopenjdk/openjdk11:alpine-jre

#COPY: We let Docker copy our jar file into the image.
COPY target/*.jar app.jar

#  Run the jar file with ENTRYPOINT.
ENTRYPOINT ["java","-jar","/app.jar"]