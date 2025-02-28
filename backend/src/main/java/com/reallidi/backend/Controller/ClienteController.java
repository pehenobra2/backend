package com.reallidi.backend.Controller;

import com.reallidi.backend.DTO.Cliente.CadastroClienteDTO;
import com.reallidi.backend.DTO.Cliente.ClienteDTOLista;
import com.reallidi.backend.Model.Cliente;
import com.reallidi.backend.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastroCliente(@RequestBody @Valid CadastroClienteDTO clienteDTO){
        Cliente cliente = clienteService.cadastroCliente(clienteDTO);
        return new ResponseEntity<>("Cliente cadastrado com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTOLista>> getAllClientes(){
        List<ClienteDTOLista> clientes = clienteService.getAllClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
}
