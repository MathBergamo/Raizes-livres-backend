package com.generation.raizeslivres.Controller;

import com.generation.raizeslivres.Models.Categoria;
import com.generation.raizeslivres.Models.Produto;
import com.generation.raizeslivres.Service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll() {
        return ResponseEntity.ok(categoriaService.getAll());
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria categoria) {
        Categoria createdCategoria = categoriaService.create(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategoria);
    }

    @PutMapping
    public ResponseEntity<Optional<Categoria>> update(@Valid @RequestBody Categoria categoria) {
        Optional<Categoria> updatedCategoria = categoriaService.update(categoria);
        return ResponseEntity.ok(updatedCategoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nome/{categoria}")
    public ResponseEntity<List<Produto>> getByCategoria(@PathVariable String categoria) {
        List<Produto> produtos = categoriaService.getByCategoria(categoria);
        return ResponseEntity.ok(produtos);
    }
}
