# ---------------------------------------------------------------------------------------
print("---------------------------------- Apartado A ----------------------------------")
# Variables y constantes
EDAD_MINIMA = 18 # Constante
nombre = input("Introduce tu nombre: ")
apellidos = input("Introduce tus apellidos: ")

print("---------------------------------- Apartado B ----------------------------------")
# Convertir nombre y apellidos a formato título
nombre = nombre.title()
apellidos = apellidos.title()

# Quitar espacios al principio y al final
nombre = nombre.strip()
apellidos = apellidos.strip()

nombre_completo = nombre + " " + apellidos

longitud_nombre_completo = len(nombre_completo)

print("---------------------------------- Apartado C ----------------------------------")
# Variable edad
edad = int(input("Introduce tu edad: "))
comprobar_edad = "";

# Comparación de edad con EDAD_MINIMA
if edad < EDAD_MINIMA:
    comprobar_edad = "No cumples la edad mínima para registrarte."
elif edad >= EDAD_MINIMA and edad <= 25:
    comprobar_edad = "Perteneces al gupo de usuarios jóvenes."
else:
    comprobar_edad = "Continuando registro."

print("---------------------------------- Apartado D ----------------------------------")
# Imprimimos los datos recabados
print(f"Nombre completo: {nombre_completo}\nEdad: {edad}\nLongitud del nombre completo: {longitud_nombre_completo}\nResultado de la comprobación de edad: {comprobar_edad}")