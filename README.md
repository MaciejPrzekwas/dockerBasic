# dockerBasic

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
`\

#Docker allows you to run on your site in an isolated - container. 
#In the case of virtualization problems, it is a lightweight process that does not consume 
#large amounts of hardware resources. As a result, 
#it enables you to create a job that gives you the assurance that it will work the same on any machine.

#The application shows how to implement a docker for Java projects using Spring.

Typical the file to implement docker have a structure:
FROM openjdk:7 <- this is for which version you have JDK
COPY . /usr/src/myapp <-select class
WORKDIR /usr/src/myapp <-select class
RUN javac Main.java
CMD ["java", "Main"]

#In my app I use:
FROM openjdk:15
ADD ./target/springboot-docker-0.0.1-SNAPSHOT.jar . <-localization of project jar 
EXPOSE 8000 <-port on which the application will be available
CMD java -jar springboot-docker-0.0.1-SNAPSHOT.jar  --environment=prod what kind of app do you want to start 


On ps or docker toolbox I used:
> docker build -f Dockerfile_test -t docker_test:v1 .  <- the image for develop environment 
> docker build -f Dockerfile_prod -t docker_prod:v1 .  <- the image for production environment 

#then to check all images type:
> docker images
 
#finaly type
> docker run -p 7000:8080 idimageDevelopVersion
#I set up a redirect on the container so that localhost: 7000 queries were redirected to port 8080
#After that you can run another container:
> docker run -p 6000:8080 idimageProdVersion

#after that check which container is up.
> docker ps
#and if you would like to stop this container type:
> docker stop containerId
