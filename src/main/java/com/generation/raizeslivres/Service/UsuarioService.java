package com.generation.raizeslivres.Service;

import com.generation.raizeslivres.Models.Dto.UsuarioDTO;
import com.generation.raizeslivres.Models.Usuario;
import com.generation.raizeslivres.Repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElseThrow(() -> new EntityNotFoundException(
                "Usuario não encontrado! Id: " + id));
    }

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public Usuario update(@Valid UsuarioDTO usuarioDTO) {
        Usuario usuarioUpdated = findById(usuarioDTO.id());
        usuarioUpdated.setNome(usuarioDTO.nome());
        usuarioUpdated.setEmail(usuarioDTO.email());
        usuarioUpdated.setSenha(usuarioDTO.senha());
        usuarioUpdated.setAtivo(usuarioDTO.ativo());
        usuarioUpdated.setFoto(usuarioDTO.foto());

        return usuarioRepository.save(usuarioUpdated);
    }

    public void delete(Long id) {
        usuarioRepository.findById(id);
        try {
            usuarioRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível realizar a exclusão!");
        }
    }
}
