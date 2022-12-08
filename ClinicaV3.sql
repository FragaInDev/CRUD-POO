CREATE DATABASE clinica_medica;
USE DATABASE clinica_medica;

CREATE TABLE paciente(
    cpf char(11),
    nome varchar(255),
    telefone varchar(11),
    dataNasc varchar(30),

    primary key(cpf)
);

CREATE TABLE especialidade(
    id int,
    nome varchar(255),
    primary key(id)
);

CREATE TABLE medicamento(
    id int,
    nome varchar(255),
    primary key(id)
);

CREATE TABLE clinica(
    id int,
    nome varchar(255),
    telefone varchar(255),
    email varchar(255),
    rua varchar(255),
    bairro varchar(255),
    cep varchar(8),
    numEnd int,
    primary key(id)
);

CREATE TABLE medico(
    crm char(6),
    nome varchar(255),
    especialidadeID int,
    PRIMARY KEY(crm)
);

CREATE TABLE consulta(
    id int,
    pacienteCpf char(11),
    medicoCrm char(6),
    clinicaID int,
    data varchar(30),
    hora varchar(30),
    observacao varchar(255),
    PRIMARY KEY(id)
);

CREATE TABLE exame(
    id int,
    pacienteCpf char(11),
    medicoCrm char(6),
    clinicaID int,
    data varchar(30),
    hora varchar(30),
    diagnostico varchar(255),
    PRIMARY KEY(id)
);

CREATE TABLE prontuario(
    id int,
    pacienteCpf char(11),
    medicoCrm char(6),
    exameID int,
    consultaID int,
    medicamentoID int,
    data varchar(30),
    PRIMARY KEY(id)
);

INSERT INTO paciente VALUES('12345678901','Neymar JR','1191234567','01/04/1992');
INSERT INTO paciente VALUES('12345678902','Vinícius JR','1191234568','02/04/1992');
INSERT INTO paciente VALUES('12345678903','Richarlisson','1191234569','03/04/1992');
INSERT INTO paciente VALUES('12345678904','Lucas Paquetá','1191234561','04/04/1992');
INSERT INTO paciente VALUES('12345678905','Ronaldo','1191234562','05/04/1992');
INSERT INTO paciente VALUES('12345678906','Roberto Carlos','1191234563','06/04/1992');
INSERT INTO paciente VALUES('12345678907','Cafú','1191234564','07/04/1992');
INSERT INTO paciente VALUES('12345678908','Kaká','1191234565','08/04/1992');
INSERT INTO paciente VALUES('12345678909','Raphinha','1191234566','09/04/1992');

INSERT INTO especialidade VALUES(1,'Fisioterapia'),
(2,'Psicologia'),
(3, 'Psiquiatria'),
(4, 'Pneumologia'),
(5, 'Otorrinolaringologia'),
(6, 'Oftalmologia'),
(7, 'Urologia'),
(8, 'Nutrologia');

INSERT INTO clinica VALUES (1,'Clinica 0','1140028921','c0@bd.com','Rua 0','Bairro 0','08931999',777),
(2,'Clinica A','1140028922','ca@bd.com','Rua A','Bairro A','08932000',1),
(3,'Clinica A','1140028923','ca@bd.com','Rua A','Bairro A','08932000',2),
(4,'Clinica B','1140028924','ca@bd.com','Rua B','Bairro B','08932001',3),
(5,'Clinica C','1140028925','ca@bd.com','Rua C','Bairro C','08932002',4),
(6,'Clinica D','1140028926','ca@bd.com','Rua D','Bairro D','08932003',5),
(7,'Clinica E','1140028927','ca@bd.com','Rua E','Bairro E','08932004',6),
(8,'Clinica F','1140028928','ca@bd.com','Rua F','Bairro F','08932005',7),
(9,'Clinica G','1140028929','ca@bd.com','Rua G','Bairro G','08932006',8);

INSERT INTO medico VALUES('123456', 'Myagi',1),
('123457','House',2),
('123458','House',3),
('123459','Who',4),
('123450','Hanz',5),
('123451','Messi',6),
('123452','Cristiano',7),
('123453','Pelé',8);

INSERT INTO medicamento VALUES (1,'Dorflex'),
(2,'Dipirona'),
(3,'Benegripe'),
(4,'Fisioforte'),
(5,'Doril'),
(6,'Engov'),
(7,'Sonrisal'),
(8,'Chá'),
(9,'Novalgina');

INSERT INTO consulta VALUES(101,'12345678902','123457',1,'01/06/2022','08:00','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.'),
(102,'12345678903','123458',2,'02/06/2022','08:00','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.'),
(103,'12345678904','123459',3,'03/06/2022','09:00','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.'),
(104,'12345678905','123450',4,'04/06/2022','10:00','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.'),
(105,'12345678906','123451',5,'05/06/2022','11:00','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.'),
(106,'12345678907','123452',6,'06/06/2022','12:00','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.'),
(107,'12345678908','123453',7,'07/06/2022','13:00','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.'),
(108,'12345678909','123457',8,'08/06/2022','14:00','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.');

INSERT INTO exame VALUES(1001,'12345678902','123457',1,'01/06/2022','08:00','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.'),
(1002,'12345678903','123458',2,'02/06/2022','08:00','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.'),
(1003,'12345678904','123459',3,'03/06/2022','09:00','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.'),
(1004,'12345678905','123450',4,'04/06/2022','10:00','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.'),
(1005,'12345678906','123451',5,'05/06/2022','11:00','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.'),
(1006,'12345678907','123452',6,'06/06/2022','12:00','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.'),
(1007,'12345678908','123453',7,'07/06/2022','13:00','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.'),
(1008,'12345678909','123457',8,'08/06/2022','14:00','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.');

INSERT INTO prontuario VALUES(10001,'12345678901','123456',1001,101,1,'01/07/2022'),
(10002,'12345678902','123457',1002,102,2,'02/07/2022'),
(10003,'12345678903','123458',1003,103,3,'03/07/2022'),
(10004,'12345678904','123459',1004,104,4,'04/07/2022'),
(10005,'12345678905','123450',1005,105,5,'05/07/2022'),
(10006,'12345678906','123451',1006,106,6,'06/07/2022'),
(10007,'12345678907','123452',1007,107,7,'07/07/2022'),
(10008,'12345678908','123453',1008,108,9,'08/07/2022');