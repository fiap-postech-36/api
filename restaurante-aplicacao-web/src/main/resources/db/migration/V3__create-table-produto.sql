CREATE TABLE IF NOT EXISTS Produto(

    identificadorProduto SERIAL PRIMARY KEY,
    nome varchar(50) not null,
    descricao varchar(500) not null unique,
    urlImagem varchar(200) not null unique,
    preco decimal not null,
    categoria categoria_type
)
