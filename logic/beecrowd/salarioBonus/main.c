#include <stdio.h>

int main(void) {
    char nomeVendedor[50];
    double salarioFixo;
    double totalVendas;
    double salario;

    scanf("%s", nomeVendedor);
    scanf("%lf", &salarioFixo);
    scanf("%lf", &totalVendas);
    totalVendas = totalVendas * 0.15;
    salario = salarioFixo + totalVendas;

    printf("TOTAL = R$ %.2lf\n", salario);

    return 0;
}
