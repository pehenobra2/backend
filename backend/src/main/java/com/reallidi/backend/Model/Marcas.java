package com.reallidi.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "marcas")
public class Marcas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_marca;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "marca")
    @JsonIgnore
    private List<Produto> produtos;

}
