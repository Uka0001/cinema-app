FROM tomcat:9.0.73
ENV APP_ROOT /cinema-app
RUN apt-get update && apt-get install -y default-jdk
COPY . $APP_ROOT/
WORKDIR $APP_ROOT
RUN jar -cvf spring-cinema-app-1.0-SNAPSHOT.war *
RUN cp spring-cinema-app-1.0-SNAPSHOT.war $CATALINA_BASE/spring-cinema-app-1.0-SNAPSHOT.war
EXPOSE 8080