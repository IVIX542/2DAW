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
