package org.example.controller;

import org.example.livroService.LivroService;
import org.example.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public Livro criarLivro(@RequestBody Livro livro) {
        return livroService.criarLivro(livro);
    }

    @PutMapping("/{id}")
    public Livro atualizarLivro(@PathVariable Long id, @RequestBody Livro livro) {
        return livroService.atualizarLivro(id, livro).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);
    }

    @GetMapping
    public List<Livro> listarLivrosComFiltros(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String generoLiterario,
            @RequestParam(required = false) String sobrenomeAutor) {

        if (titulo != null && generoLiterario != null && sobrenomeAutor != null) {
            return livroService.listarLivrosPorTituloGeneroESobrenome(titulo, generoLiterario, sobrenomeAutor);
        } else if (titulo != null && generoLiterario != null) {
            return livroService.listarLivrosPorTituloEGenero(titulo, generoLiterario);
        } else if (titulo != null && sobrenomeAutor != null) {
            return livroService.listarLivrosPorTituloESobrenome(titulo, sobrenomeAutor);
        } else if (generoLiterario != null && sobrenomeAutor != null) {
            return livroService.listarLivrosPorGeneroESobrenome(generoLiterario, sobrenomeAutor);
        } else if (titulo != null) {
            return livroService.listarLivrosPorTitulo(titulo);
        } else if (generoLiterario != null) {
            return livroService.listarLivrosPorGenero(generoLiterario);
        } else if (sobrenomeAutor != null) {
            return livroService.listarLivrosPorSobrenomeAutor(sobrenomeAutor);
        } else {
            return livroService.listarTodosLivros();
        }
    }

}
