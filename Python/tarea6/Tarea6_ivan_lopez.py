print("---------- Ejercicio 1 ----------")
numero = int(input("Introduce un número entero entre 0 y 10: "))

if 9 <= numero <= 10:
    print("Sobresaliente")
elif 7 <= numero < 9:
    print("Notable")
elif 6 <= numero < 7:
    print("Bien")
elif 5 <= numero < 6:
    print("Aprobado")
elif 0 <= numero < 5:
    print("Suspenso")
else:
    print("Número no válido")

print("---------- Ejercicio 2 ----------")
secreto = 1

num_usuario = int( input("Adivina el número secreto: ") )

while(num_usuario != secreto):
    
    if num_usuario < secreto:
        print("Demasiado bajo")
    elif num_usuario > secreto:
        print("Demasiado alto")
      
    num_usuario = int( input("Adivina el número secreto: ") )
    
print(f"El número {num_usuario} es correcto!")
    
print("---------- Ejercicio 3 ----------")
contrasena = "Pyth0n_1nCr3íBl3"
for i in contrasena:
    if(i in('a', 'e', 'i', 'o', 'u')):
        print(i)
