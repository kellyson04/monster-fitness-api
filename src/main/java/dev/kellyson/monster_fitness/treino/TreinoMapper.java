package dev.kellyson.monster_fitness.treino;

import dev.kellyson.monster_fitness.aluno.Aluno;
import dev.kellyson.monster_fitness.treino.dto.CriarTreinoRequest;
import dev.kellyson.monster_fitness.treino.dto.TreinoResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TreinoMapper {

    public Treino paraEntidade(Aluno aluno, CriarTreinoRequest request) {
        return new Treino(aluno, request.nome(), request.descricao());
    }

    public TreinoResponse paraResposta(Treino treino) {
        return new TreinoResponse(
                treino.getId(),
                treino.getAluno().getId(),
                treino.getNome(),
                treino.getDescricao(),
                treino.isAtivo(),
                treino.getCriadoEm(),
                treino.getAtualizadoEm()
        );
    }
}
