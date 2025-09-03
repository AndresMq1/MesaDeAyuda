package Com.Helpdesk.exeMesaDeAyuda.Imple;

import Com.Helpdesk.exeMesaDeAyuda.Exepciones.CustomException;
import Com.Helpdesk.exeMesaDeAyuda.Repositorio.ComentarioRepositorio;
import Com.Helpdesk.exeMesaDeAyuda.Servicios.ComentarioServicio;
import Com.Helpdesk.exeMesaDeAyuda.dto.ComentariosDTO;
import Com.Helpdesk.exeMesaDeAyuda.entidades.Comentarios;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<ComentariosDTO> getAllComentarios() {
        List<Comentarios> listaComentarios = comentarioRepositorio.findAll();
        return listaComentarios.stream().map(comentario -> modelMapper.map(comentario, ComentariosDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ComentariosDTO getComentarioById(Long id) {
        Comentarios comentario = comentarioRepositorio.findById(id).orElseThrow(() -> new CustomException("Comentario no encontrado" + id));
        return modelMapper.map(comentario, ComentariosDTO.class);
    }

    @Override
    public ComentariosDTO createComentario(ComentariosDTO comentariosDTO) {
        Comentarios comentario = modelMapper.map(comentariosDTO, Comentarios.class);
        comentarioRepositorio.save(comentario);
        return modelMapper.map(comentario, ComentariosDTO.class);
    }

    @Override
    public ComentariosDTO updateComentario(Long id, ComentariosDTO comentariosDTO) {
        Comentarios comentario = comentarioRepositorio.findById(id).orElseThrow(() -> new CustomException("Comentario no encontrado" + id));
        modelMapper.map(comentariosDTO, comentario);
        Comentarios comentarioActu = comentarioRepositorio.save(comentario);
        return modelMapper.map(comentarioActu, ComentariosDTO.class);
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
