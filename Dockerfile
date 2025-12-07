# Schlankes JRE-Image
FROM eclipse-temurin:21-jre-alpine

# Arbeitsverzeichnis im Container
WORKDIR /app

# Fat JAR in den Container kopieren
COPY build/libs/GLaDOS-1.0-all.jar app.jar

# Optional: Java-Optionen von außen konfigurierbar machen
ENV JAVA_OPTS=""

# Startkommando
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
