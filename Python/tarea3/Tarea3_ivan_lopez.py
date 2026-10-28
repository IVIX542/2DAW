# -------------------------------------
print("\n-----------------Ejercicio1-----------------\n")

tareas_del_dia = ("revisar el correo, preparar la reunión de equipo, terminar el "
                  "informe mensual, llamar al cliente X")

print("\n----------------Ejercicio1.a----------------\n")

tareas_lista = tareas_del_dia.split(", ")

print("\n----------------Ejercicio1.b----------------\n")

print(tareas_lista)

print("\n-----------------Ejercicio2-----------------\n")
print("\n----------------Ejercicio2.a----------------\n")

tareas_lista.append("enviar factura al proveedor")
tareas_lista.insert(0, "comprar café")
print(tareas_lista)

print("\n----------------Ejercicio2.b----------------\n")

tareas_lista.remove("llamar al cliente X")
print(f"Tarea completada: {tareas_lista.pop(0)}")

print("\n----------------Ejercicio2.c----------------\n")

# Buscamos el índice de la tarea y lo guardamos en una variable
indice_tarea = tareas_lista.index("terminar el informe mensual")

# Eliminamos el elemento en ese índice
del tareas_lista[indice_tarea]

# Añadimos un nuevo elemento en el índice indicado
tareas_lista.insert(indice_tarea, "terminar y enviar el informe mensual")

# Imprimimos la lista para ver los cambios
print(tareas_lista)

print("\n----------------Ejercicio2.d----------------\n")

# Comprobamos si "revisar el correo" sigue en la lista
correo_en_lista = tareas_lista.count("revisar el correo")

# Imprimimos el resultado de la condición. En caso de que sea mayor a 0: "True". En caso
# contrario, "False".
print(correo_en_lista > 0)

# Si "responder a los correos de soporte" está en la lista, mostramos su posición.
tarea = "responder a los correos de soporte"

responder_correos = tareas_lista.count(tarea)>0

if responder_correos :
    print(f"Índice de la tarea: {tareas_lista.index(tarea)}")

# Si no, evita el error comprobando su existencia antes
else :
    print(f"La tarea '{tarea}' no existe")

print("\n-----------------Ejercicio3-----------------\n")
print("\n----------------Ejercicio3.a----------------\n")

# Creamos una segunda lista "tareas_tarde"
tareas_tarde = ["planificar tareas de mañana", "hacer copia de seguridad "]

# Añadimos todos los elementos de "tareas_tarde" a la lista principal de tareas
tareas_lista.extend(tareas_tarde)

# Mostramos "tareas_lista"
print(tareas_lista)

print("\n----------------Ejercicio3.b----------------\n")

# Ordenamos la lista de tareas principal
tareas_lista.sort()

# Imprimimos el contenido para ver el resultado
print(f"Lista ordenada:\n{tareas_lista}")

# Invertimos el orden de la lista
tareas_lista.reverse()

# Imprimimos el contenido de la lista al revés
print(f"\nLista invertida:\n{tareas_lista}")

print("\n-----------------Ejercicio4-----------------\n")
print("\n----------------Ejercicio4.a----------------\n")

# Creamos la variable "titulo"
titulo = "--- Resumen de Tareas Pendientes ---\n"

print("\n--------------Ejercicio4.b y 4c-------------\n")

# Convertimos la lista final en una sola cadena de texto, de modo que cada tarea aparezca
# en una nueva línea. Para ello, utilizo un bucle for
for tarea in tareas_lista:
    print(f"- {tarea.capitalize()}")