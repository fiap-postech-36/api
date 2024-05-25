CREATE TABLE IF NOT EXISTS Usuario(

    id SERIAL PRIMARY KEY,
    nome varchar(50) not null,
    descricao varchar(11) not null unique,
    email varchar(50) not null unique,
    cpf varchar(11) not null unique,
    email varchar(50) not null unique
)
