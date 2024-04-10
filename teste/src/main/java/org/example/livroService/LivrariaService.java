package org.example.livroService;

import org.example.DTO.LivroDTO; 
import org.example.model.Compra;
import org.example.model.CompraResponse;
import org.example.model.Livraria; 
import org.example.repository.LivrariaRepository; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional; 

import java.math.BigDecimal; 
import java.util.List; 
import java.util.Optional;

@Service 
public class LivrariaService {

    private final LivrariaRepository livrariaRepository; 

    public LivrariaService(LivrariaRepository livrariaRepository) {
        this.livrariaRepository = livrariaRepository;
    }

    @Transactional 
    public Livraria criarOuAtualizarLivro(Livraria novoLivro) {
        if (!livrariaRepository.existsByNomeAutorAndSobrenomeAutor(novoLivro.getNomeAutor(), novoLivro.getSobrenomeAutor())) {
            return livrariaRepository.save(novoLivro);
        } else {
            throw new RuntimeException("Um livro com este autor já existe.");
        }
    }

    @Transactional 
    public Livraria atualizarLivro(Long id, Livraria livroDetalhes) {
        Livraria livro = livrariaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com id: " + id));

        livro.setTitulo(livroDetalhes.getTitulo());
        livro.setGeneroLiterario(livroDetalhes.getGeneroLiterario());
        livro.setEditora(livroDetalhes.getEditora());
        livro.setDataPublicacao(livroDetalhes.getDataPublicacao());
        livro.setPreco(livroDetalhes.getPreco());
        livro.setNomeAutor(livroDetalhes.getNomeAutor());
        livro.setSobrenomeAutor(livroDetalhes.getSobrenomeAutor());
        livro.setDataNascimentoAutor(livroDetalhes.getDataNascimentoAutor());
        livro.setNacionalidadeAutor(livroDetalhes.getNacionalidadeAutor());

        return livrariaRepository.save(livro);
    }

    public boolean existeLivro(Long id) {
        return livrariaRepository.existsById(id);
    }

    @Transactional 
    public void excluirLivro(Long id) {
        livrariaRepository.deleteById(id);
    }



    public List<Livraria> buscarLivrarias(String titulo, String generoLiterario, String nomeAutor, Boolean disponibilidade) {
        if (titulo != null && generoLiterario != null && nomeAutor != null && disponibilidade != null) {
            return livrariaRepository.findByTituloContainingAndGeneroLiterarioContainingAndNomeAutorContainingAndDisponibilidade(titulo, generoLiterario, nomeAutor, disponibilidade);
        } else if (titulo != null && generoLiterario != null && disponibilidade != null) {
            return livrariaRepository.findByTituloContainingAndGeneroLiterarioContainingAndDisponibilidade(titulo, generoLiterario, disponibilidade);
        } else if (titulo != null && nomeAutor != null && disponibilidade != null) {
            return livrariaRepository.findByTituloContainingAndNomeAutorContainingAndDisponibilidade(titulo, nomeAutor, disponibilidade);
        } else if (generoLiterario != null && nomeAutor != null && disponibilidade != null) {
            return livrariaRepository.findByGeneroLiterarioContainingAndNomeAutorContainingAndDisponibilidade(generoLiterario, nomeAutor, disponibilidade);
        } else if (titulo != null && disponibilidade != null) {
            return livrariaRepository.findByTituloContainingAndDisponibilidade(titulo, disponibilidade);
        } else if (generoLiterario != null && disponibilidade != null) {
            return livrariaRepository.findByGeneroLiterarioContainingAndDisponibilidade(generoLiterario, disponibilidade);
        } else if (nomeAutor != null && disponibilidade != null) {
            return livrariaRepository.findByNomeAutorContainingAndDisponibilidade(nomeAutor, disponibilidade);
        } else {
            return livrariaRepository.findAll();
        }
    }

    public CompraResponse processarCompra(Long livroId, boolean estudante) {
        Optional<Livraria> optionalLivro = livrariaRepository.findById(livroId);

        if (optionalLivro.isEmpty() || !optionalLivro.get().getDisponibilidade()) {
            throw new RuntimeException("Livro não está disponível para venda.");
        }

        Livraria livro = optionalLivro.get();

        BigDecimal preco = livro.getPreco();

        if (estudante) {
            preco = preco.multiply(BigDecimal.valueOf(0.5)); 
        }

        return new CompraResponse(livro, preco);
    }


}
