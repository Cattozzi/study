Aluno: Thiago Henrique Cattozzi - ADS Programação de scripts 1 - Manhã - 4º Semestre

Algumas mudanças, métodos ou otimizações utilizado na atividade diferentes do material em aula, que aprendi durante a construção utilizando IA:

No código foi usado .toList() ao invés de .collect(Collectors.toList()), que realiza a mesma função e essa é uma sintaxe mais enxuta

Utilização do .mapToInt(Paciente::idade) para transformar o fluxo de objetos em um fluxo de inteiros primitivos antes de calcular a média.

A instrução .reversed() usada junto com Comparator.comparingInt(),  para inverter a lógica padrão, garantindo que os dados venham do maior para o menor (ordem decrescente).

Em vez de escrever a estrutura lambda completa p -> p.idade(), utilizei Paciente::idade. O Java entende sozinho que deve invocar esse método para cada paciente.

Conclusão: O projeto inicial foi importante para aprendizado da API Stream, foi realizado muita leitura e pesquisa. A principal dificuldade foi na primeira aplicação e na quantidade de informações na documentação que em um primeiro contato assusta pela vastidão de opções, me senti bastante perdido inicialmente. O uso da IA foi essencial para a superação desses desafios, principalmente o modo aprendizado do Gemini onde foi construído boa parte do código.
