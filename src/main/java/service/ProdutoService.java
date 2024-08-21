package service;


import model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarProduto() {
        return produtoRepository.findAll();
    }

    public Produto adicionarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizarProduto(Long id, Produto produto) {
        if(produtoRepository.existsById(id)){
            produto.setId(id);
            return produtoRepository.save(produto);
        }
        else{
            return null;
        }
    }

    public Produto buscarProdutoPorId(Long id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        return produtoOptional.orElse(null);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
