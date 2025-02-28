package com.reallidi.backend.DTO.Cliente;

public record CadastroClienteDTO(
        String email,
        String password,
        String nome,
        String telefone,
        String endereco
    ) {}
