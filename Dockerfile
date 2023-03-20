FROM amazoncorretto:8-alpine3.16-jdk
MAINTAINER JuanPabloRajoy
COPY target/PorfolioArg-0.0.1-SNAPSHOT.jar  PorfolioArg-app.jar
ENTRYPOINT ["java", "-jar", "/PorfolioArg-app.jar", "--host", "0.0.0.0", "--port", "10000"]
