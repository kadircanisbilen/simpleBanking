FROM gradle:latest AS GRADLE_BUILD

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src
RUN gradle build --no-daemon -x test

FROM openjdk:15-jdk-alpine

EXPOSE 8080

COPY --from=GRADLE_BUILD /home/gradle/src/build/libs/*.jar /app/simplebanking.jar

WORKDIR /app/
CMD java -jar -Dspring.profiles.active=docker simplebanking.jar




