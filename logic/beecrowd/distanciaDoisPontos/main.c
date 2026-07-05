#include <stdio.h>
#include <math.h>

int main(void) {
    float x1,x2,y1,y2;

    scanf("%f %f %f %f",&x1,&y1,&x2,&y2);
    double distancia=pow(x2-x1,2)+pow(y2-y1,2);
    distancia=sqrt(distancia);

    printf("%.4f\n",distancia);
    return 0;
}
