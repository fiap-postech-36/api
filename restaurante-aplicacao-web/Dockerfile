FROM eclipse-temurin:17-jdk-alpine
RUN apk update
RUN apk add dos2unix
RUN apk add bash
RUN apk add maven
RUN mkdir -p /opt/app/nomeempresa/restaurante
COPY /target/*.jar /opt/app/nomeempresa/restaurante/appNomeEmpresaRestaurante.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/opt/app/nomeempresa/restaurante/appNomeEmpresaRestaurante.jar"]