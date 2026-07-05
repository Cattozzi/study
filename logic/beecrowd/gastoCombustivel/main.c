#include <stdio.h>

int main(void) {
    int horas,kmh;
    scanf("%d %d",&horas,&kmh);
    double litros=(horas*kmh)/12.0;
    printf("%.3lf\n",litros);

    return 0;
}
