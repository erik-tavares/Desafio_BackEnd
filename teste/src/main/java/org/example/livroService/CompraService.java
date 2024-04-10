package org.example.livroService;

import org.example.model.Compra;
import org.example.model.CompraResponse;
import org.example.model.Livraria;
import org.example.repository.LivrariaRepository;

import java.math.BigDecimal;

public class CompraService {
    private final LivrariaRepository livrariaRepository;

    public CompraService(LivrariaRepository livrariaRepository) {
        this.livrariaRepository = livrariaRepository;
    }

    public CompraResponse processarCompra(Compra compra) {
        Livraria livro = livrariaRepository.findByTitulo(compra.getLivroDesejado().getTitulo());

        if (livro == null || !livro.getDisponibilidade()) {
            throw new RuntimeException("Livro não está disponível para venda.");
        }

        BigDecimal preco = livro.getPreco();

        if (compra.isEstudante()) {
            preco = preco.multiply(BigDecimal.valueOf(0.5));
        }

        return new CompraResponse(livro, preco);
    }
}
