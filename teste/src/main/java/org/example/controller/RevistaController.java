package org.example.controller;

import org.example.livroService.RevistaService;
import org.example.model.Revista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/revistas")
public class RevistaController {

    private final RevistaService revistaService;

    @Autowired
    public RevistaController(RevistaService revistaService) {
        this.revistaService = revistaService;
    }

    @PostMapping
    public ResponseEntity<Revista> criarRevista(@RequestBody Revista revista) {
        Revista novaRevista = revistaService.criarRevista(revista);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaRevista);
    }

    @GetMapping
    public ResponseEntity<List<Revista>> listarRevistasComFiltros(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String generoLiterario,
            @RequestParam(required = false) String sobrenomeAutor) {
        List<Revista> revistas;

        if (titulo != null && generoLiterario != null && sobrenomeAutor != null) {
            revistas = revistaService.findByTituloAndGeneroLiterarioAndSobrenomeAutor(titulo, generoLiterario, sobrenomeAutor);
        } else if (titulo != null && generoLiterario != null) {
            revistas = revistaService.findByTituloAndGeneroLiterario(titulo, generoLiterario);
        } else if (titulo != null && sobrenomeAutor != null) {
            revistas = revistaService.findByTituloAndSobrenomeAutor(titulo, sobrenomeAutor);
        } else if (generoLiterario != null && sobrenomeAutor != null) {
            revistas = revistaService.findByGeneroLiterarioAndSobrenomeAutor(generoLiterario, sobrenomeAutor);
        } else if (titulo != null) {
            revistas = revistaService.findByTitulo(titulo);
        } else if (generoLiterario != null) {
            revistas = revistaService.findByGeneroLiterario(generoLiterario);
        } else if (sobrenomeAutor != null) {
            revistas = revistaService.findBySobrenomeAutor(sobrenomeAutor);
        } else {
            revistas = revistaService.listarTodasRevistas();
        }

        return ResponseEntity.ok().body(revistas);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Revista> atualizarRevista(@PathVariable Long id, @RequestBody Revista revista) {
        Revista revistaAtualizada = revistaService.atualizarRevista(id, revista);
        if (revistaAtualizada != null) {
            return ResponseEntity.ok(revistaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRevista(@PathVariable Long id) {
        revistaService.deletarRevista(id);
        return ResponseEntity.noContent().build();
    }


}

