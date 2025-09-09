package Com.Helpdesk.exeMesaDeAyuda.Imple;

import Com.Helpdesk.exeMesaDeAyuda.Exepciones.CustomException;
import Com.Helpdesk.exeMesaDeAyuda.Repositorio.ComentarioRepositorio;
import Com.Helpdesk.exeMesaDeAyuda.Servicios.ComentarioServicio;
import Com.Helpdesk.exeMesaDeAyuda.dto.ComentarioDTO;
import Com.Helpdesk.exeMesaDeAyuda.entidades.Comentario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioServicioImpl implements ComentarioServicio {

    private final ComentarioRepositorio comentarioRepositorio;
    private final ModelMapper modelMapper;

    public ComentarioServicioImpl(ComentarioRepositorio comentarioRepositorio, ModelMapper modelMapper) {
        this.comentarioRepositorio = comentarioRepositorio;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ComentarioDTO> getAllComentarios() {
        List<Comentario> listaComentarios = comentarioRepositorio.findAll();
        return listaComentarios.stream().map(comentario -> modelMapper.map(comentario, ComentarioDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ComentarioDTO getComentarioById(Long id) {
        Comentario comentario = comentarioRepositorio.findById(id).orElseThrow(() -> new CustomException("Comentario no encontrado" + id));
        return modelMapper.map(comentario, ComentarioDTO.class);
    }

    @Override
    public ComentarioDTO createComentario(ComentarioDTO comentariosDTO) {
        Comentario comentario = modelMapper.map(comentariosDTO, Comentario.class);
        comentarioRepositorio.save(comentario);
        return modelMapper.map(comentario, ComentarioDTO.class);
    }

    @Override
    public ComentarioDTO updateComentario(Long id, ComentarioDTO comentariosDTO) {
        Comentario comentario = comentarioRepositorio.findById(id).orElseThrow(() -> new CustomException("Comentario no encontrado" + id));
        modelMapper.map(comentariosDTO, comentario);
        Comentario comentarioActu = comentarioRepositorio.save(comentario);
        return modelMapper.map(comentarioActu, ComentarioDTO.class);
    }

    @Override
    public boolean deleteComentario(Long id) {
        if (!comentarioRepositorio.existsById(id)) {
            throw new CustomException("Comentario no encontrado" + id);
        }
        comentarioRepositorio.deleteById(id);
        return true;
    }
}
