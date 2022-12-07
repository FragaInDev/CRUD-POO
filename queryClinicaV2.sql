CREATE TABLE paciente(
    cpf char(11),
    nome varchar(255),
    telefone varchar(11),
    dataNasc date,

    primary key(cpf)
)

CREATE TABLE especialidade(
    id int,
    nome varchar(255),
    primary key(id)
)

CREATE TABLE medicamento(
    id int,
    nome varchar(255),
    primary key(id)
)

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
)

CREATE TABLE medico(
    crm char(6),
    nome varchar(255),
    especialidadeID int,
    PRIMARY KEY(crm),
    FOREIGN KEY (especialidadeID) REFERENCES especialidade(id)
);

CREATE TABLE consulta(
    id int,
    pacienteCpf char(11),
    medicoCrm char(6),
    clinicaID int,
    data date,
    hora time,
    observacao varchar(255),
    PRIMARY KEY(id),
    FOREIGN KEY (pacienteCpf) REFERENCES paciente(cpf),
    FOREIGN KEY (medicoCrm) REFERENCES medico(crm),
    FOREIGN KEY (clinicaID) REFERENCES clinica(id)
)

CREATE TABLE exame(
    id int,
    pacienteCpf char(11),
    medicoCrm char(6),
    clinicaID int,
    data date,
    hora time,
    diagnostico varchar(255),
    PRIMARY KEY(id),
    FOREIGN KEY (pacienteCpf) REFERENCES paciente(cpf),
    FOREIGN KEY (medicoCrm) REFERENCES medico(crm),
    FOREIGN KEY (clinicaID) REFERENCES clinica(id)
)

CREATE TABLE prontuario(
    id int,
    pacienteCpf char(11),
    medicoCrm char(6),
    exameID int,
    consultaID int,
    medicamentoID int,
    data date,
    PRIMARY KEY(id),
    FOREIGN KEY (pacienteCpf) REFERENCES paciente(cpf),
    FOREIGN KEY (medicoCrm) REFERENCES medico(crm),
    FOREIGN KEY (exameID) REFERENCES exame(id),
    FOREIGN KEY (consultaID) REFERENCES consulta(id),
    FOREIGN KEY (medicamentoID) REFERENCES medicamento(id)
)

INSERT INTO paciente VALUES('12345678901', 'Bruno Fraga', '11970842948', '2002-04-25');

INSERT INTO especialidade VALUES(1, 'Fisioterapeuta');

INSERT INTO medicamento VALUES(1, 'Dorflex');

INSERT INTO medico VALUES('123456', 'Myagi', 1);

INSERT INTO clinica VALUES(1, 'Curatudo', '1140028922', 'curatudo@bd.com', 'Rua das Dores', 777, 'Logo Ali', '12345678');

INSERT INTO consulta VALUES(1, '12345678901', '123456', 1, '2022-12-06', '11:30', 'Precisa fazer academia para fortificar as patelas do joelho.');

INSERT INTO exame VALUES(1, '12345678901', '123456', 1, '2022-12-08', '12:30', 'A academia pode ajudar a fortalecer o joelho, e um dorflex ajuda a amenizar a dor');

