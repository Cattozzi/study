let valores=[2,4,6,,3,5,]
let soma=0
for(let i=0;i<valores.length;i++){
    soma+=valores[i]
    console.log(`Passo ${i} - Soma parcial: ${soma}`)
    console.log("Passo " + i + " - Soma parcial: " + soma)
}
console.log("Soma total:" + soma)