# Hecho por Iván López Benítez

"""
Ejercicio 1 - Hola mundo
Crea un programa que muestre el texto:
Hola, mundo. Este es mi primer programa en Python.
"""

# print("Hola, mundo. Este es mi primer programa en Python.")

"""
Ejercicio 2 - Presentación
Pide al usuario que introduzca su nombre y su edad. Muestra un mensaje como este:
    Introduce tu nombre: Ana
    Introduce tu edad: 18
    Hola Ana, tienes 18 años
"""


# nombre = input("Introduce tu nombre: ")
# edad = int(input("Introduce tu edad: "))
# print(f"Hola {nombre}, tienes {edad} años.")


"""
Ejercicio 3 - Mis datos
Crea un programa con variables para:
 - Tu nombre
 - Tus apellidos
 - Tu edad
 -Tu ciudad
Muestra un texto como:
    Me llamo Ana Perez, tengo 18 años y vivo en Madrid.
"""

# nombre = "Ivan"
# apellido = "Lopez"
# edad = 19
# ciudad = "Madrid"

# print(f"Me llamo {nombre} {apellido}, tengo {edad} y vivo en {ciudad}")

"""
Ejercicio 4 - Concatenación simple
Pide al usuario su nombre y apellido. Muestra por pantalla el resultado de unir ambos con
un espacio:
    Introduce tu nombre: Ana
    Introduce tu apellido: García
    Nombre completo: Ana García
"""

# nombre = input("Inreoduce tu nombre: ")
# apellido = input("Introduce tu apellido: ")

# print(f"Nombre completo: {nombre} {apellido}")

"""
Eejrcicio 5 - Intercambio de valores
Crea dos variables, por ejemplo, x=5 e y=10. Muestra sus valores en pantalla, luego
intercambia sus valores en una sola instrucción y vuelve a mostrarlos.
"""

# x = 5
# y = 10
# comodin = 0
# print(f"x: {x}, y: {y}")
# comodin = x; x = y; y = comodin
# print(f"x: {x}, y: {y}")

"""
Ejercicio 6 - Calculadora básica
Pide al usuario dos números y muestra por pantalla:
    - Suma
    - Resta
    - Multiplicación
    - División
Ejemplo:
    Introduce el primer número: 8
    Introduce el segundo número: 4
    Suma: 12
    Resta: 4
    Multiplicación: 32
    División: 2.0
"""

# # Declaración de las variables
# # Variables de input
# num1 = int(input("Introduce el primer número: "))
# num2 = int(input("Introduce el segundo número: "))

# # Operaciones
# suma = num1 + num2
# resta = num1 - num2
# multiplicacion = num1 * num2
# division = num1 / num2

# # Salidas por pantalla
# print(f"Suma: {suma}")
# print(f"Resta: {resta}")
# print(f"Multiplicación: {multiplicacion}")
# print(f"División: {division}")

"""
Ejercicio 7 - División entera y resto
Pide al usuario dos números enteros y muestra:
    - Cociente entero (//)
    - Resto (%)
Ejemplo:
    Introduce el primer número: 17
    Introduce el segundo número: 5
    Cociente entero: 3
    Resto: 2
"""

# # Declaración de variables
# # Variables input
# num1 = int(input("Introduce el primer número: "))
# num2 = int(input("Introduce el segundo número: "))

# # Operaciones
# cociente_entero = num1 // num2
# resto = num1 % num2

# # Salidas por pantalla
# print(f"Cociente entero: {cociente_entero}")
# print(f"Resto: {resto}")

"""
Ejercicio 8 - Área de un rectángulo
Solicita al usuario la base y la altura de un rectángulo. Calcula el área usando la
fórmula:
    Área = base x altura
Muestra el resultado por pantalla
"""
# base = int(input("Introduce la base: "))
# altura = int(input("Introduce la altura: "))

# area = base * altura

# print(f"El área del rectángulo es: {area}")

"""
Ejercicio 9 - Área de un círculo
Pide el radio de un círculo y calcula su área usando la constante PI = 3.1416.
    Área = PI x r^2
Muestra el resultado con print().
"""

# PI = 3.1416
# radio = int(input("Introduce el rádio: "))
# area = PI * radio ** 2

# print(area)

"""
Ejercicio 10 - Precio con IVA
Pide el precio de un producto y calcula:
    - Precio original.
    - Precio final con un 21% de IVA.
Pista: guarda el 21% en una constante llamada IVA
"""

# IVA = 0.21
# precio_inicial = int(input("Indica el precio del producto: "))

# precio_final = precio_inicial + (precio_inicial * IVA) 

# print(f"Precio inicial, sin IVA: {precio_inicial}€")
# print(f"Precio final con un 21% de IVA: {precio_final}€")

"""
Ejercicio 11 - Edad como número
Pide la edad del usuario y:
    1. Muestra un mensaje como texto concatenado: "Tienes 18 años".
    2. Calcula cuántos años tendrá el próximo año y muestra el resultado.
"""

# edad = int(input("Introduce tu edad: "))
# print(f"Tienes {edad} años.")
# print(f"El año que viene tendrás {edad + 1} años.")

"""
Ejercicio 12 - Conversor de euros a dólares
Pide una cantidad que en euros y conviértela a dólares usando una tasa fija, por ejemplo,
1€ = 1.10$
Muestra el resultado con print()
"""

# euros = float(input("Introduce una cantidad de €: "))
# dolares = euros * 1.10

# print(f"{euros}€ = {dolares}$")

"""
Ejercicio 13 - Mostrar decimales
Pide al usuario un número decimal y muestra:
 - El número con su valor original.
 - El doble de ese número.
"""

# numero = float(input("Introduce un número decimal: "))
# print(f"Valor original: {numero}")
# print(f"Valor doble: {numero * 2}")


"""
Ejercicio 14 - Factura básica
Pide:
    - Nombre del producto
    - Precio unitario
    . Cantidad comprada
Calcula y muestra:
    - Total sin impuestos
    - Total con IVA (21%)
"""

# IVA = 0.21
# nombre_prod = input("Introduce el nombre del producto: ")
# precio_unid = float(input("Introduce el precio unitario: "))
# cantidad_comprada = int(input("Introduce la cantidad comprada: "))

# total = precio_unid * cantidad_comprada
# total_IVA = total * IVA

# print(f"-------{nombre_prod}-------")
# print(f"Total sin IVA: {total}")
# print(f"Total con IVA: {total_IVA}")


"""
Ejercicio 15 - Promedio de tres notas
Solicita al usuario tres calificaciones (números decimales) y calcula el promedio.
"""

# cal1 = float(input("Introduce calificación (1/3): "))
# cal2 = float(input("Introduce calificación (2/3): "))
# cal3 = float(input("Introduce calificación (3/3): "))

# promedio = (cal1 + cal2 + cal3) / 3

# print(f"El promedio de {cal1}, {cal2} y {cal3} es: {promedio}")


"""
Ejercicio 16 - Conversión de temperatura
Pide la temperatura en grados celsius y conviértela a Farenheit usando la fórmula:
    F = (C x 1.8) + 32
"""

# celsius = float(input("Introduce la temperatura (ºC): "))

# far = (celsius * 1.8) + 32

# print(f"{celsius} ºC equivale a {far} ºF.")


"""
Ejercicio 17 - Resumen de datos personales
Pide al usuario:
    - Nombre
    - Edad
    - Ciudad
Muestra todo en una sola línea, por ejemplo:
    Me llamo Ana, tengo 18 años y vivo en Madrid.
"""

# nombre = input("Introduce tu nombre: ")
# edad = input("Introduce tu edad: ")
# ciudad = input("Introduce tu ciudad: ")

# print(f"Me llamo {nombre}, tengo {edad} años y vivo en {ciudad}")

"""
Ejercicio 18 - Conversiones varias
Pide un número y muestra:
    - Su valor como float
    - Su valor como str
    - El doble y el triple de ese número
"""

numero = int(input("Introduce un número: "))

print(f"Valor como float: {float(numero)}")
print(f"Valor como string: {str(numero)}")
print(f"El doble de {numero} es: {numero * 2}")
print(f"El triple de {numero} es: {numero * 3}")
 

