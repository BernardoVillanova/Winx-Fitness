USE `winxfitness`;

CREATE TABLE IF NOT EXISTS exercicio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_exercicio VARCHAR(100) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    image MEDIUMTEXT NOT NULL
);
