package com.reallidi.backend.DTO.Produto;

import com.reallidi.backend.Model.Enum.Categorias;
import com.reallidi.backend.Model.Enum.SaborOuCor;

import java.math.BigDecimal;
import java.util.List;

public record CadastroProdutoDTO(
        String nome,
        String marca,
        String descricao,
        BigDecimal preco,
        String image,
        SaborOuCor saborOuCor,
        List<String> sabor_cor,
        List<Categorias> categoria,
        Integer ativo
) { }
