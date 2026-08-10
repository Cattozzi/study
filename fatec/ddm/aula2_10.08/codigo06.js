let botao = document.querySelector("buttton");
let paragrafos = document.getElementsByClassName("paragrafo");

//adicionar um evento ao clique do botao
botao.addEventListener("click", function() {
    for(let i = 0; i < paragrafos.length; i++) {
        //para cada elemento de paragrafo, alteraremos o estilo para negrito
        for(let i = 0; i < paragrafos.length; i++) {
            paragrafos[i].style.fontWeight = "bold";
        }
    }
})