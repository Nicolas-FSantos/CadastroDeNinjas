package dev.nicolas.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //Listar missão por id
    public MissaoModel listarMissaoPorId(Long id){
        Optional<MissaoModel> missaoOptId = missaoRepository.findById(id);
        return missaoOptId.orElse(null);
    }
}
