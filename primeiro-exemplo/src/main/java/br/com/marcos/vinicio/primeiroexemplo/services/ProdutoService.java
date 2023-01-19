package br.com.marcos.vinicio.primeiroexemplo.services;

import br.com.marcos.vinicio.primeiroexemplo.model.Produto;
import br.com.marcos.vinicio.primeiroexemplo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> obterTodos() {
        return produtoRepository.obterTodos();
    }

    public Optional<Produto> obterPorId(Integer id){
        return produtoRepository.obterPorId(id);
    }

    public Produto adicionar(Produto produto) {
        // Poderia ter alguma regra de negocio para validar o produto.
        return produtoRepository.adicionar(produto);
    }

    public void deletar(Integer id) {
        // Aqui poderia ter alguma lógica de validação.
        produtoRepository.deletar(id);
    }

    public Produto atualizar(Integer id, Produto produto) {
        // Poderia ter validação do ID do produto
        produto.setId(id);
        return produtoRepository.atualizar(produto);
    }
}
