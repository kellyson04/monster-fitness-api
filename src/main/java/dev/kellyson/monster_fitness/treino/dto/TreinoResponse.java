package dev.kellyson.monster_fitness.treino.dto;

import java.time.Instant;

public record TreinoResponse(
        Long id,
        Long alunoId,
        String nome,
        String descricao,
        boolean ativo,
        Instant criadoEm,
        Instant atualizadoEm
) {
}
