package dev.nicolas.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissaoMapper {

    public MissaoDTO map(MissaoModel missao) {
        MissaoDTO missaoDTO = new MissaoDTO();
        missaoDTO.setId(missao.getId());
        missaoDTO.setNome(missao.getNome());
        missaoDTO.setDificuldade(missao.getDificuldade());
        return missaoDTO;
    }
    public MissaoModel map(MissaoDTO missaoDTO){
        MissaoModel missao = new MissaoModel();
        missao.setId(missaoDTO.getId());
        missao.setNome(missaoDTO.getNome());
        missao.setDificuldade(missaoDTO.getDificuldade());
        return missao;
    }
}
