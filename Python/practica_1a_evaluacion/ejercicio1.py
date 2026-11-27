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

print("Longitud nombre completo:", longitud_nombre_completo)

print("---------------------------------- Apartado C ----------------------------------")
# Variable edad
edad = int(input("Introduce tu edad: "))

# Comparación de edad con EDAD_MINIMA
if edad < EDAD_MINIMA:
    print("No cumples la edad mínima para registrarte.")
elif edad >= EDAD_MINIMA and edad <= 25:
    print("Perteneces al gupo de usuarios jóvenes.")
else:
    print("Continuando registro")
    