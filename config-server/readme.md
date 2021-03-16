Build image 

`docker build -t config-server-image .`

running image command -p <DockerHostPort>:<PortInContainer>

`docker run -p 8888:8888 -d config-server-image `

http://localhost:< DockerHostPort >/payment-service/dev

`http://localhost:8888/payment-service/dev`

