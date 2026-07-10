#include <stdio.h>

int main(void) {
    int x=0;
    scanf("%d",&x);
    
    int anos = x / 365;
    x = x % 365;
    printf("%d ano(s)\n",anos);
    int meses = x / 30;
    x = x % 30;
    printf("%d mes(es)\n",meses);
    printf("%d dia(s)\n",x);

    return 0;
}
