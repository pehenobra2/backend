package com.reallidi.backend.Service;

import com.reallidi.backend.DTO.Cliente.CadastroClienteDTO;
import com.reallidi.backend.DTO.Cliente.ClienteDTOLista;
import com.reallidi.backend.Mapper.Mapper;
import com.reallidi.backend.Model.Cliente;
import com.reallidi.backend.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public Cliente cadastroCliente(CadastroClienteDTO clienteDTO){
        Cliente cliente = Mapper.toClienteEntity(clienteDTO);
        return clienteRepository.save(cliente);
    }

    public List<ClienteDTOLista> getAllClientes(){
        List<Cliente> clientes = clienteRepository.findAllByOrderByNomeAsc();
        return clientes.stream()
                .map( Mapper::toClienteDTOLista)
                .collect(Collectors.toList());
    }

}
