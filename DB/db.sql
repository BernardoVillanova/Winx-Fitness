CREATE TABLE aluno (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    data_nascimento DATE,
    peso DECIMAL(5,2),
    altura DECIMAL(5,2),
    nivel_sedentario INT,
    id_personal INT,
    PRIMARY KEY (id),
    FOREIGN KEY (id_personal) REFERENCES personal(id)
);

CREATE TABLE personal (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    telefone VARCHAR(20),
    data_nascimento DATE,
    endereco VARCHAR(255) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    estado VARCHAR(100) NOT NULL,
    cep INT,
    valor_aula DECIMAL(12,4),
    especialidade INT,
    PRIMARY KEY (id)
);

CREATE TABLE exercicio (
    id INT NOT NULL AUTO_INCREMENT,
    nome_exercicio VARCHAR(100) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    image MEDIUMTEXT NOT NULL,
    PRIMARY KEY (id)
);