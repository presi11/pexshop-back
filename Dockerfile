#FROM gradle:7.2.0-jdk11 AS build
#COPY --chown=gradle:gradle . /home/gradle/src
#WORKDIR /home/gradle/src

#RUN gradle -Dskip.tests build

#FROM adoptopenjdk:11-jdk-openj9

#EXPOSE 8091

#RUN mkdir /app

#COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar

#ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]

FROM adoptopenjdk/openjdk11:alpine-jre

RUN addgroup -S spring && adduser -S spring -G spring

USER spring:spring

ARG JAR_FILE=build/libs/*.jar

RUN ls -la

COPY ${JAR_FILE} wms.jar

EXPOSE 8091

ENTRYPOINT ["java","-jar","/wms.jar"]