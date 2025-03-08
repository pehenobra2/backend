package com.reallidi.backend.Service;

import com.reallidi.backend.DTO.Cliente.ClienteDTOLista;
import com.reallidi.backend.DTO.Marca.CadastroMarcaDTO;
import com.reallidi.backend.Mapper.Mapper;
import com.reallidi.backend.Model.Cliente;
import com.reallidi.backend.Model.Marcas;
import com.reallidi.backend.Repository.MarcasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarcasService {

    @Autowired
    private MarcasRepository marcasRepository;

    public Marcas cadastroMarca(CadastroMarcaDTO marcaDTO){
        Marcas marca = Mapper.toMarcaEntity(marcaDTO);
        return marcasRepository.save(marca);
    }

    public List<CadastroMarcaDTO> getAllMarcas(){
        List<Marcas> marcas = marcasRepository.findAllByOrderByNomeAsc();
        return marcas.stream()
                .map( Mapper::toMarcaDTO)
                .collect(Collectors.toList());
    }

}
