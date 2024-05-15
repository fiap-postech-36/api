create table Usuario(

    id SERIAL PRIMARY KEY,
    nome varchar(50) not null,
    cpf varchar(11) not null unique,
    email varchar(50) not null unique
)
