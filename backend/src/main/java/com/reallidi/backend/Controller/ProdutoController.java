package com.reallidi.backend.Controller;

import com.reallidi.backend.DTO.Produto.CadastroProdutoDTO;
import com.reallidi.backend.DTO.Produto.ProdutoDTO;
import com.reallidi.backend.DTO.Produto.ProdutoDTOLista;
import com.reallidi.backend.Model.Produto;
import com.reallidi.backend.Repository.ProdutoRepository;
import com.reallidi.backend.Service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastroProduto(@RequestBody @Valid CadastroProdutoDTO produtoDTO){
        Produto produto = produtoService.cadastroProduto(produtoDTO);
        return new ResponseEntity<>("Produto cadastrado com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTOLista>> getAllProdutos(){
        List<ProdutoDTOLista> produtos = produtoService.getAllProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getOneProduto(@PathVariable Long id){
        ProdutoDTO produto = produtoService.getOneProduto(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }


}
