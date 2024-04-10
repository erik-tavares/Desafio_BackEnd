package org.example.repository;

import org.example.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByTituloContaining(String titulo);

    List<Livro> findByGeneroLiterarioContaining(String generoLiterario);

    List<Livro> findBySobrenomeAutorContaining(String sobrenomeAutor);

    List<Livro> findByTituloContainingAndGeneroLiterarioContaining(String titulo, String generoLiterario);

    List<Livro> findByTituloContainingAndSobrenomeAutorContaining(String titulo, String sobrenomeAutor);

    List<Livro> findByGeneroLiterarioContainingAndSobrenomeAutorContaining(String generoLiterario, String sobrenomeAutor);

    List<Livro> findByTituloContainingAndGeneroLiterarioContainingAndSobrenomeAutorContaining(
            String titulo, String generoLiterario, String sobrenomeAutor);

}

