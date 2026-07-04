package dev.kellyson.monster_fitness.aluno.dto;

import dev.kellyson.monster_fitness.aluno.StatusAluno;

import java.time.Instant;
import java.time.LocalDate;

public record AlunoResponse(
        Long id,
        String nome,
        String cpf,
        String telefone,
        String email,
        LocalDate dataNascimento,
        StatusAluno status,
        Instant criadoEm,
        Instant atualizadoEm
) {
}
