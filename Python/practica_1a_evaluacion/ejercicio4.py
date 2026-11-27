# ---------------------------------------------------------------------------------------
# Diccionario de tareas
tareas = [
    {"descripcion": "Estudiar Python", "completada": False},
    {"descripcion": "Realizar ejercicios", "completada": True},
    {"descripcion": "Preparar examen", "completada": False},
]
opcion = 0

while opcion != 4:
    
    print(
        "\n|   ==== GESTOR DE TAREAS ====        |\n"
        "| 1. Mostrar todas las tareas         |\n"
        "| 2. Añadir una nueva tarea           |\n"
        "| 3. Marcar una tarea como completada |\n"
        "| 4. Salir                            |\n"
    )
    
    opcion = int(input("Seleccione una opcion: "))
    
    match opcion:
        case 1:
            print("\nTareas:")
            for i in range(len(tareas)):
                descripcion = tareas[i]["descripcion"]
                if tareas[i]["completada"] == True:
                    estado = "Completada"
                else:
                    estado = "Pendiente"
                
                print(f"{i+1}. {descripcion} - {estado}")
        case 2:
            descripcion = input("\nIntroduce la descripción de la tarea:\n")
            diccionario = {
                "descripcion": descripcion,
                "completada": False
            }
            tareas.append(diccionario)
        case 3:
            print("\nTareas:")
            for i in range(len(tareas)):
                descripcion = tareas[i]["descripcion"]
                if tareas[i]["completada"] == True:
                    estado = "Completada"
                else:
                    estado = "Pendiente"
                
                print(f"{i+1}. {descripcion} - {estado}")
            
            numero_tarea = int(input("Introduce el número de tarea a completar: "))-1
            
            if 0 < numero_tarea <= len(tareas)-1:
                tareas[numero_tarea]["completada"] = True
            else:
                print("Número de tarea no válido.")
        case 4:
            print("\nSaliendo...")
            break
        case _:
            print("\nOpción no válida.")
            
    