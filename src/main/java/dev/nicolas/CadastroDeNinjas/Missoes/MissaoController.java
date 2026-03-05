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

    @PostMapping("/criar")
    public String criarMissao(){
        return "Missão Criada com sucesso!";
    }

    @PutMapping("/alterar")
    public String alterarMissao(){return "Missão alterada com sucesso!";}

    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Deletado com sucesso!";
    }

}

