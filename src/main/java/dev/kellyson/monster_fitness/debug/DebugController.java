package dev.kellyson.monster_fitness.debug;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/debug")
public class DebugController {

    @GetMapping("/erro")
    public void gerarErro() {
        throw new RuntimeException("Erro forcado para testar observabilidade");
    }
}
