package com.generation.raizeslivres.Repository;

import com.generation.raizeslivres.Models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

     public Produto findAllByNomeContainingIgnoreCase(@Param("nome")String nome);
}
