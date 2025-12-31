FROM bellsoft/liberica-openjdk-alpine:latest
#Install crul and jq
RUN apk update && apk add --no-cache curl jq
WORKDIR /home/selenium-docker
ADD build/docker-resources .
ADD runner.sh runner.sh
#For Windows
RUN dos2unix runner.sh
#Environment Variable
#BROWSER
#HUB_HOST - http://192.168.0.11:4444/
#TEST_SUITE
#THREAD_COUNT
ENTRYPOINT exec sh runner.sh