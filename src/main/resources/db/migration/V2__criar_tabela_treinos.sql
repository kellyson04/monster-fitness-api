CREATE TABLE treinos (
    id BIGSERIAL PRIMARY KEY,
    aluno_id BIGINT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT NOT NULL,
    ativo BOOLEAN NOT NULL,
    criado_em TIMESTAMP WITH TIME ZONE NOT NULL,
    atualizado_em TIMESTAMP WITH TIME ZONE NOT NULL,

    CONSTRAINT fk_treinos_aluno
        FOREIGN KEY (aluno_id)
        REFERENCES alunos (id)
        ON DELETE RESTRICT
);

CREATE UNIQUE INDEX uk_treinos_aluno_ativo
    ON treinos (aluno_id)
    WHERE ativo = TRUE;
