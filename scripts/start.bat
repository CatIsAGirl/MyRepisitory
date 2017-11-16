echo "Starting spring-boot-demo ..... "
title "spring-boot-demo"
java -DSqlintodb_client -Xms256m -Xmx512m -XX:+UseParallelGC -XX:+UseParallelOldGC -XX:+HeapDumpOnOutOfMemoryError -cp ./conf;./lib/* com.example.demo.DemoApplication