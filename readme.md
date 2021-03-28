`docker-compose up -d --build` command execute in spring-cloud folder.
Docker compose running  config server and eureka server

--build :  Build images before starting containers.

eureka server: `http://localhost:8761`

config server: `http://localhost:8888/payment-service/dev`

Running mongodb mysql and clients
`docker-compose -f docker-compose-db.yml up -d`

`docker-compose -f docker-compose-db.yml down`

phpmyadmin url(Mysql client): `http://localhost:8081`

mongo-express url(mongo client): `http://localhost:8082`

