FROM amazoncorretto:11-alpine3.17-jdk
MAINTAINER JuanPabloRajoy
COPY target/PorfolioArg-0.0.1-SNAPSHOT.jar  PorfolioArg-app.jar
ENTRYPOINT ["java", "-jar", "/PorfolioArg-app.jar"]
