let senha = "MinhaSenha123"

if(senha.length < 8){
    console.log("Senha muito curta,minimo de 8 caracteres")
}else{  
    let letra=0
    let numero=0
    for(let i=0;i<senha.length;i++){
        if (senha[i] >= 'a' && senha[i] <= 'z'|| senha[i] >= 'A' && senha[i] <= 'Z') {
            letra++
        } else if (senha[i] >= '0' && senha[i] <= '9'){
            numero++
}
    if(letra>0 && numero>0){
        console.log("Senha válida")
    }else{
        console.log("Senha inválida, precisa conter pelo menos uma letra e um número")
    }
}
}
