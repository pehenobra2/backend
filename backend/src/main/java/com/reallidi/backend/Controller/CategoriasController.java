package com.reallidi.backend.Controller;

import com.reallidi.backend.DTO.Categorias.CadastroCategoriaDTO;
import com.reallidi.backend.DTO.Marca.CadastroMarcaDTO;
import com.reallidi.backend.Model.Categorias;
import com.reallidi.backend.Model.Marcas;
import com.reallidi.backend.Service.CategoriasService;
import com.reallidi.backend.Service.MarcasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    private CategoriasService categoriasService;

    @GetMapping
    public List<CadastroCategoriaDTO> getCategorias() {
        return categoriasService.getAllCategorias();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastroCategoria(@RequestBody @Valid CadastroCategoriaDTO categoriaDTO){
        Categorias categorias = categoriasService.cadastroCategoria(categoriaDTO);
        return new ResponseEntity<>("Categoria cadastrada com sucesso!", HttpStatus.CREATED);
    }
}
