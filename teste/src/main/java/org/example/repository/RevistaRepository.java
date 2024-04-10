package org.example.repository;

import org.example.model.Revista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RevistaRepository extends JpaRepository<Revista, Long> {

    List<Revista> findByTituloAndGeneroLiterarioAndSobrenomeAutor(String titulo, String generoLiterario, String sobrenomeAutor);

    List<Revista> findByTituloAndGeneroLiterario(String titulo, String generoLiterario);

    List<Revista> findByTituloAndSobrenomeAutor(String titulo, String sobrenomeAutor);

    List<Revista> findByGeneroLiterarioAndSobrenomeAutor(String generoLiterario, String sobrenomeAutor);

    List<Revista> findByTitulo(String titulo);

    List<Revista> findByGeneroLiterario(String generoLiterario);

    List<Revista> findBySobrenomeAutor(String sobrenomeAutor);

    @Query("SELECT r FROM Revista r")
    List<Revista> listarTodasRevistas();
}
