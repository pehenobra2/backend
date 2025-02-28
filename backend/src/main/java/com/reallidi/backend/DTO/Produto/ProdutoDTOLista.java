package com.reallidi.backend.DTO.Produto;

import java.math.BigDecimal;

public record ProdutoDTOLista(
        Long id,
        String nome,
        String imagem,
        BigDecimal preco
) {}
