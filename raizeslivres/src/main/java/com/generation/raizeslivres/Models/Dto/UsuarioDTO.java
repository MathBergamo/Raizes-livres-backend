package com.generation.raizeslivres.Models.Dto;

import com.generation.raizeslivres.Models.Produto;

import java.util.List;

public record UsuarioDTO(Long id, String nome, String email, String senha, Boolean ativo, String foto) {
}
