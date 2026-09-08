
package com.lab.jpa.sisbiblioteca.config;
import com.lab.jpa.sisbiblioteca.model.Autor;
import com.lab.jpa.sisbiblioteca.model.Livro;
import com.lab.jpa.sisbiblioteca.model.LivroResumo;
import com.lab.jpa.sisbiblioteca.repository.AutorRepository;
import com.lab.jpa.sisbiblioteca.repository.LivroRepository;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

@Component
public class DataInitializer implements CommandLineRunner {
    private final AutorRepository autorRepository;
    private final LivroRepository livroRepository;
    public DataInitializer(AutorRepository autorRepository, LivroRepository
            livroRepository) {
        this.autorRepository = autorRepository;
        this.livroRepository = livroRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        var scanner = new Scanner(System.in);
        var continuar = true;
        System.out.println("==========================================");
        System.out.println("   SISTEMA DE GESTÃO DE BIBLIOTECA JPA    ");
        System.out.println("==========================================");
        while (continuar) {
            System.out.println("\nMENU DE OPÇÕES:");
            System.out.println("1 - Cadastrar Autor");
            System.out.println("2 - Listar Autores");
            System.out.println("3 - Cadastrar Livro");
            System.out.println("4 - Listar Livros");
            System.out.println("5 - Buscar Livros por Autor"); // Novo item
            System.out.println("6 - Buscar Autor por Nome"); // Novo Item
            System.out.println("7 - Estatísticas da Biblioteca"); // Novo Item

            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            var opcao = scanner.nextLine();
            continuar = switch (opcao) {
                case "1" -> {
                    cadastrarAutor(scanner);
                    yield true;
                }
                case "2" -> {
                    listarAutores();
                    yield true;
                }
                case "3" -> {
                    cadastrarLivro(scanner);
                    yield true;
                }
                case "4" -> {
                    listarLivros();
                    yield true;
                }
                case "5" -> {
                    buscarLivrosPorAutor(scanner);
                    yield true; }
                case "6" -> {
                    buscarAutorPorNome(scanner);
                    yield true; }
                case "7" -> {
                    exibirEstatisticas();
                    yield true; }
                case "0" -> {
                    System.out.println("Encerrando aplicação...");
                    yield false;
                }
                default -> {
                    System.out.println("Opção inválida! Tente novamente.");
                    yield true;
                }
            };
        }
        System.out.println("Aplicação finalizada.");
    }
    private void cadastrarAutor(Scanner scanner) {
        System.out.print("Digite o nome do autor: ");
        var nome = scanner.nextLine();
        if (nome.isBlank()) {
            System.out.println("Nome inválido!");
            return;
        }
        var autor = new Autor(nome);
        autorRepository.save(autor);
        System.out.println(">>> Autor '" + autor.getNome() + "' cadastrado com ID: "
                + autor.getId());
    }
    private void listarAutores() {
        var autores = autorRepository.findAll();
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor cadastrado.");
            return;
        }
        System.out.println("\n--- LISTA DE AUTORES ---");
        autores.forEach(a -> System.out.printf("ID: %d | Nome: %s%n", a.getId(),
                a.getNome()));
        System.out.println("------------------------");
    }
    private void cadastrarLivro(Scanner scanner) {
        listarAutores();
        System.out.print("Informe o ID do autor do livro: ");
        var idStr = scanner.nextLine();
        try {
            var autorId = Long.parseLong(idStr);
            Optional<Autor> autorOpt = autorRepository.findById(autorId);
            if (autorOpt.isEmpty()) {
                System.out.println("Autor não encontrado com o ID informado!");
                return;
            }
            System.out.print("Digite o título do livro: ");
            var titulo = scanner.nextLine();
            System.out.print("Digite o ano de publicação: ");
            var ano = Integer.parseInt(scanner.nextLine());
            var livro = new Livro(titulo, ano, autorOpt.get());
            livroRepository.save(livro);
            System.out.println(">>> Livro '" + livro.getTitulo() + "' cadastrado com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("Valor numérico inválido informado.");
        }
    }
    private void listarLivros() {
        var livros = livroRepository.findAll();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        System.out.println("\n--- LISTA DE LIVROS ---");
        livros.forEach(l -> System.out.printf("ID: %d | Título: %s | Ano: %d | Autor: %s%n",
        l.getId(), l.getTitulo(), l.getAnoPublicacao(),
                l.getAutor().getNome()));
        System.out.println("-----------------------");
    }
    //Adicionado a busca de livros por autor
    private void buscarLivrosPorAutor(Scanner scanner) {
        System.out.print("Informe o ID do autor para buscar seus livros: ");
        var idStr = scanner.nextLine();
        try {
            var autorId = Long.parseLong(idStr);
            Optional<Autor> autorOpt = autorRepository.findById(autorId);

            if (autorOpt.isPresent()) {
                // Utilizando o método do repositório
                var livros = livroRepository.findByAutor(autorOpt.get());
                if (livros.isEmpty()) {
                    System.out.println("Nenhum livro encontrado para o autor: " + autorOpt.get().getNome());
                } else {
                    System.out.println("\n--- LIVROS DE " + autorOpt.get().getNome().toUpperCase() + " ---");
                    livros.forEach(l -> System.out.printf("ID: %d | Título: %s | Ano: %d%n",
                            l.getId(), l.getTitulo(), l.getAnoPublicacao()));
                    System.out.println("-----------------------");
                }
            } else {
                System.out.println("Autor não encontrado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");

        }
    }
    // --- 4. NOVOS MÉTODOS  ---

    private void buscarAutorPorNome(Scanner scanner) {
        System.out.print("Digite parte do nome do autor: ");
        var termo = scanner.nextLine();

        // 3. Uso da consulta derivada
        var autores = autorRepository.findByNomeContainingIgnoreCase(termo);

        if (autores.isEmpty()) {
            System.out.println("Nenhum autor encontrado com o termo: " + termo);
        } else {
            System.out.println("\n--- RESULTADO DA BUSCA ---");
            // Uso de Method Reference (Autor::getNome e System.out::println)
            autores.stream()
                    .map(Autor::getNome)
                    .forEach(System.out::println);
            System.out.println("--------------------------");
        }
    }

    private void exibirEstatisticas() {
        var livros = livroRepository.findAll();
        if (livros.isEmpty()) {
            System.out.println("Biblioteca vazia. Nenhuma estatística disponível.");
            return;
        }

        System.out.println("\n=== ESTATÍSTICAS DA BIBLIOTECA ===");

        // 2. Operação de Redução (.min) com Optional
        livros.stream()
                .min(Comparator.comparingInt(Livro::getAnoPublicacao)) // Method reference comparando inteiros
                .ifPresentOrElse(
                        l -> System.out.printf("► Livro mais antigo: '%s', Publicado em %d.%n",
                                l.getTitulo(), l.getAnoPublicacao()),
                        () -> System.out.println("► Não foi possível determinar o livro mais antigo.")
                );

        System.out.println("\n► Livros Recentes (A partir do ano 2000):");

        // 1. Pipeline completo (filter -> map -> sorted -> forEach)
        var recentes = livros.stream()
                .filter(l -> l.getAnoPublicacao() >= 2000)
                // Mapeando a entidade JPA pesada para o Record leve
                .map(l -> new LivroResumo(l.getTitulo(), l.getAnoPublicacao(), l.getAutor().getNome()))
                // Ordenando do mais novo para o mais antigo (reversed)
                .sorted(Comparator.comparingInt(LivroResumo::anoPublicacao).reversed())
                .toList(); // Retorna uma coleção não modificável

        if (recentes.isEmpty()) {
            System.out.println("  Nenhum livro recente cadastrado.");
        } else {
            recentes.forEach(lr -> System.out.printf("  - %s (%d) por %s%n",
                    lr.titulo(), lr.anoPublicacao(), lr.nomeAutor()));
        }
        System.out.println("==================================");
    }
}



