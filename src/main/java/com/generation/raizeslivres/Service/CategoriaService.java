package com.generation.raizeslivres.Service;

import com.generation.raizeslivres.Models.Categoria;
import com.generation.raizeslivres.Models.Dto.CategoriaDTO;
import com.generation.raizeslivres.Models.Produto;
import com.generation.raizeslivres.Repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoService produtoService;

    public List<Categoria> getAll() {
        return categoriaRepository.findAll();
    }

    public Categoria findById(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElseThrow(() -> new EntityNotFoundException(
                "Categoria não encontrada! Id: " + id));
    }

    public Categoria create(CategoriaDTO categoriaDTO) {
        Categoria createdCategoria = new Categoria();
        createdCategoria.setId(categoriaDTO.id());
        createdCategoria.setNome(categoriaDTO.nome());
        createdCategoria.setAtivo(categoriaDTO.ativo());
        return categoriaRepository.save(createdCategoria);
    }

    public Categoria update(@Valid CategoriaDTO categoriaDTO) {
        Categoria updatedCategoria = findById(categoriaDTO.id());
        updatedCategoria.setId(categoriaDTO.id());
        updatedCategoria.setNome(categoriaDTO.nome());
        updatedCategoria.setAtivo(categoriaDTO.ativo());
        return categoriaRepository.save(updatedCategoria);
    }

    public void delete(Long id) {
        categoriaRepository.findById(id);
        try {
            categoriaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível realizar a exclusão!");
        }
    }

    public List<Produto> getByCategoria(String nomeCategoria) {
        return categoriaRepository.findProdutosByCategoriaNome(nomeCategoria);
    }

}
