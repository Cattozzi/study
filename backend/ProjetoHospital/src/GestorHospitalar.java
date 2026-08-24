import java.util.Scanner;

public class GestorHospitalar {
    private final Scanner scanner = new Scanner(System.in);
    private final Hospital hospital = new Hospital();

    public static void main(String[] args) {
        new GestorHospitalar().exibirMenu();
    }

    public void exibirMenu() {
        boolean executando = true;

        while (executando) {
            System.out.println("\n--- Sistema de Gestão Hospitalar e Triagem ---");
            System.out.println("1. Admitir Paciente");
            System.out.println("2. Relatório de Triagem");
            System.out.println("3. Painel de Estatísticas");
            System.out.println("4. Buscar Caso de Risco");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = Integer.parseInt(scanner.nextLine());

            // Switch Expression para o menu
            switch (opcao) {
                case 1 -> execAdmissao();
                case 2 -> execTriagemGeral();
                case 3 -> execEstatisticas();
                case 4 -> execBuscaAvancada();
                case 5 -> {
                    executando = false;
                    System.out.println("Encerrando o sistema...");
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private void execAdmissao() {
        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Idade: ");
            int idade = Integer.parseInt(scanner.nextLine());

            System.out.println("Níveis: 1-LEVE, 2-MODERADO, 3-URGENTE, 4-CRITICO");
            System.out.print("Escolha o nível: ");
            int nivelOpc = Integer.parseInt(scanner.nextLine());

            // Switch Expression para mapear o Enum
            NivelEmergencia nivel = switch (nivelOpc) {
                case 1 -> NivelEmergencia.LEVE;
                case 2 -> NivelEmergencia.MODERADO;
                case 3 -> NivelEmergencia.URGENTE;
                case 4 -> NivelEmergencia.CRITICO;
                default -> throw new IllegalArgumentException("Nível de emergência inválido.");
            };

            System.out.print("Possui plano de saúde? (s/n): ");
            boolean possuiPlano = scanner.nextLine().equalsIgnoreCase("s");

            Paciente p = new Paciente(nome, idade, nivel, possuiPlano);
            hospital.admitir(p);
            System.out.println(" Paciente admitido com sucesso!");

        } catch (Exception e) {
            System.out.println(" Erro na admissão: " + e.getMessage());
        }
    }

    private void execTriagemGeral() {
        var emergenciais = hospital.listarEmergenciais();
        System.out.println("\n--- Relatório de Triagem (Urgentes e Críticos) ---");

        if (emergenciais.isEmpty()) {
            System.out.println("Nenhum paciente em estado de urgência ou crítico no momento.");
        } else {
            // forEach funcional com Method Reference
            emergenciais.forEach(System.out::println);
        }
    }

    private void execEstatisticas() {
        System.out.println("\n--- Painel de Estatísticas ---");
        System.out.println("Total de pacientes segurados: " + hospital.contarSegurados());

        // Processamento seguro do OptionalDouble com ifPresentOrElse
        hospital.calcularMediaIdadeCriticos().ifPresentOrElse(
                media -> System.out.printf("Média de idade dos pacientes CRÍTICOS: %.2f anos\n", media),
                () -> System.out.println("Média de idade dos críticos: N/A (Nenhum caso crítico)")
        );
    }

    private void execBuscaAvancada() {
        System.out.println("\n--- Buscar Caso de Risco ---");

        // Processamento seguro do Optional com ifPresentOrElse
        hospital.buscarPacienteMaisIdoso().ifPresentOrElse(
                p -> System.out.println("🚨 Paciente mais idoso encontrado: " + p),
                () -> System.out.println("O hospital está sem pacientes no momento.")
        );
    }
}