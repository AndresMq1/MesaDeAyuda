package Com.Helpdesk.exeMesaDeAyuda.Servicios;

import Com.Helpdesk.exeMesaDeAyuda.dto.AgentesDTO;

import java.util.List;

public interface AgenteServicio {
    List<AgentesDTO> getAllAgentes();
    AgentesDTO getAgenteById(Long id);
    AgentesDTO createAgente(AgentesDTO agentesDTO);
    AgentesDTO updateAgente(Long id ,AgentesDTO agentesDTO);
    boolean deleteAgente(Long id);
}
