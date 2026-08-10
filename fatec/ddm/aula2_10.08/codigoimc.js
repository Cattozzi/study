let text_peso = document.getElementById("peso");
let text_altura = document.getElementById("altura");
let botao = document.getElementById("btn-calc");
let resultado = document.getElementById("resultado");

//funcao auxiliar para calcular o imc
function calcularIMC(peso, altura) {
    return peso / (altura * altura);
}
botao.addEventListener("click", function() {
    let peso = parseFloat(text_peso.value);
    let altura = parseFloat(text_altura.value);
    let imc = calcularIMC(peso, altura);
    resultado.innerHTML = "O IMC calculado é: " + imc.toFixed(2);
})
