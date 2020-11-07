Step 1:-
   .
docker build -t client-service . --> This will create a image with name as client-service

Step 2:-

docker images --> lists all the images inside your containerID

Step 3:-

docker run -p 8084:8089 -d aa45adf751c9(imageID)

where 8084 host port and 8089 is application port inside docker containerID

Step 4:-

docker run aa45adf751c9(ImageID)


Stopping the containers
docker container stop  4dd439717559 a03f28be98cc

Removing containers
docker container rm  4dd439717559 a03f28be98cc

Removing Images
docker image rm 4dd439717559 a03f28be98cc
