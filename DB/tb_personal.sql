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
-- CREATE TABLE Personal (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     primeiro_nome VARCHAR(50) NOT NULL,
--     data_nascimento DATE,
--     email VARCHAR(100),
--     especialidade VARCHAR(100),
--     valor_aula DECIMAL(10,2)
-- );

/* EXEMPLO INSERÇÃO
INSERT INTO Personal (primeiro_nome, sobrenome, data_nascimento, email, telefone, endereco, cidade, estado, codigo_postal, pais, especialidade, valor_aula)
              VALUES ('João', 'Silva', '1990-05-15', 'joao@example.com', '123456789', 'Rua Exemplo, 123', 'Cidade Exemplo', 'Estado Exemplo', '12345-678', 'Brasil', 'Idosos', 50.00);
*/
