package com.lab.jpa.sisbiblioteca.model;

// Record: imutabilidade padrão, construtor e getters (titulo(), anoPublicacao(), nomeAutor()) implícitos.
public record LivroResumo(String titulo, Integer anoPublicacao, String nomeAutor) {
}