package com.reallidi.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "categorias")
public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;

    @Column(nullable = false)
    private String nome;

    @ManyToMany(mappedBy = "categoria")
    @JsonIgnore
    private List<Produto> produtos;

}
