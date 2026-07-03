#include <stdio.h>

int main(void) {

    double radius,volume;
    double pi = 3.14159;

    scanf("%lf", &radius);
    volume=(4.0/3.0)*pi*radius*radius*radius;

   printf("VOLUME = %.3lf\n",volume);

    return 0;
}
