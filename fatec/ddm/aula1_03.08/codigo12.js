function calcularIdade(){
    let idade=33
    
    function mostrarIdade(){
        console.log("Idade: " + idade)

} 
    function fazAniversario(){
        idade++
        mostrarIdade()
    }
    fazAniversario()
} calcularIdade()