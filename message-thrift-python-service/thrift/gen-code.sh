#!/usr/bin/env bash
thrift --gen java -out D:\IdeaProjects\microservice\message-thrift-service-api\src\main\java message.thrift
thrift --gen py -out ../ message.thrift