public record Paciente(String nome, int idade, NivelEmergencia nivel, boolean possuiPlano) {

    public Paciente {
        if(idade<0||nome==null||nome.isBlank()){
        throw new IllegalArgumentException("Idade invalida ou nome invalido.");
    }
    }
}