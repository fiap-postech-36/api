# restaurante

#Instalação 1
Será necessário subir dois containers que estarão na mesma rede.
<p>
1-Raiz do projeto /restaurante executar o comando: mvn package </br>
2-Ir na pasta restaurante-aplicacao-web/target/ </br>
3-Copiar o artefato application.jar para pasta docker/aplicacao </br>
4-Gerar uma rede que conectará os dois container(aplicação e banco de dados) </br>
-docker network create network_container_aplicacao_banco_restaurante </br>
5-Gerar uma imagem do conateiner da aplicação </br>
-docker build -t restaurante_aplicacao:1.0 . </br>
6-Gerar uma imagem do container do banco de dados </br>
-ir para pasta docker/bancodados </br>
-docker build -t restaurante_postgres:1.0 --build-arg DB_USER=postgres --build-arg DB_PASSWORD=postgres --build-arg DB_NAME=restaurant .</br>
7-Iniciar o container do banco de dados </br>
-docker run --name restaurante_postgres_container -d -p 5432:5432 restaurante_postgres:1.0 </br>
8-Iniciar o container da aplicação </br>
-docker run  --name restaurante_aplicacao_container --hostname restaurante-host --network network_container_aplicacao_banco_restaurante -d -p 8080:8080 restaurante_aplicacao:1.0 </br>
</p>
#Swagger
Para acessar o Swagger da aplicação
http://localhost:8080/restaurante/swagger-ui/index.html#/
</p>

#Instalação 2

<p>
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
</p>
<p>
#https://trello.com/b/66MzITVs/techchalleng-desafio-restaurante
#https://miro.com/app/board/uXjVMK9tIRA=/?share_link_id=894564369501
</p>
