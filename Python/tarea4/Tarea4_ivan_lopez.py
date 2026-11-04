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
print("\n-------------------Paso2-------------------\n")
ficha_alumno["email"] = "carlos.perez@valledelmiro.es"

ficha_alumno["asignaturas"] = ["Programación",  "Bases de Datos", "Sistemas Informáticos"]

print(f"Ficha del alumno:\n{ficha_alumno}")
