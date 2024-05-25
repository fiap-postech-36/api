FROM postgres:latest

ARG DB_USER
ARG DB_PASSWORD
ARG DB_NAME

# Defina variáveis de ambiente para configurar o PostgreSQL
ENV POSTGRES_USER=${DB_USER}
ENV POSTGRES_PASSWORD=${DB_PASSWORD}
ENV POSTGRES_DB=${DB_NAME}

# Exponha a porta padrão do PostgreSQL
EXPOSE 5432

# Copie um arquivo de inicialização SQL (opcional)
# COPY init.sql /docker-entrypoint-initdb.d/

# Comando de entrada padrão do PostgreSQL
CMD ["postgres"]