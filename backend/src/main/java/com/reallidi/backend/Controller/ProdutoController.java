package com.reallidi.backend.controller;

import com.reallidi.backend.model.Produto;
import com.reallidi.backend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // Endpoint para buscar todos os produtos
    @GetMapping
    public List<Produto> buscarTodosProdutos() {
        return produtoService.buscarTodosProdutos();
    }

    // Endpoint para buscar um produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) {
        Produto produto = produtoService.buscarProdutoPorId(id);
        return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
    }

    // Endpoint para salvar um novo produto
    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
        Produto savedProduto = produtoService.salvarProduto(produto);
        return ResponseEntity.ok(savedProduto);
    }

    // Endpoint para atualizar um produto
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        produto.setId_produto(id);
        Produto updatedProduto = produtoService.atualizarProduto(produto);
        return ResponseEntity.ok(updatedProduto);
    }

    // Endpoint para excluir um produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable Long id) {
        produtoService.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }
}
