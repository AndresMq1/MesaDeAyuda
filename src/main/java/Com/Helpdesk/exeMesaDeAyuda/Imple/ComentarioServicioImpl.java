package Com.Helpdesk.exeMesaDeAyuda.Imple;

import Com.Helpdesk.exeMesaDeAyuda.Servicios.ComentarioServicio;
import Com.Helpdesk.exeMesaDeAyuda.dto.ComentariosDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServicioImpl implements ComentarioServicio {

    @Override
    public List<ComentariosDTO> getAllComentarios(){
        return null;
    }
    @Override
    public ComentariosDTO getComentarioById(Long id){
        return null;
    }
    @Override
    public ComentariosDTO  createComentario(ComentariosDTO comentariosDTO){
        return null;
    }
    @Override
    public ComentariosDTO  updateComentario(ComentariosDTO comentariosDTO){
        return null;
    }
    @Override
    public boolean deleteComentario(Long id){
        return false;
    }
}
