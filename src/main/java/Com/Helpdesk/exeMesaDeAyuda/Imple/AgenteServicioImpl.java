package Com.Helpdesk.exeMesaDeAyuda.Imple;

import Com.Helpdesk.exeMesaDeAyuda.Repositorio.AgenteRepositorio;
import Com.Helpdesk.exeMesaDeAyuda.Servicios.AgenteServicio;
import Com.Helpdesk.exeMesaDeAyuda.dto.AgentesDTO;
import Com.Helpdesk.exeMesaDeAyuda.entidades.Agentes;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgenteServicioImpl implements AgenteServicio {

    private  final AgenteRepositorio  agenteRepositorio;
    private final ModelMapper  modelMapper;

    public AgenteServicioImpl(AgenteRepositorio agenteRepositorio, ModelMapper modelMapper) {
        this.agenteRepositorio = agenteRepositorio;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<AgentesDTO> getAllAgentes() {
        List<Agentes> listaAgente = agenteRepositorio.findAll();
        return listaAgente.stream()
                .map(a -> modelMapper
                        .map(a, AgentesDTO.class)).collect(Collectors.toList());
    }

    @Override
    public AgentesDTO getAgenteById(Long id){
        Agentes agentes =  agenteRepositorio.findById(id).orElseThrow(()-> new RuntimeException("Agente no encontrado"+ id));
        return modelMapper.map(agentes, AgentesDTO.class);
    }
    @Override
    public AgentesDTO createAgente(AgentesDTO agentesDTO) {
        Agentes  agentes = modelMapper.map(agentesDTO, Agentes.class);
        agenteRepositorio.save(agentes);
        return modelMapper.map(agentesDTO, AgentesDTO.class);
    }
    @Override
    public AgentesDTO updateAgente(Long id, AgentesDTO agentesDTO) {
        Agentes agentes = agenteRepositorio.findById(id).orElseThrow(()-> new RuntimeException("Agente no encontrado"+ id));

        modelMapper.map(agentesDTO, agentes);
        Agentes newagente = agenteRepositorio.save(agentes);
        return modelMapper.map(newagente, AgentesDTO.class);

    }
    @Override
    public boolean deleteAgente(Long id){
        if (!agenteRepositorio.existsById(id)) {
            throw new RuntimeException("Agente no encontrado"+ id);
        }
        agenteRepositorio.deleteById(id);
        return true;
    }
}
