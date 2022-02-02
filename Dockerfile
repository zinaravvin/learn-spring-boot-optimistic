FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=*.jar
ADD build/libs/learn-spring-boot-0.0.1-SNAPSHOT.jar /application.jar
RUN apt-get update && apt-get install -y openssl wget
RUN set -x  && apt-get update && apt-get install -y apt-utils
RUN set -x  && apt-get install -y iputils-ping
CMD ["java", "-jar", "application.jar"]
