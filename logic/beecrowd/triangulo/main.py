valores = []

while len(valores) < 3:
    linha = input().split()
    for v in linha:
        valores.append(float(v))

A = valores[0]
B = valores[1]
C = valores[2]

if (A + B > C) and (A + C > B) and (B + C > A):
    perimetro = A + B + C
    print(f"Perimetro = {perimetro:.1f}")
else:
    area = ((A + B) * C) / 2
    print(f"Area = {area:.1f}")