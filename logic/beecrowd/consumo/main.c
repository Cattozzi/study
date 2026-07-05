#include <stdio.h>

int main(void) {
    double x,y,z;
    scanf("%lf%lf",&x,&y);

    z=x/y;
    printf("%.3lf km/l\n",z);
    return 0;
}
