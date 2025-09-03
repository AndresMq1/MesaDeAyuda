package Com.Helpdesk.exeMesaDeAyuda.Servicios;

import Com.Helpdesk.exeMesaDeAyuda.dto.ComentariosDTO;

import java.util.List;

public interface ComentarioServicio {
    List<ComentariosDTO> getAllComentarios();
    ComentariosDTO getComentarioById(Long id);
    ComentariosDTO createComentario(ComentariosDTO comentariosDTO);
    ComentariosDTO updateComentario(ComentariosDTO comentariosDTO);
    boolean deleteComentario(Long id);

}
