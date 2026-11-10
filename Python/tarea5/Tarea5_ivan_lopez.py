print("--------------------Ejercicio 1--------------------")
print("-------------------Ejercicio 1.1-------------------")
alumno = (
    "Iván",
    "López Benítez",
    20,
    "Valdemoro",
    "DAW",
    "2º"
)

print("\n-------------------Ejercicio 1.2-------------------")
print(f"alumno:\n{alumno}")

print("\n-------------------Ejercicio 1.3-------------------")
print(f"Nombre: {alumno[0]} - Apelidos: {alumno[1]}")

print("\n-------------------Ejercicio 1.4-------------------")
print(f"Edad: {alumno[-4]} - Población: {alumno[-3]}")

print("\n-------------------Ejercicio 1.5-------------------")
print(f"Primer elemento: {alumno[0]}\nÚltimo elemento: {alumno[-1]}")

print("\n-------------------Ejercicio 1.6-------------------")
print(f"Número de elementos: {len(alumno)}")

print("\n-------------------Ejercicio 1.7-------------------")
print(f"Tres primeros elementos: {alumno[0:3]}") # Del 0 al 3, sin incluir el último

print("\n-------------------Ejercicio 1.8-------------------")
print(f"Tres últimos elementos: {alumno[3:6]}") # Del 3 al 6, no incluimos el 6

print("\n--------------------Ejercicio 2--------------------")

asignaturas = ("Programación", "Bases de Datos", "Sistemas Informáticos", 
               "Lenguajes de Marcas", "Entornos de Desarrollo", "Programación")

print("-------------------Ejercicio 2.1-------------------")
print(f"asignaturas:\n{asignaturas}")

print("\n-------------------Ejercicio 2.2-------------------")
print(f"primera: {asignaturas[0]}\núltima: {asignaturas[-1]}") # Ambas programación

print("\n-------------------Ejercicio 2.3-------------------")
print(f"Tres primeras:\n{asignaturas[0:3]}")

print("\n-------------------Ejercicio 2.4-------------------")
print(f"Asignaturas entre 2 y 4:\n{asignaturas[2:4]}")

print("\n-------------------Ejercicio 2.5-------------------")
print(f"'Programación' en la tupla?: {'Programación' in asignaturas}")

print("\n-------------------Ejercicio 2.6-------------------")
print(f"'Redes' en la tupla?: {'Redes' in asignaturas}")

print("\n-------------------Ejercicio 2.7-------------------")
print(f"Primera aparición de 'Programación' en la tupla: índice {asignaturas.index("Programación")}.")

print("\n-------------------Ejercicio 2.8-------------------")
print(f"'Programación' aparece {asignaturas.count('Programación')} veces.")
