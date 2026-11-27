# ---------------------------------------------------------------------------------------
# Lista de precios
precios = [12.50, 25.99, 8.75, 120.00, 45.50, 9.99, 75.00, 15.25, 200.00, 5.50]

print("---------------------------------- Apartado A ----------------------------------")
for precio in precios:
    if precio > 20:
        print(f"{precio}€")

print("---------------------------------- Apartado B ----------------------------------")
#Declaración de variables
prod_totales = 0 # bucle
precio_total = 0 # bucle
precio_medio = 0 # bucle + media
producto_mas_caro = precios[0] # bucle + comparación

# Bucle for principal
for i in range(0, len(precios)):
    # Añadimos un producto por iteración
    prod_totales += 1

    # Sumamos el precio al total
    precio_total += precios[i]

    # Comparación precio más alto
    if precios[i] > producto_mas_caro:
        producto_mas_caro = precios[i]

# Cálculo de la media
precio_medio = precio_total / prod_totales

print(prod_totales)
print(precio_total)
print(precio_medio)
print(producto_mas_caro)

print("---------------------------------- Apartado C ----------------------------------")
# Añadir un precio de 35.99€
precios.append(35.99)

# Eliminar el precio 8.75€
precios.remove(8.75)

# Ordenar los precios de menor a mayor
precios.sort()

# Mostramos la lista resultante
print(precios)

print("---------------------------------- Apartado D ----------------------------------")
# Crear una lista nueva
precios_mayores_quince = []

# Recorremos precios
for precio in precios:
    if precio < 15:
        continue
    precios_mayores_quince.append(precio)

# Mostrar los precios mayores que 15
print(precios_mayores_quince)