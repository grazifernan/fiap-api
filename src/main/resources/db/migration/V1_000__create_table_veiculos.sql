CREATE TABLE combustivel (
cod_combustivel serial PRIMARY KEY,
nome varchar(50) NOT NULL
)

CREATE TABLE estado(
cod_estado serial PRIMARY KEY,
nome varchar(50) NOT NULL,
sigla char(2) NOT NULL
)

CREATE TABLE cidade (
cod_cidade serial PRIMARY KEY,
cod_estado integer NOT NULL REFERENCES estado(cod_estado),
nome varchar(50) NOT NULL
)

CREATE TABLE cor_veiculo (
cod_cor serial PRIMARY KEY,
nome varchar(50) NOT NULL
)


CREATE TABLE empresa (
cod_empresa serial PRIMARY KEY,
cnpj integer UNIQUE NOT NULL,
razao_social varchar(200) NOT NULL,
cep varchar(8) NOT NULL,
logradouro varchar(200) NOT NULL,
bairro varchar (100) NOT NULL,
numero integer NOT NULL,
cod_cidade integer NOT NULL REFERENCES cidade(cod_cidade),
complemento varchar(200)
)

CREATE TABLE marca_veiculo (
cod_marca serial PRIMARY KEY,
descricao varchar(100) NOT NULL
)


CREATE TABLE modelo_veiculo (
cod_modelo serial PRIMARY KEY,
cod_marca integer NOT NULL REFERENCES marca_veiculo(cod_marca),
cod_combustivel integer NOT NULL REFERENCES combustivel(cod_combustivel),
ano integer NOT NULL,
descricao varchar(100) NOT NULL
)

CREATE TABLE veiculo (
cod_veiculo serial PRIMARY KEY,
cod_modelo integer NOT NULL REFERENCES modelo_veiculo(cod_modelo),
cod_cor integer NOT NULL REFERENCES cor_veiculo(cod_cor),
cod_empresa integer NOT NULL REFERENCES empresa(cod_empresa),
km integer NOT NULL,
renavam integer UNIQUE NOT NULL,
placa varchar(07) UNIQUE NOT NULL,
valor decimal(10,2),
complemento varchar(500)
)