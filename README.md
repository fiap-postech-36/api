# API de Autoatendimento para Restaurante
### Descrição
Este projeto tem como objetivo atender aos requisitos do Tech Challenge da pós-graduação em Software Architecture da FIAP. O desafio consiste em desenvolver uma API de autoatendimento para autoatendimento ao cliente de um restaurante.

A API utiliza a arquitetura hexagonal, também conhecida como Arquitetura de Portas e Adaptadores (Ports and Adapters). Esta arquitetura é dividida em três camadas principais:

1. Camada de Core da Aplicação (Domínio): Esta é a camada central e isolada da aplicação, onde residem as regras de negócio. É independente de frameworks e tecnologias externas.

2. Camada de Interface (Web): Esta camada lida com a interação com o mundo exterior, incluindo as dependências do framework utilizado. Ela contém os controladores e as rotas da API, que são responsáveis por receber as solicitações dos clientes e enviar as respostas adequadas.

3. Camada de Infraestrutura (Banco de Dados): Esta camada adapta o banco de dados para se comunicar com as portas de entrada do domínio.
## Stack utilizada

**Linguagem principal:** Java 17 com Maven

**Web:** Spring Boot, Lombok

**Banco de Dados:** PostgresSQL e Flyway para versionamento do banco

**Infra:** Kubernetes provisionado pelo Docker, versão v1.29.2.

## Rodando o projeto via Docker

1. Raiz do projeto execute o comando abaixo para subir os containers:

```bash
  docker-compose up --build
```
Caso não queira bloquear o console, adicione a flag **-d** ao final do comando

2. Após a instalação, a documentação Swagger da API pode encontrada no seguinte link:

[http://localhost:8080/restaurante/swagger-ui/index.html](http://localhost:8080/restaurante/swagger-ui/index.html)


## Instalação usando Kubernetes

##### ⚠️ Atenção: recomenda-se usar as mesmas tecnologias especificadas na Stack para a criação do cluster, conforme descrito neste readme.

1. O primeiro passo é configurar o Docker Desktop para habilitar o suporte ao Kubernetes. Link do artigo de configuração recomendado [https://www.docker.com/blog/how-kubernetes-works-under-the-hood-with-docker-desktop/](https://www.docker.com/blog/how-kubernetes-works-under-the-hood-with-docker-desktop/)


2. Após a configuração, na raiz do projeto, execute o comando que irá iniciar o conjunto de arquivos necessários para o funcionamento do serviço do banco de dados.
```bash
  kubectl apply -f .\k8s\db\
```

3. Em seguida, execute o comando que iniciará o funcionamento da API.
```bash
 kubectl apply -f .\k8s\api\ 
```

4. Após a instalação, a documentação Swagger da API pode encontrada no seguinte link:

[http://localhost:30000/restaurante/swagger-ui/index.html](http://localhost:30000/restaurante/swagger-ui/index.html)


## 🔗 Links

 [![miro](https://img.shields.io/badge/Miro-050038.svg?style=for-the-badge&logo=Miro&logoColor=white)](https://miro.com/app/board/uXjVKM_0wdE=/?share_link_id=239546560997)
[![trello](https://img.shields.io/badge/Trello-0052CC.svg?style=for-the-badge&logo=Trello&logoColor=white)](https://trello.com/b/66MzITVs/techchalleng-desafio-restaurante)
## TIme de desenvolvedores

- [@danpereiramatos](https://www.github.com/danpereiramatos)
- [@samuelmteixeira](https://www.github.com/samuelmteixeira)
- [@kaiquesantos98](https://www.github.com/KaiqueSantos98)
- [@jjbazagajr](https://www.github.com/jjbazagajr)
- [@leandroibraim](https://www.github.com/leandroibraim)