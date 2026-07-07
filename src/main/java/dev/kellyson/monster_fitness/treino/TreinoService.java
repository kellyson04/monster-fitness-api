package dev.kellyson.monster_fitness.treino;

import dev.kellyson.monster_fitness.aluno.Aluno;
import dev.kellyson.monster_fitness.aluno.AlunoRepository;
import dev.kellyson.monster_fitness.aluno.StatusAluno;
import dev.kellyson.monster_fitness.exception.AlunoNotFoundException;
import dev.kellyson.monster_fitness.exception.ConflictException;
import dev.kellyson.monster_fitness.exception.TreinoNotFoundException;
import dev.kellyson.monster_fitness.treino.dto.AtualizarTreinoRequest;
import dev.kellyson.monster_fitness.treino.dto.CriarTreinoRequest;
import dev.kellyson.monster_fitness.treino.dto.TreinoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TreinoService {

    private final TreinoRepository treinoRepository;
    private final AlunoRepository alunoRepository;

    @Transactional
    public void criar(Long alunoId, CriarTreinoRequest request) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new AlunoNotFoundException(alunoId));

        if (aluno.getStatus() == StatusAluno.INATIVO) {
            throw new ConflictException("Não é possível criar um treino para um aluno inativo");
        }

        if (treinoRepository.existsByAlunoIdAndAtivoTrue(alunoId)) {
            throw new ConflictException("O aluno já possui um treino ativo");
        }

        Treino treino = TreinoMapper.paraEntidade(aluno, request);
        treinoRepository.save(treino);

        log.info("Treino criado com sucesso para o aluno com ID {}", alunoId);
    }

    @Transactional(readOnly = true)
    public TreinoResponse buscarTreinoDoAluno(Long alunoId) {
        Treino treino = treinoRepository.findByAlunoIdAndAtivoTrue(alunoId)
                .orElseThrow(() -> new TreinoNotFoundException(
                        "O aluno com o ID " + alunoId + " não possui treino ativo no momento"
                ));

        return TreinoMapper.paraResposta(treino);
    }

    @Transactional
    public void atualizar(Long id, AtualizarTreinoRequest request) {
        Treino treino = buscarPorId(id);
        treino.atualizar(request.nome(), request.descricao());
    }

    @Transactional
    public void desativar(Long id) {
        Treino treino = buscarPorId(id);

        if (!treino.isAtivo()) {
            throw new ConflictException("O treino já está desativado");
        }

        treino.desativar();
        log.info("Treino desativado com sucesso. treinoId={}", id);
    }

    private Treino buscarPorId(Long id) {
        return treinoRepository.findById(id)
                .orElseThrow(() -> new TreinoNotFoundException(
                        "Não existe treino cadastrado com o ID " + id
                ));
    }
}
