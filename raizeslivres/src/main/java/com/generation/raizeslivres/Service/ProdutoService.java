package com.generation.raizeslivres.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.generation.raizeslivres.Models.Produto;
import com.generation.raizeslivres.Repository.ProdutoRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findById(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElseThrow(() -> new EntityNotFoundException(
                "Produto não encontrado! Id: " + id));
    }

    @Transactional
    public Produto create(@Valid Produto produto) {
        return produtoRepository.save(produto);
    }

    public void delete(Long id) {
        produtoRepository.findById(id);
        try {
            produtoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível realizar a exclusão!");
        }
    }

    public List<Produto> getAll(){
        return produtoRepository.findAll();
    }
    
    public Optional<Produto> put (@Valid Produto produto) {
    	Optional<Produto> existeProduto = produtoRepository.findById(produto.getId());
    	if(existeProduto.isPresent())
    		return Optional.of(produtoRepository.save(produto));
    	return Optional.empty();
    
    	
    }
    
}

