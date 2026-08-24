//exemplo de promessas
function obterDados(){
    return new Promise(function(resolve,reject){
        //simuando a operacao assincrona com settimeout
        setTimeout(function(){
            const dados = "Dados obtidos da fatec"
            if(dados){
                resolve(dados)
            }else{
                reject("Erro ao obter odados")
            }
        },2000)
    })
}
obterDados()
.then(function(dados){
    console.log(dados)
})
.catch(function(err){
    console.log(err)
})
obterDados()