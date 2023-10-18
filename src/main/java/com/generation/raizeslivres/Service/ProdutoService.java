package com.generation.raizeslivres.Service;

import com.generation.raizeslivres.Models.Dto.ProdutoDTO;
import com.generation.raizeslivres.Models.Produto;
import com.generation.raizeslivres.Repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findById(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElseThrow(() -> new EntityNotFoundException(
                "Produto não encontrado! Id: " + id));
    }

    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }


    @Transactional
    public Produto create(@Valid ProdutoDTO produtoDTO) {
        Produto createdProduto = new Produto();
        createdProduto.setId(produtoDTO.id());
        createdProduto.setNome(produtoDTO.nome());
        createdProduto.setPreco(produtoDTO.preco());
        createdProduto.setDescricao(produtoDTO.descricao());
        createdProduto.setFoto(produtoDTO.foto());
        createdProduto.setCategoria(produtoDTO.categoria());
        createdProduto.setUsuario(produtoDTO.usuario());

        return produtoRepository.save(createdProduto);
    }

    public Produto update(@Valid ProdutoDTO produtoDTO) {
        Produto updatedProduto = findById(produtoDTO.id());
        updatedProduto.setId(produtoDTO.id());
        updatedProduto.setNome(produtoDTO.nome());
        updatedProduto.setPreco(produtoDTO.preco());
        updatedProduto.setDescricao(produtoDTO.descricao());
        updatedProduto.setFoto(produtoDTO.foto());
        updatedProduto.setUsuario(produtoDTO.usuario());

        return produtoRepository.save(updatedProduto);
    }

    public void delete(Long id) {
        produtoRepository.findById(id);
        try {
            produtoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível realizar a exclusão!");
        }
    }

    public Produto getByNome(String produto){
        return produtoRepository.findAllByNomeContainingIgnoreCase(produto);
    }
}

