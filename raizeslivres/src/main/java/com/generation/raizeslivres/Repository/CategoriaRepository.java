package com.generation.raizeslivres.Repository;

import com.generation.raizeslivres.Models.Categoria;
import com.generation.raizeslivres.Models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query("SELECT p FROM Produto p WHERE p.categoria.nome = :nome")
    List<Produto> findProdutosByCategoriaNome(@Param("nome") String nome);

}
