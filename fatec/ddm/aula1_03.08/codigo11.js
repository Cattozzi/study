let nome="Pedro"

function saudacao(nome){
    var mensagem = "Olá, " + nome + "!"
    console.log(mensagem)
}
console.log("Mostrando nome: " + nome)

console.log("Mostrando mensagem" + mensagem)//causa erro
//var só "vaza" dentro de bloco, dentro de funcao ele nao sai da funçãp
//mesmo usando var
saudacao(nome)
