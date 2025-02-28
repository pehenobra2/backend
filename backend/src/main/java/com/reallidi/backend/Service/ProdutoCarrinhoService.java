package com.reallidi.backend.Service;

import com.reallidi.backend.Model.ProdutoCarrinho;
import com.reallidi.backend.Repository.ProdutoCarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoCarrinhoService {

    @Autowired
    private ProdutoCarrinhoRepository produtoCarrinhoRepository;

}
