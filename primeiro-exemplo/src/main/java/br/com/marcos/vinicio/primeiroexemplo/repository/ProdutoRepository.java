package br.com.marcos.vinicio.primeiroexemplo.repository;

import br.com.marcos.vinicio.primeiroexemplo.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepository {
    private List<Produto> produtos = new ArrayList<>();
    private Integer ultimoId = 0;

    /**
     * Método para retornar uma lista de produtos.
     * @return Lista de produtos
     */
    public List<Produto> obterTodos() {
        return produtos;
    }

    /**
     * Método que retorna um produto encontrado pelo seu Id.
     * @param id do produto que será localizado.
     * @return Retorna um produto caso seja encontrado.
     */
    public Optional<Produto> obterPorId(Integer id) {
        return produtos.stream().filter(produto -> produto.getId() == id).findFirst();
    }

    /**
     * Método para adicionar produto na lista.
     * @param produto que será adicionado
     * @return Retorna o produto que foi adicionado na lista.
     */
    public Produto adicionar(Produto produto) {
        ultimoId++;

        produto.setId(ultimoId);
        produtos.add(produto);

        return produto;
    }

    /**
     * Método para deletar o produto por id.
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * Método para atualizar o produto na lista
     * @param produto que será atualizado.
     * @return Retorna o produto após atualização.
     */
    public Produto atualizar(Produto produto) {
        //Encontrar o produto na lista
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
        if (produtoEncontrado.isEmpty()) {
            throw new InputMismatchException("Produto não encontrado!");
        }
        // Remover o produto encontrado da lista.
        deletar(produto.getId());
        // Adicionar o produto atualizado na lista.
        produtos.add(produto);

        return produto;
    }
}
