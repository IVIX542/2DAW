# ---------------------------------------------------------------------------------------

print("------------------------------Ejercicio 1------------------------------|")

nombre = "lucia"
apellidos = "garcia lopez"
curso = "fundamentos de la programacion"

print(nombre.upper())
print(apellidos)
print(nombre.capitalize())
print(apellidos.title())
print(nombre.title(), apellidos.title(), "-", curso.title())

# ---------------------------------------------------------------------------------------

print("------------------------------Ejercicio 2------------------------------|")
mensaje = " Bienvenido al sistema Python "

mensaje_limpio = mensaje.strip()

print(f"Mensaje original: {mensaje}\nMensaje limpio: {mensaje_limpio}")

print(f"Longitud del mensaje original: {len(mensaje)} caracteres")
print(f"Longitud del mensaje limpio: {len(mensaje_limpio)} caracteres")
# La principal diferencia entre ambos mensajes son el espacio inicial y final del mensaje original.

