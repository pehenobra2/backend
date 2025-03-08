package com.reallidi.backend.Service;

import com.reallidi.backend.DTO.Produto.CadastroProdutoDTO;
import com.reallidi.backend.DTO.Produto.ProdutoDTO;
import com.reallidi.backend.DTO.Produto.ProdutoDTOLista;
import com.reallidi.backend.Mapper.Mapper;
import com.reallidi.backend.Model.Categorias;
import com.reallidi.backend.Model.Enum.SaborOuCor;
import com.reallidi.backend.Model.Marcas;
import com.reallidi.backend.Model.Produto;
import com.reallidi.backend.Repository.CategoriasRepository;
import com.reallidi.backend.Repository.MarcasRepository;
import com.reallidi.backend.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private MarcasRepository marcasRepository;

    @Autowired
    private CategoriasRepository categoriasRepository;

    public Produto cadastroProduto(CadastroProdutoDTO produtoDTO) {
        // Verificar se a marca já existe no banco
        Marcas marcaExistente = marcasRepository.findByNome(produtoDTO.marca().getNome());

        if (marcaExistente == null) {
            throw new RuntimeException("A marca '" + produtoDTO.marca().getNome() + "' não está cadastrada.");
        }

        // Verificar se todas as categorias informadas existem no banco
        List<String> nomesCategorias = produtoDTO.categoria().stream()
                .map(Categorias::getNome)
                .collect(Collectors.toList());

        List<Categorias> categoriasExistentes = categoriasRepository.findAllByNomeIn(nomesCategorias);

        if (categoriasExistentes.size() != nomesCategorias.size()) {
            throw new RuntimeException("Uma ou mais categorias informadas não estão cadastradas no sistema.");
        }

        // Garantir que o sabor_ou_cor seja um valor válido do enum SaborOuCor.
        SaborOuCor saborOuCor = produtoDTO.saborOuCor();

        Produto produto = Mapper.toProdutoEntity(produtoDTO);
        produto.setMarca(marcaExistente);
        produto.setSaborOuCor(saborOuCor);
        produto.setCategoria(categoriasExistentes); // Agora só usa categorias que já existem

        return produtoRepository.save(produto);
    }



    public List<ProdutoDTOLista> getAllProdutos(){
        List<Produto> produtos = produtoRepository.findAllByOrderByNomeAsc();
        return produtos.stream()
                .map(Mapper::toProdutoDTOLista)
                .collect(Collectors.toList());
    }

    public ProdutoDTO getOneProduto(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return Mapper.toProdutoUnicoDTO(produto);
    }
}
