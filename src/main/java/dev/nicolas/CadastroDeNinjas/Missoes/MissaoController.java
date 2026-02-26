package dev.nicolas.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    @GetMapping("/listar")
    public String listarMissoes(){
        return "Missões listadas com sucesso!";
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

