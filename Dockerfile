#
#  Build stage
#
FROM maven:3.8.1-openjdk-17-slim AS build
COPY Backend/src /home/app/src
COPY Backend/pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package


#
# Package stage
#
FROM openjdk:17-alpine
COPY --from=build /home/app/target/group09-0.0.1-SNAPSHOT.jar /usr/local/lib/group09.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/usr/local/lib/group09.jar"]