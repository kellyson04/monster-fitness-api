package dev.kellyson.monster_fitness.aluno;

import dev.kellyson.monster_fitness.aluno.dto.AlunoResponse;
import dev.kellyson.monster_fitness.aluno.dto.AtualizarAlunoRequest;
import dev.kellyson.monster_fitness.aluno.dto.CadastrarAlunoRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AlunoMapper {

    public Aluno paraEntidade(CadastrarAlunoRequest request) {
        return new Aluno(
                request.nome(),
                request.cpf(),
                request.telefone(),
                request.email(),
                request.dataNascimento()
        );
    }

    public void atualizarEntidade(Aluno aluno, AtualizarAlunoRequest request) {
        aluno.atualizar(
                request.nome(),
                request.telefone(),
                request.email(),
                request.dataNascimento()
        );
    }

    public AlunoResponse paraResposta(Aluno aluno) {
        return new AlunoResponse(
                aluno.getId(),
                aluno.getNome(),
                aluno.getCpf(),
                aluno.getTelefone(),
                aluno.getEmail(),
                aluno.getDataNascimento(),
                aluno.getStatus(),
                aluno.getCriadoEm(),
                aluno.getAtualizadoEm()
        );
    }
}
