package org.example.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "artigos")
public class Artigo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_revista", nullable = false)
    private Revista revista;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String texto;

    @Column(name = "autor_nome", nullable = false, length = 50)
    private String autorNome;

    @Column(name = "autor_sobrenome", nullable = false, length = 50)
    private String autorSobrenome;

    @Column(name = "autor_data_nascimento")
    private Date autorDataNascimento;

    @Column(name = "autor_nacionalidade", length = 50)
    private String autorNacionalidade;

    // Getters e setters
}
