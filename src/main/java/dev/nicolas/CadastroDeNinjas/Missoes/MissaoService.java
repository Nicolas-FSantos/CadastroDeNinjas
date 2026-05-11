package dev.nicolas.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {
    private MissaoRepository missaoRepository;
    private MissaoMapper missaoMapper;

    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    //Listar todas as missões
    public List<MissaoDTO> listarMissoes(){
        List<MissaoModel> missoes = missaoRepository.findAll();
        return missoes.stream()
                .map(missaoMapper::map)
                .collect(Collectors.toList());
    }

    //Listar missão por id
    public MissaoDTO listarMissaoPorId(Long id){
        Optional<MissaoModel> missaoOptId = missaoRepository.findById(id);
        return missaoOptId.map(missaoMapper::map).orElse(null);
    }

    //Criar missão
    public MissaoDTO criarMissao(MissaoDTO missaoDTO){
        MissaoModel missao = missaoMapper.map(missaoDTO);
        missao = missaoRepository.save(missao);
        return missaoMapper.map(missao);
    }

    //Deletar missão
    public void deletarMissao(Long id){
        missaoRepository.deleteById(id);
    }

    //Alterar missão
    public MissaoDTO alterarMissaoPorId(Long id, MissaoDTO missaoAlterada){
        Optional<MissaoModel> missao = missaoRepository.findById(id);
        if (missao.isPresent()){
            MissaoModel missaoAtualizada = missaoMapper.map(missaoAlterada);
            missaoAtualizada.setId(id);
            return missaoMapper.map(missaoRepository.save(missaoAtualizada));
        }else
        return null;
    }
}
