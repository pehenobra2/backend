package com.reallidi.backend.Service;

import com.reallidi.backend.DTO.Categorias.CadastroCategoriaDTO;
import com.reallidi.backend.DTO.Marca.CadastroMarcaDTO;
import com.reallidi.backend.Mapper.Mapper;
import com.reallidi.backend.Model.Categorias;
import com.reallidi.backend.Model.Marcas;
import com.reallidi.backend.Repository.CategoriasRepository;
import com.reallidi.backend.Repository.MarcasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriasService {

    @Autowired
    private CategoriasRepository categoriasRepository;

    public Categorias cadastroCategoria(CadastroCategoriaDTO categoriaDTO){
        Categorias categorias = Mapper.toCategoriaEntity(categoriaDTO);
        return categoriasRepository.save(categorias);
    }

    public List<CadastroCategoriaDTO> getAllCategorias(){
        List<Categorias> categorias = categoriasRepository.findAllByOrderByNomeAsc();
        return categorias.stream()
                .map( Mapper::toCategoriaDTO)
                .collect(Collectors.toList());
    }
}
