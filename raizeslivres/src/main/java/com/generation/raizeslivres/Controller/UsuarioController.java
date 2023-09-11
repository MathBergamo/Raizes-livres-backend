package com.generation.raizeslivres.Controller;

import com.generation.raizeslivres.Models.Produto;
import com.generation.raizeslivres.Models.Usuario;
import com.generation.raizeslivres.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        return ResponseEntity.ok(usuarioService.getAll());
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario usuario) {
        Usuario createdUsuario = usuarioService.create(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PutMapping
    public ResponseEntity<Optional<Usuario>> update(@Valid @RequestBody Usuario usuario) {
        Optional<Usuario> updatedUsuario = usuarioService.update(usuario);
        return ResponseEntity.ok(updatedUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
