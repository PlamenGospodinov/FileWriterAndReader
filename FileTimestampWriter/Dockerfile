FROM openjdk:18

COPY ./out/production/FileTimestampWriter/ /tmp/filetimestampwriter

WORKDIR /tmp/filetimestampwriter

RUN mkdir "data"

VOLUME /tmp/filetimestampwriter/data

ENTRYPOINT ["java","FileTimestampWriter"]