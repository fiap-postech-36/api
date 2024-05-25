# restaurante

#Instalação 1
Será necessário subir dois containers que estarão na mesma rede.


1-Raiz do projeto /restaurante executar o comando: mvn package
2-Ir na pasta restaurante-aplicacao-web/target/
3-Copiar o artefato application.jar para pasta docker/aplicacao
4-Gerar uma rede que conectará os dois container(aplicação e banco de dados)
-docker network create network_container_aplicacao_banco_restaurante
5-Gerar uma imagem do conateiner da aplicação
-docker build -t restaurante_aplicacao:1.0 .
6-Gerar uma imagem do container do banco de dados
-ir para pasta docker/bancodados
-docker build -t restaurante_postgres:1.0 --build-arg DB_USER=postgres --build-arg DB_PASSWORD=postgres --build-arg DB_NAME=dev .
7-Iniciar o container do banco de dados
-docker run --name restaurante_postgres_container -d -p 5432:5432 restaurante_postgres:1.0
8-Iniciar o container da aplicação
-docker run  --name restaurante_aplicacao_container --hostname restaurante-host --network network_container_aplicacao_banco_restaurante -d -p 8080:8080 restaurante_aplicacao:1.0

#Swagger
Para acessar o Swagger da aplicação
http://localhost:8080/restaurante/swagger-ui/index.html#/

#Instalação 2


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


#https://trello.com/b/66MzITVs/techchalleng-desafio-restaurante
#https://miro.com/app/board/uXjVMK9tIRA=/?share_link_id=894564369501
