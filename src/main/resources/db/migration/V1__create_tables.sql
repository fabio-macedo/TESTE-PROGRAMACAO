CREATE TABLE funcionario (
    id BIGINT NOT NULL AUTO_INCREMENT,
    data_nascimento DATE,
    nome VARCHAR(255),
    funcao VARCHAR(255),
    salario DECIMAL(38,2),
    PRIMARY KEY (id)
) ENGINE=InnoDB;
