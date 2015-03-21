FROM dockerfile/java
MAINTAINER 
ADD files /
WORKDIR /opt/docker
RUN ["chown", "-R", "daemon", "."]
USER daemon
ENTRYPOINT ["bin/my-first-app"]
CMD []
