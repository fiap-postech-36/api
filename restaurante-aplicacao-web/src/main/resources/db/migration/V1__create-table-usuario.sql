CREATE TABLE IF NOT EXISTS Usuario(

    id SERIAL PRIMARY KEY,
    nome varchar(50) not null,
    email varchar(50) not null unique,
    cpf varchar(11) not null unique
)
