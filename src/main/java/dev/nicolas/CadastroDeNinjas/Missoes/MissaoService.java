package dev.nicolas.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {
    private MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    //Listar todas as missões
    public List<MissaoModel> listarMissoes(){
        return missaoRepository.findAll();
    }
}
