DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS veiculo;

-- Tabela dep
CREATE TABLE veiculo(
    n_vei int auto_increment,
    nome_vei varchar(35),
    modelo_vei varchar(20),
    ano_vei int,
    combustivel_vei varchar(20),
    consumo_vei numeric NOT NULL,
    PRIMARY KEY (n_vei)
);

INSERT INTO veiculo VALUES (DEFAULT, 'Funeraria do Japa', 'Santana Quantum', 1999, 'gasolina', 13.3);
INSERT INTO veiculo VALUES (DEFAULT, 'Van do Melo', 'Besta', 2008, 'diesel', 10);
INSERT INTO veiculo VALUES (DEFAULT, 'BibaMovel do Fabio', 'Corolla', 2010, 'flex', 15.5);
INSERT INTO veiculo VALUES (DEFAULT, 'TransTopete do Fer', 'Kia Soul', 2012, 'flex', 14.1);
INSERT INTO veiculo VALUES (DEFAULT, 'BeneMóvel', 'Fielder', 2007, 'flex', 16.0);
INSERT INTO veiculo VALUES (DEFAULT, 'Unera do Marcelo', 'Uno', 2015, 'flex', 17.3);

-- Tabela role
CREATE TABLE role(
    n_role int auto_increment,
    distancia numeric NOT NULL,
    valor_total_pedagio numeric,
    valor_litro_combustivel numeric NOT NULL,
    valor_total_combustivel numeric NOT NULL,
    consumo numeric NOT NULL,
    quant_pessoas int NOT NULL,
    valor_total_role numeric NOT NULL,
    valor_por_pessoa numeric NOT NULL,
    PRIMARY KEY (n_role)
);

INSERT INTO role VALUES (DEFAULT, 100, 20, 2.00, 20.00, 10, 4, 40.0, 10.00);
INSERT INTO role VALUES (DEFAULT,  15,  0, 3.00,  3.00, 15, 2,  3.0,  1.50);


