CREATE TABLE usuario(
  codigo serial PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  senha VARCHAR(150) NOT NULL
)

