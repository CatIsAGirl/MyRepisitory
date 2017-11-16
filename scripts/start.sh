#!/bin/bash

# Set up environment variables:
#JAVA_HOME=/usr/local/jdk
#export JAVA_HOME
LANG=zh_CN.GB18030
export LANG
nohup java -Dfile.encoding=UTF-8 -Duser.timezone=GMT+08 -DSwitch -Xms256m -Xmx512m -XX:+UseParallelGC -XX:+UseParallelOldGC -XX:+HeapDumpOnOutOfMemoryError -cp ./conf:./lib/* com.example.demo.DemoApplication >> /dev/null 2>&1 &

