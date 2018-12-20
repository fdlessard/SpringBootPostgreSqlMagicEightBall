# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="fdlessard@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 5005
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/magiceightball-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} magiceightball.jar

# Run the jar file
ENTRYPOINT ["java","-Xdebug", "-agentlib:jdwp=transport=dt_socket,address=5005,suspend=n,server=y","-Djava.security.egd=file:/dev/./urandom", "-jar","/magiceightball.jar"]