# restaurante
Sistema de apoio ao negócio de restaurante
pre-requisitos: Ter docker instalado

1-Raiz do projeto executar o comando: mvn package
2-Raiz do projeto executar o comando: mvn spring-boot:build-image
3-Na pastar docker executar o comando: docker compose up -d


#Swagger
Para acessar o Swagger da aplicação
http://localhost:8080/restaurante/swagger-ui/index.html#/

Imagemd criada restaurante-aplicacao-web:1.0-SNAPSHOT
Executar apenas a imagem da aplicação
docker run -p 8080:8080 restaurante-aplicacao-web:1.0-SNAPSHOT


https://trello.com/b/66MzITVs/techchalleng-desafio-restaurante