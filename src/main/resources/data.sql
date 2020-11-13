DROP TABLE IF EXISTS tb_aluno;

CREATE TABLE tb_aluno (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    nome VARCHAR(250) NOT NULL,
    curriculo_de_aluno VARCHAR(250) NOT NULL
);

INSERT INTO tb_aluno (nome, curriculo_de_aluno) VALUES
('Rogerio', 'nonono'),
('Maria', 'nonono'),
('Ze', 'nonono');