package org.example.livroService;

import org.example.model.Revista;
import org.example.repository.RevistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RevistaService {

    private final RevistaRepository revistaRepository;

    @Autowired
    public RevistaService(RevistaRepository revistaRepository) {
        this.revistaRepository = revistaRepository;
    }

    public Revista criarRevista(Revista revista) {
        return revistaRepository.save(revista);
    }

    public Revista atualizarRevista(Long id, Revista revista) {
        Optional<Revista> revistaOptional = revistaRepository.findById(id);
        if (revistaOptional.isPresent()) {
            Revista revistaExistente = revistaOptional.get();
            revistaExistente.setTitulo(revista.getTitulo());
            revistaExistente.setEditora(revista.getEditora());
            revistaExistente.setNumeroEdicao(revista.getNumeroEdicao());
            revistaExistente.setDataPublicacao(revista.getDataPublicacao());
            revistaExistente.setGeneroLiterario(revista.getGeneroLiterario());
            revistaExistente.setSobrenomeAutor(revista.getSobrenomeAutor());
            return revistaRepository.save(revistaExistente);
        } else {
            return null;
        }
    }


    public List<Revista> findByTituloAndGeneroLiterarioAndSobrenomeAutor(String titulo, String generoLiterario, String sobrenomeAutor) {
        return revistaRepository.findByTituloAndGeneroLiterarioAndSobrenomeAutor(titulo, generoLiterario, sobrenomeAutor);
    }

    public List<Revista> findByTituloAndGeneroLiterario(String titulo, String generoLiterario) {
        return revistaRepository.findByTituloAndGeneroLiterario(titulo, generoLiterario);
    }

    public List<Revista> findByTituloAndSobrenomeAutor(String titulo, String sobrenomeAutor) {
        return revistaRepository.findByTituloAndSobrenomeAutor(titulo, sobrenomeAutor);
    }

    public List<Revista> findByGeneroLiterarioAndSobrenomeAutor(String generoLiterario, String sobrenomeAutor) {
        return revistaRepository.findByGeneroLiterarioAndSobrenomeAutor(generoLiterario, sobrenomeAutor);
    }

    public List<Revista> findByTitulo(String titulo) {
        return revistaRepository.findByTitulo(titulo);
    }

    public List<Revista> findByGeneroLiterario(String generoLiterario) {
        return revistaRepository.findByGeneroLiterario(generoLiterario);
    }

    public List<Revista> findBySobrenomeAutor(String sobrenomeAutor) {
        return revistaRepository.findBySobrenomeAutor(sobrenomeAutor);
    }

    public List<Revista> listarTodasRevistas() {
        return revistaRepository.listarTodasRevistas();
    }

    public void deletarRevista(Long id) {
        revistaRepository.deleteById(id);
    }
}
