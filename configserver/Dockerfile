#继承centos docker file
FROM java:8

MAINTAINER liwei <liwei@gmail.com>

#配置docker存储目录
VOLUME /tmp

#将maven目录的jar包拷贝到docker中，并命名为for_docker.jar
ADD target/configserver-0.0.1-SNAPSHOT.jar configserver.jar

ENTRYPOINT ["java", "-jar", "/configserver.jar"]