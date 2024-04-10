package org.example.DTO;

import java.math.BigDecimal;

public class LivroDTO {

    private long id;
    private String titulo;
    private BigDecimal preco;
    private String generoLiterario;
    private boolean disponibilidade;
    private String nomeAutor;

    public LivroDTO(long id, String titulo, BigDecimal preco, String generoLiterario, boolean disponibilidade, String nomeAutor) {
        this.id = id;
        this.titulo = titulo;
        this.preco = preco;
        this.generoLiterario = generoLiterario;
        this.disponibilidade = disponibilidade;
        this.nomeAutor = nomeAutor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getGeneroLiterario() {
        return generoLiterario;
    }

    public void setGeneroLiterario(String generoLiterario) {
        this.generoLiterario = generoLiterario;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }
}
