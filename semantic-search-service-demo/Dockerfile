FROM gradle:8.2.0-jdk17 as builder

WORKDIR /home/gradle/src

COPY semantic-search-service-demo semantic-search-service-demo
COPY modules modules
COPY llmental-core llmental-core
COPY *.gradle.kts ./
COPY gradle.properties ./

RUN gradle --info --no-daemon :semantic-search-service-demo:clean  :semantic-search-service-demo:buildFatJar

############################################

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=builder /home/gradle/src/semantic-search-service-demo/build/libs/semantic-search-service-demo-all.jar  /app/app.jar

CMD [ "java", "-jar", "/app/app.jar" ]
