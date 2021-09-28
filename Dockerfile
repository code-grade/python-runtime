FROM openjdk:11-jre-slim

RUN apt update && apt install python3 -y

ENV spring.profiles.active=prod
ENV runtime.python-cmd=python3

ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/classes /app
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF

ENTRYPOINT ["java", "-cp", "app:app/lib/*", "com.codegrade.runtime.pythonruntime.PythonRuntimeApplication"]

