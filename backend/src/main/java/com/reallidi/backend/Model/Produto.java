package com.reallidi.backend.Model;

import com.reallidi.backend.Model.Enum.Categorias;
import com.reallidi.backend.Model.Enum.SaborOuCor;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_produto;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false, length = 1000)
    private String descricao;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private String imagem;

    private SaborOuCor saborOuCor;

    @ElementCollection
    @CollectionTable(name = "produto_sabor_cor", joinColumns = @JoinColumn(name = "produto_id"))
    @Column(name = "saborCor")
    private List<String> saborCor;

    @Column(nullable = false)
    private Integer ativo;

    @Column(nullable = false)
    private List<Categorias> categoria;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime data_criacao;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime data_atualizacao;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<ProdutoCarrinho> produtoCarrinhos;

}
