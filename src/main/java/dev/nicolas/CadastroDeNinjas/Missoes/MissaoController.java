package dev.nicolas.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    private MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @GetMapping("/listar")
    public List<MissaoModel> listarMissoes(){
        return missaoService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissaoModel listarMissaoPorId(@PathVariable Long id){
        return missaoService.listarMissaoPorId(id);
    }

    @PostMapping("/criar")
    public MissaoModel criarMissao(@RequestBody MissaoModel missao){
        return missaoService.criarMissao(missao);
    }

    @PutMapping("/alterar/{id}")
    public MissaoModel alterarMissao(@PathVariable Long id, @RequestBody MissaoModel missao){
        return missaoService.alterarMissaoPorId(id, missao);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id){
        missaoService.deletarMissao(id);
    }

}

