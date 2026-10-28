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
