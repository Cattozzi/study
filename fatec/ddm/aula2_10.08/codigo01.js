//criar uma variavel que receba um elemento do dom
//receber um buttom
let botao = document.querySelector("button");
let contador = 0;
botao.addEventListener("click", function() {
    console.log("O botao selecionado foi " + botao.innerHTML);
    contador++;
    console.log("O botão foi clicado " + contador + " vezes");
});