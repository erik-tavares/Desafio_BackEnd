package org.example.livroService;

import org.example.model.Livro;
import org.example.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro criarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public Optional<Livro> atualizarLivro(Long id, Livro livroAtualizado) {
        return livroRepository.findById(id).map(livro -> {
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setGeneroLiterario(livroAtualizado.getGeneroLiterario());
            livro.setSobrenomeAutor(livroAtualizado.getSobrenomeAutor());
            livro.setEditora(livroAtualizado.getEditora());
            livro.setDataPublicacao(livroAtualizado.getDataPublicacao());
            return livroRepository.save(livro);
        });
    }

    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }

    public List<Livro> listarLivrosPorTituloGeneroESobrenome(String titulo, String generoLiterario, String sobrenomeAutor) {
        return livroRepository.findByTituloContainingAndGeneroLiterarioContainingAndSobrenomeAutorContaining(titulo, generoLiterario, sobrenomeAutor);
    }

    public List<Livro> listarLivrosPorTituloEGenero(String titulo, String generoLiterario) {
        return livroRepository.findByTituloContainingAndGeneroLiterarioContaining(titulo, generoLiterario);
    }

    public List<Livro> listarLivrosPorTituloESobrenome(String titulo, String sobrenomeAutor) {
        return livroRepository.findByTituloContainingAndSobrenomeAutorContaining(titulo, sobrenomeAutor);
    }

    public List<Livro> listarLivrosPorGeneroESobrenome(String generoLiterario, String sobrenomeAutor) {
        return livroRepository.findByGeneroLiterarioContainingAndSobrenomeAutorContaining(generoLiterario, sobrenomeAutor);
    }

    public List<Livro> listarLivrosPorTitulo(String titulo) {
        return livroRepository.findByTituloContaining(titulo);
    }

    public List<Livro> listarLivrosPorGenero(String generoLiterario) {
        return livroRepository.findByGeneroLiterarioContaining(generoLiterario);
    }

    public List<Livro> listarLivrosPorSobrenomeAutor(String sobrenomeAutor) {
        return livroRepository.findBySobrenomeAutorContaining(sobrenomeAutor);
    }

    public List<Livro> listarTodosLivros() {
        return livroRepository.findAll();
    }

}
