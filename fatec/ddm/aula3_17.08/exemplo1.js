function obterDados(callback){
    //simulando uma operação assincrona
    setTimeout(function(){
        const dados = "Dados obtidos aqui na fatec"
        callback(dados)
},2000)

}
function mostrarDados(dados){
    console.log(dados)
}
obterDados(mostrarDados)