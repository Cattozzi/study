#include <stdio.h>

void tipoTriangulo(double a, double b, double c);
int main(void) {
    double a, b, c;
    scanf("%lf %lf %lf", &a, &b, &c);
    if (a < b) {
        double temp = a;
        a = b;
        b = temp;
    }
    if (a < c) {
        double temp = a;
        a = c;
        c = temp;
    }
    if (b < c) {
        double temp = b;
        b = c;
        c = temp;
    }
    tipoTriangulo(a, b, c);
    return 0;
}
void tipoTriangulo(double a, double b, double c) {
    if (a >= b + c) {
        printf("NAO FORMA TRIANGULO\n");
    } else {
        if (a * a == b * b + c * c) {
            printf("TRIANGULO RETANGULO\n");
        } else if (a * a > b * b + c * c) {
            printf("TRIANGULO OBTUSANGULO\n");
        } else if (a * a < b * b + c * c) {
            printf("TRIANGULO ACUTANGULO\n");
        }

        // 3. Bloco dos Lados (a regra mais exigente vem primeiro!)
        if (a == b && b == c) {
            printf("TRIANGULO EQUILATERO\n");
        } else if (a == b || b == c || c == a) {
            printf("TRIANGULO ISOSCELES\n");
        }
    }
}
