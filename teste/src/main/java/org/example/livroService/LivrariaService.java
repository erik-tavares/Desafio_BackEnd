package org.example.livroService;

import org.example.DTO.LivroDTO; // Importa a classe LivroDTO
import org.example.model.Compra;
import org.example.model.CompraResponse;
import org.example.model.Livraria; // Importa a classe Livraria
import org.example.repository.LivrariaRepository; // Importa o repositório LivrariaRepository
import org.springframework.stereotype.Service; // Importa a anotação Service do Spring
import org.springframework.transaction.annotation.Transactional; // Importa a anotação Transactional do Spring

import java.math.BigDecimal; // Importa a classe BigDecimal
import java.util.List; // Importa a interface List
import java.util.Optional;

@Service // Indica que esta classe é um serviço gerenciado pelo Spring
public class LivrariaService {

    private final LivrariaRepository livrariaRepository; // Injeta o repositório LivrariaRepository

    public LivrariaService(LivrariaRepository livrariaRepository) {
        this.livrariaRepository = livrariaRepository;
    }

    @Transactional // Indica que as operações deste método devem ser realizadas em uma transação
    public Livraria criarOuAtualizarLivro(Livraria novoLivro) {
        // Verifica se já existe um livro com o mesmo autor
        if (!livrariaRepository.existsByNomeAutorAndSobrenomeAutor(novoLivro.getNomeAutor(), novoLivro.getSobrenomeAutor())) {
            // Se não existir, salva o novo livro no repositório
            return livrariaRepository.save(novoLivro);
        } else {
            // Caso contrário, lança uma exceção indicando que um livro com o mesmo autor já existe
            throw new RuntimeException("Um livro com este autor já existe.");
        }
    }

    @Transactional // Indica que as operações deste método devem ser realizadas em uma transação
    public Livraria atualizarLivro(Long id, Livraria livroDetalhes) {
        // Procura o livro com o ID especificado
        Livraria livro = livrariaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com id: " + id));

        // Atualiza os detalhes do livro com os fornecidos
        livro.setTitulo(livroDetalhes.getTitulo());
        livro.setGeneroLiterario(livroDetalhes.getGeneroLiterario());
        livro.setEditora(livroDetalhes.getEditora());
        livro.setDataPublicacao(livroDetalhes.getDataPublicacao());
        livro.setPreco(livroDetalhes.getPreco());
        livro.setNomeAutor(livroDetalhes.getNomeAutor());
        livro.setSobrenomeAutor(livroDetalhes.getSobrenomeAutor());
        livro.setDataNascimentoAutor(livroDetalhes.getDataNascimentoAutor());
        livro.setNacionalidadeAutor(livroDetalhes.getNacionalidadeAutor());

        // Salva as alterações no repositório e retorna o livro atualizado
        return livrariaRepository.save(livro);
    }

    public boolean existeLivro(Long id) {
        // Verifica se um livro com o ID especificado existe no repositório
        return livrariaRepository.existsById(id);
    }

    @Transactional // Indica que as operações deste método devem ser realizadas em uma transação
    public void excluirLivro(Long id) {
        // Exclui o livro com o ID especificado do repositório
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
        // Buscar o livro pelo ID
        Optional<Livraria> optionalLivro = livrariaRepository.findById(livroId);

        // Verificar se o livro foi encontrado e está disponível para venda
        if (optionalLivro.isEmpty() || !optionalLivro.get().getDisponibilidade()) {
            throw new RuntimeException("Livro não está disponível para venda.");
        }

        Livraria livro = optionalLivro.get();

        BigDecimal preco = livro.getPreco();

        // Aplicar desconto de estudante, se necessário
        if (estudante) {
            preco = preco.multiply(BigDecimal.valueOf(0.5)); // Aplica desconto de estudante
        }

        // Aqui você pode adicionar lógica para calcular o preço com base na forma de pagamento, se necessário

        // Retornar a resposta da compra
        return new CompraResponse(livro, preco);
    }


}
