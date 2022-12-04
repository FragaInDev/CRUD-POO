CREATE TABLE paciente(
    cpf char(11),
    nome char(255),
    telefone char(11),
    dataNasc date,

    primary key(cpf)
)

CREATE TABLE especialidade(
    id int,
    nome char(255),
    primary key(id)
)

CREATE TABLE medicamento(
    id int,
    nome char(255),
    primary key(id)
)

CREATE TABLE clinica(
    id int,
    nome char(255),
    telefone char(255),
    email char(255),
    rua char(255),
    bairro char(255),
    cep char(8),
    numEnd int,
    primary key(id)
)

CREATE TABLE medico(
    crm char(6),
    nome char(255),
    especialidadeID int,
    PRIMARY KEY(crm),
    FOREIGN KEY (especialidadeID) REFERENCES especialidade(id)
);

CREATE TABLE consulta(
    id int,
    pacienteCpf char(8),
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
    pacienteCpf char(8),
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
    pacienteCpf char(8),
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