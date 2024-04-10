package org.example.repository;

import org.example.model.Livraria;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivrariaRepository extends JpaRepository<Livraria, Long> {
    boolean existsByNomeAutorAndSobrenomeAutor(String nomeAutor, String sobrenomeAutor);

    List<Livraria> findByTituloContainingAndGeneroLiterarioContainingAndNomeAutorContainingAndDisponibilidade(
            String titulo, String generoLiterario, String nomeAutor, Boolean disponibilidade);

    List<Livraria> findByTituloContainingAndGeneroLiterarioContainingAndDisponibilidade(
            String titulo, String generoLiterario, Boolean disponibilidade);

    List<Livraria> findByTituloContainingAndNomeAutorContainingAndDisponibilidade(
            String titulo, String nomeAutor, Boolean disponibilidade);

    List<Livraria> findByGeneroLiterarioContainingAndNomeAutorContainingAndDisponibilidade(
            String generoLiterario, String nomeAutor, Boolean disponibilidade);

    List<Livraria> findByTituloContainingAndDisponibilidade(String titulo, Boolean disponibilidade);

    List<Livraria> findByGeneroLiterarioContainingAndDisponibilidade(String generoLiterario, Boolean disponibilidade);

    List<Livraria> findByNomeAutorContainingAndDisponibilidade(String nomeAutor, Boolean disponibilidade);

    Livraria findByTitulo(String titulo);
}
