FROM amazoncorretto:17-alpine

WORKDIR /app

COPY target/PorfolioArg-0.0.1-SNAPSHOT.jar app.jar

EXPOSE ${PORT}

CMD ["sh", "-c", "java -jar /app/app.jar --server.port=${PORT}"]
