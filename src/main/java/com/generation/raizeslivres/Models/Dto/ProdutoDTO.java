package com.generation.raizeslivres.Models.Dto;

import com.generation.raizeslivres.Models.Categoria;
import com.generation.raizeslivres.Models.Usuario;

public record ProdutoDTO(Long id, String nome, String descricao, Float preco, String foto, Categoria categoria, Usuario usuario) {
}
