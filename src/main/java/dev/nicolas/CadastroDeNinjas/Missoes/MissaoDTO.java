package dev.nicolas.CadastroDeNinjas.Missoes;

import dev.nicolas.CadastroDeNinjas.Ninjas.NinjaDTO;
import dev.nicolas.CadastroDeNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissaoDTO {
    private Long id;
    private String nome;
    private String dificuldade;
}
