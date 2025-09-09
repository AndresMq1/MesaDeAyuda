package Com.Helpdesk.exeMesaDeAyuda.Servicios;

import Com.Helpdesk.exeMesaDeAyuda.dto.ComentarioDTO;

import java.util.List;

public interface ComentarioServicio {
    List<ComentarioDTO> getAllComentarios();
    ComentarioDTO getComentarioById(Long id);
    ComentarioDTO createComentario(ComentarioDTO comentariosDTO);
    ComentarioDTO updateComentario(Long id, ComentarioDTO comentariosDTO);
    boolean deleteComentario(Long id);

}
