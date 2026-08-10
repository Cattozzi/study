let nome="Pedro"

function saudacao(nome){
    let mensagem = "Olá, " + nome + "!"
    console.log(mensagem)
}
console.log("Mostrando nome: " + nome)

console.log("Mostrando mensagem" + mensagem)//causa erro
//aborta o programa sem executar a função
saudacao(nome)
