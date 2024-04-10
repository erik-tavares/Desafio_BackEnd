package org.example.controller;

import org.example.DTO.LivroDTO;
import org.example.livroService.LivrariaService;
import org.example.model.Compra;
import org.example.model.CompraResponse;
import org.example.model.Livraria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/livraria") 
public class LivrariaController {

    private final LivrariaService livrariaService;

    @Autowired
    public LivrariaController(LivrariaService livrariaService) {
        this.livrariaService = livrariaService;
    }

    @PostMapping()
    public ResponseEntity<Livraria> adicionarLivro(@RequestBody Livraria livro) {
        try {
            Livraria novoLivro = livrariaService.criarOuAtualizarLivro(livro);
            return ResponseEntity.ok(novoLivro);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping()
    public List<Livraria> listarLivrariasComFiltros(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String generoLiterario,
            @RequestParam(required = false) String nomeAutor,
            @RequestParam(required = false) Boolean disponibilidade) {
        return livrariaService.buscarLivrarias(titulo, generoLiterario, nomeAutor, disponibilidade);
    }

    @PutMapping("{id}") // Adiciona o mapeamento PUT para este método
    public ResponseEntity<Livraria> atualizarLivro(@PathVariable Long id, @RequestBody Livraria livroDetalhes) {
        try {
            Livraria livroAtualizado = livrariaService.atualizarLivro(id, livroDetalhes);
            return ResponseEntity.ok(livroAtualizado);
        } catch (RuntimeException e) {
            // Tratamento de erro, por exemplo, se o livro não for encontrado
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/compra")
    public CompraResponse processarCompra(@RequestParam Long livroId, @RequestParam boolean estudante) {
        return livrariaService.processarCompra(livroId, estudante);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluirLivro(@PathVariable Long id) {
        try {
            if (!livrariaService.existeLivro(id)) {
                return ResponseEntity.notFound().build();
            }
            livrariaService.excluirLivro(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            // Log do erro, se necessário
            return ResponseEntity.badRequest().build();
        }
    }
}

