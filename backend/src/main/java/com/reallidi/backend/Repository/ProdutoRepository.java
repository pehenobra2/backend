package com.reallidi.backend.Repository;

import com.reallidi.backend.Model.Cliente;
import com.reallidi.backend.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findAllByOrderByNomeAsc();
    Optional<Produto> findByNome(String nome);
}
