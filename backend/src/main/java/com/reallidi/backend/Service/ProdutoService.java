    package com.reallidi.backend.Service;

    import com.reallidi.backend.DTO.Produto.CadastroProdutoDTO;
    import com.reallidi.backend.DTO.Produto.ProdutoDTO;
    import com.reallidi.backend.DTO.Produto.ProdutoDTOLista;
    import com.reallidi.backend.Mapper.Mapper;
    import com.reallidi.backend.Model.Produto;
    import com.reallidi.backend.Repository.ProdutoRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.stream.Collectors;

    @Service
    public class ProdutoService {

        @Autowired
        private ProdutoRepository produtoRepository;

        public Produto cadastroProduto(CadastroProdutoDTO produtoDTO){
            Produto produto = Mapper.toProdutoEntity(produtoDTO);
            return produtoRepository.save(produto);
        }

        public List<ProdutoDTOLista> getAllProdutos(){
            List<Produto> produtos = produtoRepository.findAllByOrderByNomeAsc();
            System.out.println(produtos.size());
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
