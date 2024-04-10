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
            // Se todos os três parâmetros estiverem presentes
            return livroService.listarLivrosPorTituloGeneroESobrenome(titulo, generoLiterario, sobrenomeAutor);
        } else if (titulo != null && generoLiterario != null) {
            // Se título e gênero literário estiverem presentes
            return livroService.listarLivrosPorTituloEGenero(titulo, generoLiterario);
        } else if (titulo != null && sobrenomeAutor != null) {
            // Se título e sobrenome do autor estiverem presentes
            return livroService.listarLivrosPorTituloESobrenome(titulo, sobrenomeAutor);
        } else if (generoLiterario != null && sobrenomeAutor != null) {
            // Se gênero literário e sobrenome do autor estiverem presentes
            return livroService.listarLivrosPorGeneroESobrenome(generoLiterario, sobrenomeAutor);
        } else if (titulo != null) {
            // Se apenas o título estiver presente
            return livroService.listarLivrosPorTitulo(titulo);
        } else if (generoLiterario != null) {
            // Se apenas o gênero literário estiver presente
            return livroService.listarLivrosPorGenero(generoLiterario);
        } else if (sobrenomeAutor != null) {
            // Se apenas o sobrenome do autor estiver presente
            return livroService.listarLivrosPorSobrenomeAutor(sobrenomeAutor);
        } else {
            // Se nenhum parâmetro estiver presente, lista todos os livros
            return livroService.listarTodosLivros();
        }
    }

}
