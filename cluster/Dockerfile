FROM openjdk:11-buster
LABEL authors="gaspare.bonafede"

COPY target/cache_manager-*.jar /cache_manager.jar

ENTRYPOINT ["java", "-jar", "/cache_manager.jar"]
#ENTRYPOINT ["sh", "-c", "sleep infinity"]