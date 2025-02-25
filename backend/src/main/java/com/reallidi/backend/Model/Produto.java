package com.reallidi.backend.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Data
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_produto;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 1000)
    private String descricao;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private String imagem;

    @Column(nullable = false)
    private Integer ativo;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime data_criacao;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime data_atualizacao;

}
