let a=4
let b=5
let c=6

if (a >= b + c) {
        printf("NAO FORMA TRIANGULO\n");
    } else {
        if (a * a == b * b + c * c) {
            printf("TRIANGULO RETANGULO\n");
        } else if (a * a > b * b + c * c) {
            printf("TRIANGULO OBTUSANGULO\n");
        } else if (a * a < b * b + c * c) {
            printf("TRIANGULO ACUTANGULO\n");
        }else if(a != b && a != c && b != c){
            printf("TRIANGULO ESCALENO\n");
        }}