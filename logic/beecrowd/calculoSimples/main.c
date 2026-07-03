#include <stdio.h>

int main(void) {
    int peca1,qtd1,peca2,qtd2;
    double valor1,valor2;


    scanf("%d %d %lf",&peca1,&qtd1,&valor1);
    scanf("%d %d %lf",&peca2,&qtd2,&valor2);

    double valorTotal = (qtd1*valor1)+(qtd2*valor2);

    printf("VALOR A PAGAR: R$ %.2lf\n",valorTotal);
    return 0;
}
