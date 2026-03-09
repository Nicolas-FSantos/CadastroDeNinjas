package dev.nicolas.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    //Criar missão
    public MissaoModel criarMissao(MissaoModel missao){
        return missaoRepository.save(missao);
    }

    //Deletar missão
    public void deletarMissao(Long id){
        missaoRepository.deleteById(id);
    }

    //Alterar missão
    public MissaoModel alterarMissaoPorId(Long id, MissaoModel missaoAlterada){
        if (missaoRepository.existsById(id)){
            missaoAlterada.setId(id);
            missaoRepository.save(missaoAlterada);
        }
        return null;
    }
}
