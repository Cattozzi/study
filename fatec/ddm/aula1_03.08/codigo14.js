function difletvar(){
    if(true){
        let x = 10
    console.log(x)       
    }
    console.log("Fora do bloco: " + x) //causa erro 
}

function difletvar2(){
    if(true){
        var x = 10
    console.log(x)       
    }  
    console.log("Dentro do bloco: " + x)       
 }
    difletvar2()
    difletvar()