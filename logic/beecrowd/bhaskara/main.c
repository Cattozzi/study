#include <stdio.h>
#include <math.h>

int main(void) {
    double a, b, c, delta;

    scanf("%lf %lf %lf", &a, &b, &c);

    delta = (b * b) - (4 * a * c);

    if (a == 0 || delta < 0) {
        printf("Impossivel calcular\n");
    } else {
        double x1 = (-b + sqrt(delta)) / (2 * a);
        double x2 = (-b - sqrt(delta)) / (2 * a);

        printf("R1 = %.5lf\n", x1);
        printf("R2 = %.5lf\n", x2);
    }

    return 0;
}