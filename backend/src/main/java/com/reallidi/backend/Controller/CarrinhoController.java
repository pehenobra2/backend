package com.reallidi.backend.controller;

import com.reallidi.backend.model.Carrinho;
import com.reallidi.backend.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    // Endpoint para buscar o carrinho de um cliente
    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<Carrinho> buscarCarrinhoPorCliente(@PathVariable Long idCliente) {
        Carrinho carrinho = carrinhoService.buscarCarrinhoPorCliente(idCliente);
        return carrinho != null ? ResponseEntity.ok(carrinho) : ResponseEntity.notFound().build();
    }

    // Endpoint para salvar um novo carrinho
    @PostMapping
    public ResponseEntity<Carrinho> salvarCarrinho(@RequestBody Carrinho carrinho) {
        Carrinho savedCarrinho = carrinhoService.salvarCarrinho(carrinho);
        return ResponseEntity.ok(savedCarrinho);
    }

    // Endpoint para atualizar o carrinho
    @PutMapping("/{id}")
    public ResponseEntity<Carrinho> atualizarCarrinho(@PathVariable Long id, @RequestBody Carrinho carrinho) {
        carrinho.setId_carrinho(id);
        Carrinho updatedCarrinho = carrinhoService.atualizarCarrinho(carrinho);
        return ResponseEntity.ok(updatedCarrinho);
    }

    // Endpoint para excluir um carrinho
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCarrinho(@PathVariable Long id) {
        carrinhoService.excluirCarrinho(id);
        return ResponseEntity.noContent().build();
    }
}
