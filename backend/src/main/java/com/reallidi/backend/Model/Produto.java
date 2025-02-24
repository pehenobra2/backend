package com.reallidi.backend.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_produto;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private String imagem;

    @Column(nullable = false)
    private Integer ativo;

    @Column(nullable = false)
    private Data data_criacao;

    @Column(nullable = false)
    private Data data_atualizacao;

}
