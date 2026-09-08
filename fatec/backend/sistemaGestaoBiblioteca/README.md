Aluno: Thiago Henrique Cattozzi RA:1630482511007
Programação de Scripts back end 1 - Professor Marcos Roberto de Moraes

Aqui está a lista de conteúdo adicionado que não está no pdf da da atividade.

-> Criado a classe Record LivroResumo na pasta model -- Recebe os dados filtrados

**DataInitializer.java

1.Pipeline Completo de Streams com filter, map e sorted 

2.Operações de Redução com Streams para Estatísticas

3.Derived Queries (Consultas Derivadas) no Spring Data JPA 

4.Adicionado os Metodos: buscarLivrosPorAutor(), buscarAutorPorNome(),exibirEstatisticas()

Adicionado as opções 5,6,7 no menu switch de acordo com os novos metodos 

//Todos os itens enumerados acima estão comentados no código de acordo com sua numeração


**Autor.java 

Adicionado Nacionalidade 
Adicionado orphanRemoval=true

**Livro.java

Adicionado Isbn

*LivroRepository.java

Adicionado método para busca pelo autor com o ID ou sem ID
List<Livro> findByAutorId(Long autorId);
    List<Livro> findByAutor(Autor autor);


