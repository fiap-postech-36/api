# Etapa 1: Build
FROM maven:3.8.4-openjdk-17 AS builder

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo pom.xml e os arquivos pom dos módulos para o contêiner
COPY pom.xml .
COPY restaurante-aplicacao-banco-dados/pom.xml restaurante-aplicacao-banco-dados/
COPY restaurante-aplicacao-web/pom.xml restaurante-aplicacao-web/
COPY restaurante-application-core/pom.xml restaurante-application-core/

# Faça o download das dependências
RUN mvn dependency:go-offline

# Copie todo o código fonte do projeto para o contêiner
COPY . .

# Compile o projeto e empacote o aplicativo como um arquivo JAR
RUN mvn clean package -DskipTests

# Etapa 2: Runtime
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o JAR do estágio de build para o estágio de runtime
COPY --from=builder /app/restaurante-aplicacao-web/target/*.jar app.jar

# Conceda permissão de execução ao arquivo JAR
RUN chmod +x app.jar

# Exponha a porta em que a aplicação irá rodar
EXPOSE 8080

# Defina o comando para iniciar a aplicação
CMD ["java", "-jar", "app.jar"]