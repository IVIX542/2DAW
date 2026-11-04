# ---------------------------------------------------------------------------------------
print("\n-------------------Paso1-------------------\n")
ficha_alumno = {
    "nombre": "Carlos",
    "edad": 22,
    "ciudad": "Valdemoro"
}

print(f"Ficha del alumno:\n{ficha_alumno}")


# ---------------------------------------------------------------------------------------
print("\n-------------------Paso2-------------------\n")
print(f"El nombre del alumno es: {ficha_alumno['nombre']}")

ficha_alumno['edad'] = 23

print(f"Ficha del alumno:\n{ficha_alumno}")

# ---------------------------------------------------------------------------------------
print("\n-------------------Paso3-------------------\n")
ficha_alumno["email"] = "carlos.perez@valledelmiro.es"

ficha_alumno["asignaturas"] = ["Programación",  "Bases de Datos", "Sistemas Informáticos"]

print(f"Ficha del alumno:\n{ficha_alumno}")

# ---------------------------------------------------------------------------------------
print("\n-------------------Paso4-------------------\n")
ciudad_eliminada = ficha_alumno.pop("ciudad")

print(f"Ciudad eliminada: {ciudad_eliminada}")

# ---------------------------------------------------------------------------------------
print("\n-------------------Paso5-------------------\n")
claves = ficha_alumno.keys()

print(f"Claves: {claves}")

# ---------------------------------------------------------------------------------------
print("\n-------------------Paso6-------------------\n")
notas_alumno = {
    "Programacion": 9,
    "Bases de Datos": 7.5
}

ficha_alumno["notas"] = notas_alumno

print(f"Alumno:\n{ficha_alumno}")

nota_programacion = ficha_alumno["notas"]["Programacion"]

print(f"Nota programación: {nota_programacion}")