let imagens = document.getElementsByTagName("img");
for(let i = 0; i < imagens.length; i++) {
    imagens[i].setAttribute("alt", "imagem de exemplo"+(i+1));
}