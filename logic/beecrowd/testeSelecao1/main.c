#include <stdio.h>

#include <stdio.h>

int main(void) {
    int A, B, C, D;
    scanf("%d%d%d%d", &A, &B, &C, &D);
    int MAIORCD = C + D;
    int MAIORAB = A + B;

    if (B > C && D > A && MAIORCD > MAIORAB && C > 0 && D > 0 && A % 2 == 0) {
        printf("Valores aceitos\n");
    } else {
        printf("Valores nao aceitos\n");
    }
    return 0;
}
