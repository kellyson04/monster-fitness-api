package dev.kellyson.monster_fitness.treino;

import dev.kellyson.monster_fitness.treino.dto.AtualizarTreinoRequest;
import dev.kellyson.monster_fitness.treino.dto.CriarTreinoRequest;
import dev.kellyson.monster_fitness.treino.dto.TreinoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/treinos")
@RequiredArgsConstructor
public class TreinoController {

    private final TreinoService treinoService;

    @PostMapping("/aluno/{alunoId}")
    public ResponseEntity<Void> criar(@PathVariable Long alunoId, @Valid @RequestBody CriarTreinoRequest request) {
        treinoService.criar(alunoId, request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<TreinoResponse> buscarTreinoDoAluno(@PathVariable Long alunoId) {
        return ResponseEntity.status(HttpStatus.OK).body(treinoService.buscarTreinoDoAluno(alunoId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @Valid @RequestBody AtualizarTreinoRequest request) {
        treinoService.atualizar(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/{id}/desativar")
    public ResponseEntity<Void> desativar(@PathVariable Long id) {
        treinoService.desativar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
