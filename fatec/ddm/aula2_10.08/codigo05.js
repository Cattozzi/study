let elementos = document.querySelectorAll("li");

for(let i = 0; i < elementos.length; i++) {
    console.log("Material" + elementos[i].innerHTML)
    let procurado="borracha"
    if(procurado == elementos[i].innerHTML) {
        alert("Material : " + procurado + "foi econtrado")
    }}