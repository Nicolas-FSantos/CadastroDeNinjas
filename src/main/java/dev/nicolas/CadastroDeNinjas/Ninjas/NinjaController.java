package dev.nicolas.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Bem-vindo!";
    }

    //add ninja
    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }
    //show all ninjas
    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //search ninja by id
    @GetMapping("/listar/{id}")
    public NinjaDTO listarNinjaPorId(@PathVariable Long id){
        return ninjaService.listarNinjaPorId(id);
    }
    //modify ninja
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjaPorID(@PathVariable Long id, @RequestBody NinjaDTO ninjaAlterado){
        return ninjaService.alterarNinjaPorID(id, ninjaAlterado );
    }
    //delete ninja
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorID(@PathVariable Long id){
        ninjaService.deletarNinjaPorID(id);
    }

}
