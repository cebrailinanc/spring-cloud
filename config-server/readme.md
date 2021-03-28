Build image 

`docker build -t config-server-image .`

running image command -p <DockerHostPort>:<PortInContainer>

`docker run -p 8888:8888 -d config-server-image `

http://localhost:< DockerHostPort >/payment-service/dev

`http://localhost:8888/payment-service/dev`



The config server url is formed of the following structure:

http://config-server-host:port/[application_name]/[profile]/[label]

When a git repository is used as data store, property files are created according to the following rules:

application.properties / application.yml
This is the common properties file for all config client applications.
- When a file based repository, such as Git, is used then the files beginning with name application is shared to all applications wired to the same config server.
 
    [application-name].properties / [application-name].yml
- Configuration data specific to an application is stored in a file named with the application name of the client.

    [application-name]-[profile].properties / [application-name]-[profile].yml

- Configuration data with respect to a specific profile can be stored in a file named with profile after application name separated with a dash.