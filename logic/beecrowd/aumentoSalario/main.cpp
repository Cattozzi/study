#include <iostream>
#include <iomanip>

int main() {

    double a,novoSalario, reajuste,porcentagem;
    std:: cin >> a;

    if (a<=400) {
        novoSalario=a*1.15;
        porcentagem=15;
    }else if (a<=800) {
        novoSalario=a*1.12;
        porcentagem=12;
    }else if (a<=1200) {
        novoSalario=a*1.10;
        porcentagem=10;
    }else if (a<=2000) {
        novoSalario=a*1.07;
        porcentagem=7;
    }else {
        novoSalario=a*1.04;
        porcentagem=4;
    }
    reajuste=novoSalario-a;
    std::cout << "Novo salario: " << std::fixed << std::setprecision(2) << novoSalario << "\n";
    std::cout << "Reajuste ganho: " << reajuste << "\n";
    std::cout << "Em percentual: " << std::setprecision(0) << porcentagem << " %\n";


return 0;
}