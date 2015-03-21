FROM ubuntu:14.04

MAINTAINER nigel_pickard@yahoo.com

RUN apt-get update

RUN apt-get -y install wget git unzip pwgen ca-certificates default-jre default-jdk

RUN useradd "builder" -m -r

RUN mkdir -p /home/builder/activator && \
    cd /home/builder/activator && \
    wget http://downloads.typesafe.com/typesafe-activator/1.2.12/typesafe-activator-1.2.12.zip && \
    unzip typesafe-activator-1.2.12.zip && \
    cd activator-1.2.12 && \
    export PATH=$PATH:$PWD

ENV PATH /home/builder/activator/activator-1.2.12:$PATH

RUN mkdir -p /home/builder/build && \
    cd /home/builder/build && \
    git clone https://github.com/nigelpickard/my-first-app.git

EXPOSE 9000

RUN cd /home/builder/build/my-first-app && \
    activator dist

RUN mkdir -p /home/builder/app

RUN cp /home/builder/build/my-first-app/target/universal/my-first-app-1.0-SNAPSHOT.zip /home/builder/app 
 
RUN cd /home/builder/app && \
    unzip my-first-app-1.0-SNAPSHOT.zip
 
CMD /home/builder/app/my-first-app-1.0-SNAPSHOT/bin/my-first-app -Dhttp.port=9000 -Dlogger.file=/home/
