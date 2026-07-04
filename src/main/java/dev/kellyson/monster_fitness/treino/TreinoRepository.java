package dev.kellyson.monster_fitness.treino;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TreinoRepository extends JpaRepository<Treino, Long> {

    boolean existsByAlunoIdAndAtivoTrue(Long alunoId);

    Optional<Treino> findByAlunoIdAndAtivoTrue(Long alunoId);
}
