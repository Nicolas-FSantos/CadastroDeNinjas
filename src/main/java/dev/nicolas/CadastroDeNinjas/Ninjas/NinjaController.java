package dev.nicolas.CadastroDeNinjas.Ninjas;

import dev.nicolas.CadastroDeNinjas.Missoes.MissaoModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Bem-vindo!";
    }

    //add ninja
    @PostMapping("/criar")
    public String criar(){
        return "Ninja criada com sucesso!";
    }
    //show all ninjas
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "Todos";
    }

    //search ninja by id
    @GetMapping("/todosID")
    public String mostrarNinjaPorID(){
        return "Ninja ID";
    }
    //modify ninja
    @PutMapping("/alterarID")
    public String alterarNinjaPorID(){
        return "Ninja alterado!";
    }
    //delete ninja
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorID(){
        return "Ninja deletado!";
    }

}
