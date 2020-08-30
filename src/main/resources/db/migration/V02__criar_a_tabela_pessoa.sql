CREATE TABLE pessoa (

    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    ativo BOOLEAN default false,
    endereco VARCHAR(50) NOT NULL,
    numero VARCHAR(50) NOT NULL,
    complemento VARCHAR(50) NOT NULL,
    bairro VARCHAR(50) NOT NULL,
    cep VARCHAR(50) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado VARCHAR(50) NOT NULL

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--INSERT INTO categoria (nome) values ('Lazer');

