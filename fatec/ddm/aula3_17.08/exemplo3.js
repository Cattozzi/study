function obterDados() {
    return new Promise(function (resolve, reject) {
        //simuando a operacao assincrona com settimeout
        setTimeout(function () {
            const dados = "Dados obtidos da fatec"
            if (dados) {
                resolve(dados)
            } else {
                reject("Erro ao obter odados")
            }
        }, 2000)
    })
}
async function mostrarDados() {
    try {
        const dados = await obterDados();
        console.log(dados)

    } catch {
        console.log(erro)

    }

}
mostrarDados()