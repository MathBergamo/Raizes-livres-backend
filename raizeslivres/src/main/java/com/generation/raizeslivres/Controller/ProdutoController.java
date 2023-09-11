package com.generation.raizeslivres.Controller;

import com.generation.raizeslivres.Models.Produto;
import com.generation.raizeslivres.Service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        Produto produto = produtoService.findById(id);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok(produtoService.getAll());
    }

    @PostMapping
    public ResponseEntity<Produto> create(@Valid @RequestBody Produto produto) {
        Produto createdProduto = produtoService.create(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @PutMapping
    public ResponseEntity<Optional<Produto>> update(@Valid @RequestBody Produto produto) {
        Optional<Produto> updatedProduto = produtoService.update(produto);
        return ResponseEntity.ok(updatedProduto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nome/{produto}")
    public ResponseEntity<Produto> getByNome(@PathVariable String produto){
        return ResponseEntity.ok(produtoService.getByNome(produto));
    }
}
