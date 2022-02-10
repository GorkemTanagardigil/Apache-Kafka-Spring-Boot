![apache-spring](https://user-images.githubusercontent.com/42736940/153388532-c7a1eebf-baf9-4052-a13b-01017c73e8c0.png)

# Apache Kafka & Spring Boot Tutorial
### This tutorial covers how to setup and use Apache Kafka in Spring Boot projects.

## Get Kafka
[Download](https://www.apache.org/dyn/closer.cgi?path=/kafka/3.1.0/kafka_2.13-3.1.0.tgz) the latest Kafka release and extract it:
```sh
$ tar -xzf kafka_2.13-3.1.0.tgz
$ cd kafka_2.13-3.1.0
```
## Start The Kafka Environment
Run the following commands in order to start all services in the correct order:

```sh
$ bin/zookeeper-server-start.sh config/zookeeper.properties
```
Open another terminal session and run:
```sh
$ bin/kafka-server-start.sh config/server.properties
```
Once all services have successfully launched, you will have a basic Kafka environment running and ready to use.

## Start Spring Boot Project
 
Create Spring Boot project for Kafka implementation.

![spring_boot_create_project_1](https://user-images.githubusercontent.com/42736940/153388928-aa00b74a-ffc5-4560-88fe-6c2ba938adf5.png)


![spring_boot_create_project_2](https://user-images.githubusercontent.com/42736940/153388993-3d8f5a9e-de6c-4541-8fbf-844be6ac455d.png)

**Let's start implementing Apache Kafka for Spring Boot applications!
