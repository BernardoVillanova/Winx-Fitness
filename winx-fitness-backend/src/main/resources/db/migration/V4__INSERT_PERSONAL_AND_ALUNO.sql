USE `winxfitness`;

INSERT INTO aluno (nome, email, senha, data_nascimento, peso, altura, nivel_sedentario)
    VALUES ('João Silva', 'joao@example.com', 'aluno_password', '1990-05-15', 75.5, 1.75, 1);

INSERT INTO personal (nome, email, senha, telefone, data_nascimento, endereco, cidade, estado, cep, valor_aula, especialidade)
        VALUES ('Jose Gomes', 'jose@example.com', 'personal_password', '11999999999', '1990-05-15', 'Rua teste', 'Sao Paulo', 'SP', '01540000', 80.00, 1);
