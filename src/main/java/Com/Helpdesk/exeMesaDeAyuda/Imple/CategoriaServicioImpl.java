package Com.Helpdesk.exeMesaDeAyuda.Imple;

import Com.Helpdesk.exeMesaDeAyuda.Repositorio.CategoriaRepositorio;
import Com.Helpdesk.exeMesaDeAyuda.Servicios.CategoriaServicio;
import Com.Helpdesk.exeMesaDeAyuda.dto.CategoriasDTO;
import Com.Helpdesk.exeMesaDeAyuda.entidades.Categorias;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServicioImpl  implements CategoriaServicio {

    private final CategoriaRepositorio categoriaRepositorio;
    private final ModelMapper  modelMapper;

    public CategoriaServicioImpl(CategoriaRepositorio categoriaRepositorio, ModelMapper modelMapper) {
        this.categoriaRepositorio = categoriaRepositorio;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CategoriasDTO> getAllCategorias(){
        List<Categorias>  listaCategorias = categoriaRepositorio.findAll();
        return listaCategorias.stream().map(categoria -> modelMapper.map(categoria, CategoriasDTO.class)).collect(Collectors.toList());
    }
    @Override
    public CategoriasDTO getCategoriaById(Long id){
        Categorias categoria = categoriaRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Categoria no encontrada" + id));
        return modelMapper.map(categoria, CategoriasDTO.class);
    }
    @Override
    public CategoriasDTO createCategoria(CategoriasDTO categoriasDTO){
        Categorias categoria = modelMapper.map(categoriasDTO, Categorias.class);
        categoriaRepositorio.save(categoria);
        return modelMapper.map(categoria, CategoriasDTO.class);
    }
    @Override
    public CategoriasDTO updateCategoria(Long id,CategoriasDTO categoriasDTO){
        Categorias categorias = categoriaRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Categoria no encontrada" + id));
        modelMapper.map(categoriasDTO, categorias);
        Categorias categoriaUp = categoriaRepositorio.save(categorias);

        return modelMapper.map(categoriaUp, CategoriasDTO.class);
    }
    @Override
    public  boolean deleteCategoria(Long id){
       if(!categoriaRepositorio.existsById(id)){
           throw new RuntimeException("Categoria no encontrada" + id);
       }
       categoriaRepositorio.deleteById(id);
       return true;
    }
}
