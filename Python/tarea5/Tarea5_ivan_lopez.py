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

print("\n---------------------Ejercicio 3---------------------")
temperaturas = (18.5, 20.0, 19.2, 22.5, 24.0, 21.8, 17.5)

print("--------------------Ejercicio 3.1--------------------")
print(f"Temperaturas:\n{temperaturas}")

print("\n--------------------Ejercicio 3.2--------------------")
print(f"Primer día: {temperaturas[0]}º\nÚltimo día: {temperaturas[-1]}º")

print("\n--------------------Ejercicio 3.3--------------------")
print(f"Tres primeros días:\n{temperaturas[0:3]}")

print("\n--------------------Ejercicio 3.4--------------------")
print(f"Tres últimos días:\n{temperaturas[4:7]}")

print("\n--------------------Ejercicio 3.5--------------------")
print(f"Temperatura media: {sum(temperaturas) / len(temperaturas)}")

print("\n--------------------Ejercicio 3.6--------------------")
print(f"Temperatura máxima: {max(temperaturas)}")

print("\n--------------------Ejercicio 3.7--------------------")
print(f"Temperatura mínima: {min(temperaturas)}")

print("\n--------------------Ejercicio 3.8--------------------")
print(f"Posición de la temp. máxima: {temperaturas.index(max(temperaturas))}")

print("\n--------------------Ejercicio 3.9--------------------")
print(f"Temperatura 24ºC en la tupla?: {24.0 in temperaturas}")


print("\n---------------------Ejercicio 4---------------------")
madrid = (40.4168, -3.7038)
sevilla = (37.3891, -5.9845)
barcelona = (41.3874, 2.1686)

print("--------------------Ejercicio 4.1--------------------")
print(f"Madrid: {madrid[0]} {madrid[1]}")
print(f"Sevilla: {sevilla[0]} {sevilla[1]}")
print(f"Barcelona: {barcelona[0]} {barcelona[1]}")

print("\n--------------------Ejercicio 4.2--------------------")
latitud = madrid[0]
longitud = madrid[1]

print("\n--------------------Ejercicio 4.3--------------------")
print(f"Latitud de madrid: {latitud}")
print(f"Longitud de madrid: {longitud}")

print("\n--------------------Ejercicio 4.4--------------------")
ubicaciones = (madrid, sevilla, barcelona)

print("\n--------------------Ejercicio 4.5--------------------")
print(f"ubicaciones:\n{ubicaciones}")

print("\n--------------------Ejercicio 4.6--------------------")
coordenadas_madrid_sevilla = (madrid, sevilla)

print("\n--------------------Ejercicio 4.7--------------------")
coordenadas_repetidas = (madrid*3)

print("\n--------------------Ejercicio 4.8--------------------")
print(f"número de ubicaciones almacenadas: {len(ubicaciones)}")

print("\n---------------------Ejercicio 5---------------------")
productos = (
    (101, "Teclado", 25.90, 15),
    (102, "Ratón", 12.50, 30),
    (103, "Monitor", 159.99, 8),
    (104, "Auriculares", 35.00, 20),
    (105, "Webcam", 45.50, 12)
)

print("--------------------Ejercicio 5.1--------------------")
print(f"Productos:\n{productos}")

print("\n--------------------Ejercicio 5.2--------------------")
print(f"Número de productos: {len(productos)}")

print("\n--------------------Ejercicio 5.3--------------------")
print(f"Información del tercer producto:\n{productos[2]}")

print("\n--------------------Ejercicio 5.4--------------------")
print(f"Nombre del tercer producto: {productos[2][1]}")

print("\n--------------------Ejercicio 5.5--------------------")
print(f"Precio del cuarto producto: {productos[3][2]}€")

print("\n--------------------Ejercicio 5.6--------------------")
id_prod_1 = productos[0][0]
nombre_prod_1 = productos[0][1]
precio_prod_1 = productos[0][2]
stock_prod_1 = productos[0][3]

print(f"Producto 1:\n{id_prod_1} - {nombre_prod_1} - {precio_prod_1} - {stock_prod_1}")

print("\n--------------------Ejercicio 5.7--------------------")
valor_total_prod_1 = productos[0][2] * productos[0][3]
valor_total_prod_2 = productos[1][2] * productos[1][3]
valor_total_prod_3 = productos[2][2] * productos[2][3]
valor_total_prod_4 = productos[3][2] * productos[3][3]
valor_total_prod_5 = productos[4][2] * productos[4][3]

print(f"Valor total del producto 1: {valor_total_prod_1}€")
print(f"Valor total del producto 2: {valor_total_prod_2}€")
print(f"Valor total del producto 3: {valor_total_prod_3}€")
print(f"Valor total del producto 4: {valor_total_prod_4}€")
print(f"Valor total del producto 5: {valor_total_prod_5}€")

print("\n--------------------Ejercicio 5.8--------------------")
valor_total_inventario = valor_total_prod_1 + valor_total_prod_2 + valor_total_prod_3 + valor_total_prod_4 + valor_total_prod_5

print(f"Valor total del inventario: {valor_total_inventario}€")

print("\n--------------------Ejercicio 5.9--------------------")
precios_unitarios = (productos[0][2], productos[1][2], productos[2][2], productos[3][2], productos[4][2])
precio_mas_alto = max(precios_unitarios)

print(f"Precios unitarios:\n{precios_unitarios}")
print(f"Precio más alto: {precio_mas_alto}€")

print("\n-------------------Ejercicio 5.10--------------------")
lista_productos = list(productos)

print(f"Lista de productos:\n{lista_productos}")

print("\n-------------------Ejercicio 5.11--------------------")
lista_productos.append(
    (106, "Micrófono", 50.0, 100)
)

print(f"Lista con un producto más:\n{lista_productos}")

print("\n-------------------Ejercicio 5.12--------------------")
tupla_productos = tuple(lista_productos)

print("\n-------------------Ejercicio 5.13--------------------")
print(f"Tupla productos:\n {tupla_productos}")
