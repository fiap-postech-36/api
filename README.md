# API de Autoatendimento para Restaurante
### Descrição
Este projeto tem como objetivo atender aos requisitos do Tech Challenge da pós-graduação em Software Architecture da FIAP. O desafio consiste em desenvolver uma API de autoatendimento para autoatendimento ao cliente de um restaurante.

A API utiliza a arquitetura hexagonal, também conhecida como Arquitetura de Portas e Adaptadores (Ports and Adapters). Esta arquitetura é dividida em três camadas principais:

1. Camada de Core da Aplicação (Domínio): Esta é a camada central e isolada da aplicação, onde residem as regras de negócio. É independente de frameworks e tecnologias externas.

2. Camada de Interface (Web): Esta camada lida com a interação com o mundo exterior, incluindo as dependências do framework utilizado. Ela contém os controladores e as rotas da API, que são responsáveis por receber as solicitações dos clientes e enviar as respostas adequadas.

3. Camada de Infraestrutura (Banco de Dados): Esta camada adapta o banco de dados para se comunicar com as portas de entrada do domínio.
## Stack utilizada

**Linguagem principal:** Java com Maven

**Web:** Spring Boot, Lombok

**Banco de Dados:** PostgresSQL e Flyway para versionamento do banco


## Instalação

1. Raiz do projeto execute o comando:

```bash
  mvn package
```

Após isso vá na pasta ```restaurante-aplicacao-web/target/``` e copie o artefato ```application.jar``` para pasta ```docker/aplicacao```.

2. Depois precisa que seja gerado uma rede que conectará os dois container (aplicação e banco de dados)

```bash
  docker network create network_container_aplicacao_banco_restaurante
```
3. Após isso gere a imagem do container da aplicação:
```bash
  docker build -t restaurante_aplicacao:1.0 .
```
4. Agora acessa a pasta ```./docker/bancodados``` gere a imagem do container do banco de dados:
```bash
 docker build -t restaurante_postgres:1.0 --build-arg DB_USER=postgres --build-arg DB_PASSWORD=postgres --build-arg DB_NAME=restaurant .
```

Depois inicie o container:
```bash
 docker run --name restaurante_postgres_container -d -p 5432:5432 restaurante_postgres:1.0
```

Depois é só iniciar o container:
```bash
docker run --name restaurante_aplicacao_container --hostname restaurante-host --network network_container_aplicacao_banco_restaurante -d -p 8080:8080 restaurante_aplicacao:1.0
```

## Instalação alternativa

1. Raiz do projeto execute o comando:

```bash
  mvn package
```

2. Para gerar o image docker do projeto, execute o comando:
```bash
  mvn spring-boot:build-image
```

3. Na raiz do projeto, abra a pasta docker e execute o comando de execução do docker compose.
```bash
  cd docker
  docker compose up -d
```
## Documentação Swagger

Após a instalação, a documentação Swagger da API pode encontrada no seguinte link:

[http://localhost:8080/restaurante/swagger-ui/index.html](http://localhost:8080/restaurante/swagger-ui/index.html)


## 🔗 Links

 [![miro](https://img.shields.io/badge/Miro-050038.svg?style=for-the-badge&logo=Miro&logoColor=white)](https://miro.com/app/board/uXjVKM_0wdE=/?share_link_id=239546560997)
[![trello](https://img.shields.io/badge/Trello-0052CC.svg?style=for-the-badge&logo=Trello&logoColor=white)](https://trello.com/b/66MzITVs/techchalleng-desafio-restaurante)
## Autores

- [@danpereiramatos](https://www.github.com/danpereiramatos)
- [@samuelmteixeira](https://www.github.com/samuelmteixeira)
- [@kaiquesantos98](https://www.github.com/KaiqueSantos98)
- [@jjbazagajr](https://www.github.com/jjbazagajr)