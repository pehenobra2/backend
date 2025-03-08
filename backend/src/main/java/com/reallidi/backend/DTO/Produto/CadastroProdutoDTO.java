package com.reallidi.backend.DTO.Produto;

import com.reallidi.backend.Model.Categorias;
import com.reallidi.backend.Model.Enum.SaborOuCor;
import com.reallidi.backend.Model.Marcas;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

public record CadastroProdutoDTO(
        @NotBlank(message = "Nome do produto não pode ser vazio")
        String nome,

        @NotNull(message = "Marca é obrigatória")
        Marcas marca,

        @NotBlank(message = "Descrição não pode ser vazia")
        @Size(max = 1000, message = "Descrição não pode exceder 1000 caracteres")
        String descricao,

        @NotNull(message = "Preço é obrigatório")
        @DecimalMin(value = "0.01", message = "Preço deve ser maior que 0")
        BigDecimal preco,

        @NotBlank(message = "Imagem é obrigatória")
        String image,

        @NotNull(message = "Deve informar se é sabor, cor ou nenhum")
        SaborOuCor saborOuCor,

        @NotNull(message = "Se for sabor ou cor deve ser informado")
        @Size(min = 1, message = "Deve haver pelo menos um sabor ou uma cor selecionado")
        List<String> sabor_cor,

        @NotNull(message = "Categorias são obrigatórias")
        @Size(min = 1, message = "Deve haver pelo menos uma categoria selecionada")
        List<Categorias> categoria,

        @NotNull(message = "Status de ativação é obrigatório")
        @Min(value = 0, message = "Desativado = 0")
        @Max(value = 1, message = "Ativo = 1")
        Integer ativo
) { }
