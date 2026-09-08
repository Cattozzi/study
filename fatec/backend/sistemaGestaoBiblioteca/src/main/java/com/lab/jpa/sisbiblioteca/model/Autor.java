package com.lab.jpa.sisbiblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "autores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nome;

    // Adicionado nacionalidade
    @Column(length = 50)
    private String nacionalidade;

    //Modificacao: adicionado o orphanRemoval = true
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true, fetch =
            FetchType.LAZY)
    @ToString.Exclude

    private List<Livro> livros = new ArrayList<>();
    public Autor(String nome) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }
}
