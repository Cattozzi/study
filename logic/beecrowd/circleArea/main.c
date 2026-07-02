#include <stdio.h>

int main(void) {
    double raio;
    double n=3.14159;
    double area;

    scanf("%lf",&raio);
    area = n * (raio*raio);
printf("A= %.4lf",area);
    return 0;
}