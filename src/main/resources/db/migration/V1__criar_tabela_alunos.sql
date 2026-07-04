CREATE TABLE alunos (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(254) NOT NULL,
    data_nascimento DATE NOT NULL,
    status VARCHAR(20) NOT NULL,
    criado_em TIMESTAMP WITH TIME ZONE NOT NULL,
    atualizado_em TIMESTAMP WITH TIME ZONE NOT NULL,

    CONSTRAINT uk_alunos_cpf UNIQUE (cpf),
    CONSTRAINT uk_alunos_email UNIQUE (email),
    CONSTRAINT ck_alunos_status CHECK (status IN ('ATIVO', 'INATIVO'))
);
