package com.reallidi.backend.DTO.Produto;

import com.reallidi.backend.Model.Enum.SaborOuCor;
import com.reallidi.backend.Model.Marcas;

import java.math.BigDecimal;
import java.util.List;

public record ProdutoDTO(
        String nome,
        Marcas marca,
        String descricao,
        BigDecimal preco,
        String imagem,
        SaborOuCor saborOuCor,
        List<String> sabor_cor
) { }
