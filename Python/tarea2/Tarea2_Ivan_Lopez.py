# ---------------------------------------------------------------------------------------

print("\n------------------------------Ejercicio 1------------------------------|\n")

nombre = "lucia"
apellidos = "garcia lopez"
curso = "fundamentos de la programacion"

print(nombre.upper())
print(apellidos)
print(nombre.capitalize())
print(apellidos.title())
print(nombre.title(), apellidos.title(), "-", curso.title())

# ---------------------------------------------------------------------------------------

print("\n------------------------------Ejercicio 2------------------------------|\n")

mensaje = " Bienvenido al sistema Python "

mensaje_limpio = mensaje.strip()

print(f"Mensaje original: {mensaje}\nMensaje limpio: {mensaje_limpio}")

print(f"Longitud del mensaje original: {len(mensaje)} caracteres")
print(f"Longitud del mensaje limpio: {len(mensaje_limpio)} caracteres")
# La principal diferencia entre ambos mensajes son el espacio inicial y final del mensaje original.

# ---------------------------------------------------------------------------------------

print("\n------------------------------Ejercicio 3------------------------------|\n")

frase = "Python es un lenguaje de programación. Python es muy utilizado."

python_en_frase = "Python" in frase

print(python_en_frase)

print(frase.find("lenguaje"))

print(f"La palabra 'Python' aparece {frase.count("Python")} veces")
print(f"La frase comienza por 'Python'?: {frase.startswith("Python")}")

# ---------------------------------------------------------------------------------------

print("\n------------------------------Ejercicio 4------------------------------|\n")
archivo = "informe_final.pdf"

print(f"El nombre termina en '.pdf'?: {archivo.endswith(".pdf")}")
print(f"Posición del carácter '_': {archivo.find("_")}")
print(f"El carácter 'i' aparece {archivo.count("i")} veces")
print(f"La palabra 'final' aparece en el nombre?: {"final" in archivo}")
print(f"Longitud total del nombre del archivo: {len(archivo)} caracteres")

# ---------------------------------------------------------------------------------------

print("\n------------------------------Ejercicio 5------------------------------|\n")
id_usuario = " usr-ana-2026 "
print(f"ID inicial del usuario: '{id_usuario}'")


id_normalizado = id_usuario.strip().replace("-", "_")
print(f"ID del usuario normalizado: '{id_normalizado}'")

# Añado comillas simples para poder ver las diferencias entre ambos usuarios a primera
# vista

# ---------------------------------------------------------------------------------------

print("\n------------------------------Ejercicio 6------------------------------|\n")

codigo = "DAW-2026-MADRID"

primeras_letras = codigo[0:3]

anio = codigo[4:8]

ciudad = codigo[9:15]

print(f"Código: {codigo}\nAño: {anio}\nCiudad: {ciudad}")

# Al usar "codigo[4:8]", se selecciona desde el 5 hasta el 8, dejando la posición 4 fuera
# de la selección.

# ---------------------------------------------------------------------------------------

print("\n------------------------------Ejercicio 7------------------------------|\n")

prefijo = "PY"

print(f"Prefijo: {prefijo}")

prefijo_cuatro = prefijo * 4

print(f"Prefijo cuatro veces: {prefijo_cuatro}")

separador = "-"

codigo = prefijo + separador + "2026"

print(f"Código completo: {codigo}")

print(f"Longitud código: {len(codigo)} caracteres")

print(f"El código empieza por 'PY'?: {codigo.startswith("PY")}")