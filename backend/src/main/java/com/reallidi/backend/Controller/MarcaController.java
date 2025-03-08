package com.reallidi.backend.Controller;


import com.reallidi.backend.DTO.Cliente.CadastroClienteDTO;
import com.reallidi.backend.DTO.Marca.CadastroMarcaDTO;
import com.reallidi.backend.Model.Cliente;
import com.reallidi.backend.Model.Marcas;
import com.reallidi.backend.Service.MarcasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/marcas")
public class MarcaController {


    @Autowired
    private MarcasService marcasService;

    @GetMapping
    public List<CadastroMarcaDTO> getMarcas() {
        return marcasService.getAllMarcas();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastroMarca(@RequestBody @Valid CadastroMarcaDTO cadastroMarcaDTO){
        Marcas marcas = marcasService.cadastroMarca(cadastroMarcaDTO);
        return new ResponseEntity<>("Marca cadastrada com sucesso!", HttpStatus.CREATED);
    }

}
