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
vocales = "aeiouAEIOUáéíóúÁÉÍÓÚ"

# 1. Recorrido simple: imprime cada vocal encontrada en la cadena
print("--- Vocales en la contraseña ---")
for caracter in contrasena:
    if caracter in vocales:
        print(caracter)

# 2. Recorrido con range(): imprime caracteres en índices impares (1, 3, 5, ...)
print("\n--- Caracteres en índices impares ---")
for i in range(1, len(contrasena), 2):
    print(contrasena[i])

print("---------- Ejercicio 4 ----------")

datos = [10, 25, -5, 40, 15, 80, 5, -20]

for i in range(len(datos)): # Recorrer la longitud del array, no lo que contiene
    if datos[i] < 0:
        print("Saltando número negativo")
        continue
    elif datos[i] > 50:
        print("Valor límite (50) alcanzado. Deteniendo")
        break
    else:
        print(datos[i] * 2)

print("---------- Ejercicio 5 ----------")
tareas = ["Conectar", "Autenticar", "Procesar_Lote_1", "Procesar_Lote_2", "Finalizar"]

tareas_iter = iter(tareas)

print(next(tareas_iter))
print(next(tareas_iter))
print("---Pausando procesamiento---")
print(next(tareas_iter))
print(next(tareas_iter))
print(next(tareas_iter))

# print(next(tareas_iter)) # Salta excepción StopIteration, no hay más iteraciones disponibles