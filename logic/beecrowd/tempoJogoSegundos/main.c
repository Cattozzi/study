#include <stdio.h>

int main(void) {
    int HI, MI, HF, MF;
    scanf("%d %d %d %d", &HI, &MI, &HF, &MF);

    int inicioEmMinutos = (HI * 60) + MI;
    int fimEmMinutos = (HF * 60) + MF;
    int duracaoTotal = fimEmMinutos - inicioEmMinutos;

    if (duracaoTotal <= 0) {
        duracaoTotal = duracaoTotal + 1440;
    }
    int horas = duracaoTotal / 60;
    int minutos = duracaoTotal % 60;

    printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n", horas, minutos);

    return 0;
}