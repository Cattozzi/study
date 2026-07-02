#include <stdio.h>

int main(void) {
    int horasTrabalhadas,numero;
    double valorHora,salario;

    scanf("%d",&numero);
    scanf("%d",&horasTrabalhadas);
    scanf("%lf",&valorHora);
    salario = horasTrabalhadas * valorHora;

    printf("NUMBER = %d\n",numero);
    printf("SALARY = U$ %.2lf\n",salario);
    return 0;
}
