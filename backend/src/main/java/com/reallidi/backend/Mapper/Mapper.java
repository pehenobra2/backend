package com.reallidi.backend.Mapper;

import com.reallidi.backend.DTO.Cliente.CadastroClienteDTO;
import com.reallidi.backend.DTO.Cliente.ClienteDTOLista;
import com.reallidi.backend.DTO.Produto.CadastroProdutoDTO;
import com.reallidi.backend.DTO.Produto.ProdutoDTO;
import com.reallidi.backend.DTO.Produto.ProdutoDTOLista;
import com.reallidi.backend.Model.*;

public class Mapper {

    public static CadastroClienteDTO toClienteDTO(Cliente cliente){
        return new CadastroClienteDTO(
          cliente.getEmail(),
          cliente.getPassword(),
          cliente.getNome(),
          cliente.getTelefone(),
                cliente.getEndereco()
        );
    }

    public static Cliente toClienteEntity(CadastroClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setEmail(clienteDTO.email());
        cliente.setPassword(clienteDTO.password());
        cliente.setNome(clienteDTO.nome());
        cliente.setTelefone(clienteDTO.telefone());
        cliente.setEndereco(clienteDTO.endereco());

        return cliente;
    }

    public static ClienteDTOLista toClienteDTOLista(Cliente cliente){
        return new ClienteDTOLista(
                cliente.getId_cliente(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getEndereco()
        );
    }


    public static CadastroProdutoDTO toProdutoDTO(Produto produto){
        return new CadastroProdutoDTO(
                produto.getNome(),
                produto.getMarca(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getImagem(),
                produto.getSaborOuCor(),
                produto.getSaborCor(),
                produto.getCategoria(),
                produto.getAtivo()
        );
    }

    public static Produto toProdutoEntity(CadastroProdutoDTO produtoDTO){
        Produto produto = new Produto();
        produto.setNome(produtoDTO.nome());
        produto.setMarca(produtoDTO.marca());
        produto.setDescricao(produtoDTO.descricao());
        produto.setPreco(produtoDTO.preco());
        produto.setImagem(produtoDTO.image());
        produto.setSaborOuCor(produtoDTO.saborOuCor());
        produto.setSaborCor(produtoDTO.sabor_cor());
        produto.setCategoria(produtoDTO.categoria());
        produto.setAtivo(produtoDTO.ativo());

        return produto;
    }

    public static ProdutoDTOLista toProdutoDTOLista(Produto produto){
        return new ProdutoDTOLista(
                produto.getId_produto(),
                produto.getNome(),
                produto.getImagem(),
                produto.getPreco()
        );
    }

    public static ProdutoDTO toProdutoUnicoDTO(Produto produto){
        return new ProdutoDTO(
                produto.getNome(),
                produto.getMarca(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getImagem(),
                produto.getSaborOuCor(),
                produto.getSaborCor()
        );
    }

    public static Produto toProdutoUnicoEntity(ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        produto.setNome(produtoDTO.nome());
        produto.setMarca(produtoDTO.marca());
        produto.setDescricao(produtoDTO.descricao());
        produto.setPreco(produtoDTO.preco());
        produto.setSaborOuCor(produtoDTO.saborOuCor());
        produto.setSaborCor(produtoDTO.sabor_cor());

        return produto;
    }

}
