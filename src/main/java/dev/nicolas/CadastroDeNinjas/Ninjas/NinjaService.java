package dev.nicolas.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos os ninjas
    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();

        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    //Lista por ID
    public NinjaDTO listarNinjaPorId(Long id){
        Optional<NinjaModel> ninjaOptId= ninjaRepository.findById(id);
        return ninjaOptId.map(ninjaMapper::map).orElse(null);
    }

    //Criar novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    //Deletar ninja
    public void deletarNinjaPorID(Long id){
        ninjaRepository.deleteById(id);
    }

    //Alterar ninja
    public NinjaDTO alterarNinjaPorID(Long id, NinjaDTO ninjaAlterado){
        Optional<NinjaModel> ninjaOptId= ninjaRepository.findById(id);
        if(ninjaOptId.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaAlterado);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }
}
