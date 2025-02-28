package com.reallidi.backend.Repository;

import com.reallidi.backend.Model.ProdutoCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoCarrinhoRepository extends JpaRepository<ProdutoCarrinho, Long> {

}
