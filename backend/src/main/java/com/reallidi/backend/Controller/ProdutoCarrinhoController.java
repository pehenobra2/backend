package com.reallidi.backend.Controller;

import com.reallidi.backend.Model.ProdutoCarrinho;
import com.reallidi.backend.Service.ProdutoCarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos-carrinho")
public class ProdutoCarrinhoController {

    @Autowired
    private ProdutoCarrinhoService produtoCarrinhoService;


}
