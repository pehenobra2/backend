package com.reallidi.backend.DTO.Cliente;

public record ClienteDTOLista(
        Long id,
        String nome,
        String email,
        String telefone,
        String endereco
        ) {}
