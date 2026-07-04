package dev.kellyson.monster_fitness.aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);

    Page<Aluno> findAllByStatus(StatusAluno status, Pageable pageable);
}
