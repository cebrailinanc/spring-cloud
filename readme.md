`docker compose up` command execute in spring-cloud folder.
Docker compose will run  config server and eureka server.

eureka server: `http://localhost:8761`

config server, product-service dev profile property: `http://localhost:8888/product-service/dev`

The command below runs mongodb mysql and clients.
`docker-compose -f docker-compose-db.yml up -d --build`

`docker-compose -f docker-compose-db.yml down`

phpmyadmin url(Mysql client): `http://localhost:8081`

mongo-express url(mongo client): `http://localhost:8082`

