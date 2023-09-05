CREATE TABLE produto (
  id SERIAL PRIMARY KEY UNIQUE,
  nome VARCHAR(255) NOT NULL,
  preco Float NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  foto VARCHAR(255)
);

CREATE TABLE usuario (
  id SERIAL PRIMARY KEY UNIQUE,
  nome VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  senha VARCHAR(255) NOT NULL,
  ativo BOOLEAN NOT NULL,
  foto VARCHAR(255)
);