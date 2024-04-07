CREATE TABLE Personal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    primeiro_nome VARCHAR(50) NOT NULL,
    sobrenome VARCHAR(50) NOT NULL,
    data_nascimento DATE,
    email VARCHAR(100),
    telefone VARCHAR(20),
    endereco VARCHAR(255),
    cidade VARCHAR(100),
    estado VARCHAR(50),
    codigo_postal VARCHAR(20),
    pais VARCHAR(50),
    especialidade VARCHAR(100),
    valor_aula DECIMAL(10,2)
);