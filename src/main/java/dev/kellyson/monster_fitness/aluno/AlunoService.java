package dev.kellyson.monster_fitness.aluno;

import dev.kellyson.monster_fitness.aluno.dto.AlunoResponse;
import dev.kellyson.monster_fitness.aluno.dto.AtualizarAlunoRequest;
import dev.kellyson.monster_fitness.aluno.dto.CadastrarAlunoRequest;
import dev.kellyson.monster_fitness.exception.AlunoNotFoundException;
import dev.kellyson.monster_fitness.exception.ConflictException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    @Transactional
    public void cadastrar(CadastrarAlunoRequest request) {
        if (alunoRepository.existsByCpf(request.cpf())) {
            throw new ConflictException("Já existe um aluno cadastrado com este CPF");
        }

        if (alunoRepository.existsByEmail(request.email())) {
            throw new ConflictException("Já existe um aluno cadastrado com este e-mail");
        }

        Aluno aluno = AlunoMapper.paraEntidade(request);
        alunoRepository.save(aluno);
    }

    @Transactional(readOnly = true)
    public Page<AlunoResponse> listar(Pageable pageable) {
        return alunoRepository.findAllByStatus(StatusAluno.ATIVO, pageable)
                .map(aluno -> AlunoMapper.paraResposta(aluno));
    }

    @Transactional
    public void atualizar(Long id, AtualizarAlunoRequest request) {
        Aluno aluno = buscarPorId(id);

        if (!aluno.getEmail().equals(request.email()) && alunoRepository.existsByEmail(request.email())) {
            throw new ConflictException("Já existe um aluno cadastrado com este e-mail");
        }

        AlunoMapper.atualizarEntidade(aluno, request);
    }

    @Transactional
    public void desativar(Long id) {
        Aluno aluno = buscarPorId(id);
        aluno.desativar();
    }

    private Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new AlunoNotFoundException(id));
    }
}
