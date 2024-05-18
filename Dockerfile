FROM maven:3.9.3 AS build
WORKDIR /build
ARG CONTAINER_PORT

COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests


# Runtime stage
FROM amazoncorretto:17
WORKDIR /app
COPY --from=build /build/target/*.jar /app/
EXPOSE 8080
CMD ["java","-jar","app-api-*.jar"]