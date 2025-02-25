package com.reallidi.backend.repository;

import com.reallidi.backend.model.ProdutoCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoCarrinhoRepository extends JpaRepository<ProdutoCarrinho, Long> {

}
