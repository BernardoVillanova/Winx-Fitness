USE `winxfitness`;

CREATE TABLE IF NOT EXISTS aluno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    data_nascimento DATE,
    peso DECIMAL(5,2),
    altura DECIMAL(5,2),
    objetivo VARCHAR(100),
    nivel_fumante INT,
    nivel_sedentario INT,
    id_personal INT DEFAULT NULL,
    FOREIGN KEY (id_personal) REFERENCES personal(id)
);
