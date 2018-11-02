FROM openjdk:10-jdk

ADD /target/fullstack-backend-0.0.1-SNAPSHOT.jar /dockerfs/app/fullstack-backend-0.0.1-SNAPSHOT.jar

WORKDIR /dockerfs/app

ENTRYPOINT ["java","-jar", "fullstack-backend-0.0.1-SNAPSHOT.jar"]