FROM adoptopenjdk/openjdk19
ARG JAR_FILE=Blog-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} blogprjct1.jar
ENTRYPOINT ["java","-jar","/blogprjct1.jar"]