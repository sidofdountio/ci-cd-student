#Build docker image
FROM maven:3.9.3 AS build
WORKDIR /app
ARG CONTAINER_PORT
COPY pom.xml /app
RUN mvn dependency:resolve
COPY . /app
RUN mvn clean
RUN mvn package -DskipTests -X
#Runing stage
FROM amazoncorretto:17
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar
EXPOSE ${CONTAINER_PORT}
CMD ["java","-jar","app.jar"]
