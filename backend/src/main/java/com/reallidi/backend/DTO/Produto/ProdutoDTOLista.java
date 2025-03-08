package com.reallidi.backend.DTO.Produto;

import com.reallidi.backend.Model.Categorias;
import com.reallidi.backend.Model.Marcas;

import java.math.BigDecimal;
import java.util.List;

public record ProdutoDTOLista(
        Long id,
        String nome,
        String imagem,
        BigDecimal preco,
        Marcas marca,
        List<Categorias> categorias
) {}
