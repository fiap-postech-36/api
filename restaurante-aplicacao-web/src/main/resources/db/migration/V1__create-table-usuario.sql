CREATE TABLE IF NOT EXISTS Usuario(

    idUsuario SERIAL PRIMARY KEY,
    nome varchar(50) not null,
    descricao varchar(11) not null unique,
    email varchar(50) not null unique

)
