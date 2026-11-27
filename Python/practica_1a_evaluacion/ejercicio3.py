# ---------------------------------------------------------------------------------------
# Diccionario de estudiantes
estudiantes = {
    "Ana": (8.5, 7.0, 9.0),
    "Luis": (5.0, 6.5, 4.0),
    "Marta": (9.5, 9.0, 10.0),
    "Pedro": (6.0, 5.5, 7.0),
    "Laura": (4.0, 3.5, 5.0),
}

print("---------------------------------- Apartado A ----------------------------------")
# Pedir el nombre de un estudiante, usamos capitalize para permitir el nombre en
# minúsculas y poder compararlo igual
nombre = input("Introduce el nombre de un estudiante: ").capitalize()

# Comprobar si existe en el diccionario
nombre_existe = False

if nombre in estudiantes:
    nombre_existe = True
    
# Si existe, mostramos sus calificaciones
if nombre_existe:
    notas = estudiantes[nombre]
    print(f"Calificaciones de {nombre}: {notas}")
else:
    print(f"El alumno '{nombre}' no existe")

print("-------------------------------- Apartado B y C --------------------------------")
# Recorrer el diccionario de estudiantes para calcular su media

# Declarar variables
suma = 0
estudiantes.keys()

print("Medias de los estudiantes:")

# Recorrer estudiante.items() para sacar nombre y notas de cada estudiante
for nombre, notas in estudiantes.items():
    
    # Rumar las notas
    suma = sum(notas)
    
    # Calcular la media
    media = suma / len(notas)
    
    # Imprimir el nombre junto a la media
    # print(f"{nombre}: {media}")
    
    # Apartado C - Clasificar a los estudiantes según su nota media
    if media < 5:
        calificacion = "Suspenso"
    if media >= 5 and media < 7:
        calificacion = "Aprobado"
    if media >= 7 and media < 9:
        calificacion = "Notable"
    if media >= 9 and media < 10:
        calificacion = "Sobresaliente"
    
    # Imprimir nombre, media y calificación
    print(f"{nombre}: {media} - {calificacion}")
    