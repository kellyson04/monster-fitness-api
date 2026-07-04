package dev.kellyson.monster_fitness.treino.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AtualizarTreinoRequest(
        @NotBlank(message = "O nome é obrigatório")
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
        String nome,

        @NotBlank(message = "A descrição é obrigatória")
        @Size(max = 10000, message = "A descrição deve ter no máximo 10000 caracteres")
        String descricao
) {
}
