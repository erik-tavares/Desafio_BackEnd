package org.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "livraria")
public class Livraria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String titulo;

    @Column(name = "genero_literario", length = 100)
    private String generoLiterario;

    @Column(length = 100)
    private String editora;

    @Column(name = "data_publicacao")
    private LocalDate dataPublicacao;

    @Column(name = "preco", precision = 10, scale = 2)
    private BigDecimal preco;

    private Boolean disponibilidade;

    @Column(name = "nome_autor", nullable = false, length = 100)
    private String nomeAutor;

    @Column(name = "sobrenome_autor", nullable = false, length = 100)
    private String sobrenomeAutor;

    @Column(name = "data_nascimento_autor")
    private LocalDate dataNascimentoAutor;

    public String getNacionalidadeAutor() {
        return nacionalidadeAutor;
    }

    public void setNacionalidadeAutor(String nacionalidadeAutor) {
        this.nacionalidadeAutor = nacionalidadeAutor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGeneroLiterario() {
        return generoLiterario;
    }

    public void setGeneroLiterario(String generoLiterario) {
        this.generoLiterario = generoLiterario;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getSobrenomeAutor() {
        return sobrenomeAutor;
    }

    public void setSobrenomeAutor(String sobrenomeAutor) {
        this.sobrenomeAutor = sobrenomeAutor;
    }

    public LocalDate getDataNascimentoAutor() {
        return dataNascimentoAutor;
    }

    public void setDataNascimentoAutor(LocalDate dataNascimentoAutor) {
        this.dataNascimentoAutor = dataNascimentoAutor;
    }

    @Column(name = "nacionalidade_autor", length = 100)
    private String nacionalidadeAutor;



}
