Build image 

`docker build -t eureka-server-image .`

running image command -p <DockerHostPort>:<PortInContainer>

`docker run -p 8761:8761 -d eureka-server-image `

http://localhost:< DockerHostPort >/

`http://localhost:8761/`

