package com.reallidi.backend.controller;

import com.reallidi.backend.model.ProdutoCarrinho;
import com.reallidi.backend.service.ProdutoCarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos-carrinho")
public class ProdutoCarrinhoController {

    @Autowired
    private ProdutoCarrinhoService produtoCarrinhoService;

    // Endpoint para buscar os produtos de um carrinho
    @GetMapping("/carrinho/{idCarrinho}")
    public ResponseEntity<List<ProdutoCarrinho>> buscarProdutosNoCarrinho(@PathVariable Long idCarrinho) {
        List<ProdutoCarrinho> produtos = produtoCarrinhoService.buscarProdutosNoCarrinho(idCarrinho);
        return ResponseEntity.ok(produtos);
    }

    // Endpoint para salvar um produto no carrinho
    @PostMapping
    public ResponseEntity<ProdutoCarrinho> salvarProdutoNoCarrinho(@RequestBody ProdutoCarrinho produtoCarrinho) {
        ProdutoCarrinho savedProdutoCarrinho = produtoCarrinhoService.salvarProdutoNoCarrinho(produtoCarrinho);
        return ResponseEntity.ok(savedProdutoCarrinho);
    }

    // Endpoint para atualizar um produto no carrinho
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoCarrinho> atualizarProdutoNoCarrinho(@PathVariable Long id, @RequestBody ProdutoCarrinho produtoCarrinho) {
        produtoCarrinho.setId_produtoCarrinho(id);
        ProdutoCarrinho updatedProdutoCarrinho = produtoCarrinhoService.atualizarProdutoNoCarrinho(produtoCarrinho);
        return ResponseEntity.ok(updatedProdutoCarrinho);
    }

    // Endpoint para excluir um produto do carrinho
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProdutoDoCarrinho(@PathVariable Long id) {
        produtoCarrinhoService.excluirProdutoDoCarrinho(id);
        return ResponseEntity.noContent().build();
    }
}
