#include <stdio.h>

void troca(int a, int b, int c) {
    int temp;
    if(a>b) {
        temp=a;
        a=b;
        b=temp;
    } if(a>c) {
        temp=c;
        c=a;
        a=temp;
    } if(b>c) {
        temp=b;
        b=c;
        c=temp;
    }
    printf("%d\n",a);
    printf("%d\n",b);
    printf("%d\n",c);
}

int main(void) {
    int a,b,c;
    scanf("%d%d%d",&a,&b,&c);

    troca(a,b,c);
    printf("\n");
    printf("%d\n",a);
    printf("%d\n",b);
    printf("%d\n",c);

    return 0;
}
