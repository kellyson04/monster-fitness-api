package dev.kellyson.monster_fitness.exception;

public class AlunoNotFoundException extends RuntimeException {

    public AlunoNotFoundException(Long id) {
        super("Não existe aluno cadastrado com o ID " + id);
    }
}
