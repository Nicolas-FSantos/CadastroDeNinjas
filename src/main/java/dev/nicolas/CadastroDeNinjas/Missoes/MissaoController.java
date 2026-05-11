package dev.nicolas.CadastroDeNinjas.Missoes;

import dev.nicolas.CadastroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<MissaoDTO>> listarMissoes(){
        return ResponseEntity.ok(missaoService.listarMissoes());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissaoPorId(@PathVariable Long id){
        MissaoDTO missaoDTO = missaoService.listarMissaoPorId(id);
        if (missaoDTO != null){
            return ResponseEntity.ok(missaoDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão de id "+ id +" não encontrada");
        }

    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissaoDTO missao){
        MissaoDTO novaMissao = missaoService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso" + novaMissao.getNome() + " (ID): " + novaMissao.getId());
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissaoDTO missao){
        MissaoDTO missaoDTO = missaoService.alterarMissaoPorId(id, missao);
        if(missaoDTO != null){
            return ResponseEntity.ok(missaoDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão de id "+ id +" não encontrada");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id){
        if (missaoService.listarMissaoPorId(id) != null){
            missaoService.deletarMissao(id);
            return ResponseEntity.ok("Missão de ID " + id + " deletada com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão de id "+ id +" não encontrada");
        }
    }

}

