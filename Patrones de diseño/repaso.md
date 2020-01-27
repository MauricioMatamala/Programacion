# Ejercicios de repaso

**Actividad 1.** Crea un ejercicio que muestre por pantalla el siguiente menú:
```
¿Qué unidad desea utilizar?
1. mm
2. cm
3. m
Introduzca una opción:
```
Una vez que el usuario introduzca la opción, se muestra el siguiente menú:

```
¿Qué operación desea realizar?

1. Calcular la hipotenusa de un triángulo a aprtir de sus catetos.
2. Calcular un cateto de un triángulo a partir de el otro cateto y la hipotenusa
3. Calcular el área de un triángulo a partir un cateto y la hipotenusa
4. Caluclar el área de un triángulo a partir de dos catetos.

Elige una opción:
```

Una vez que el usuario introduzca una opción, el programa pide los parámetros necesarios. Por ejemplo, si se elige la opción 2, se pedirá al usuario la longitud de un cateto y la de la hipotenusa.

Finalmente, se muestra un mensaje al usuario con el resultado, indicando claramente la solución. Por ejemplo, si el usuario eligió la opción 2, se mostrará un mensaje como el siguiente:

    El cateto del triángulo tiene una longitudo de 33.5 mm

**Actividad 2.** Los comerciales Isabel Castillo y Vicente Calzado han realizado las siguientes ventas (en unidades) durante esta semana:

Isabel: 7, 7, 10, 6, 4
Vicente: 4, 7, 5, 4, 5

Se necesita un programa que muestre el siguiente menú:

```
1. Empleados que vendieron un número de items
2. Obtener el promedio de ventas de cada uno
3. Averiguar quién han conseguido el mayor número de ventas en un día
4. Insertar un nuevo empleado y sus ventas
```

Las respuestas obtenidas son del siguiente tipo:

Respuesta a la opción 1. 
```
Los empleados que vendieron 7 items fueron:

    - Isabel
    - Vicente
```

Respuesta a la opción 2.
```
Promedio de ventas:

Isabel                                      6,8     *
Vicente                                     5
```
Respuesta a la opción 3.

```
Isabel es la vendedora de la semana con 10 items en un día.
```

**Actividad 3.** Durante el desarrollo de una aplicación de gestión de personal, surge la necesidad de cubrir esta historia: "*Calcular la nómina de cada trabajador, dependiendo de su tipo*".

Los empleados pueden ser de tres tipos:

- Comisionados: cobran un sueldo base, y un sueldo extra de 50€ por venta realizada.
- Por horas: cobran una cierta cantidad por cada hora trabajada, multiplicada por el número de horas trabajadas.
- Asalariados: cobran una cantidad fija al mes.

Deberás simular una base de datos de empleados que aloje los tres tipos de empleados. El objetivo del ejercicio, es recorrer el *array* de trabajadores y generando un informe, que indique los datos básicos de cada trabajador (nombre, apellidos), así como los datos asociados a su tipo (horas trabajadas, ventas, etc) y la cantidad a percibir en función del tipo de trabajador que sea.

**Actividad 4.** Escribe un programa que pueda almacenar diferentes tipo de figuras geométricas: círculos, triángulos y cuadrados. Todas las figuras tienen un color, y tienen una manera particular de obtener el área. Escribe un programa que contenga un array de figuras geométricas. Deberás recorrer el array e imprimir para cada figura el tipo de figura de que se trata, su color y su área.

**Actividad 5.** (Actividad inspirada en la propuesta por Facundo) Crear una aplicación que permita gestionar tareas pendientes, añadir nuevas tareas. Las tareas deben tener una fecha límite y pertenecer a una categoría, como por ejemplo  *ocio, clase , trabajo*, etc. Se deben poder hacer las siguientes tareas:

1. Crear una nueva categoría.
2. Mostrar las categorías existentes.
3. Crear una nueva tarea.
4. Consultar las tareas pendientes.
5. Eliminar una tarea (completada).
6. Consultar las tareas de una categoría.
7. Consultar las tareas en una fecha.
8. Consultar las tareas en tiempo.
9. Consultar las tareas retrasadas.

**Actividad 6.** (Actividad inspirada en la propuesta de Alberto). En un concesionario se realizan ventas y compras de coches a clientes. Se utiliza una aplicación que gestiona la siguiente información.
- Vehículos, incluyendo modelo, marca, color, año de fabricación, combustión, estado y precio recomendado de venta.
- Clientes, incluyendo nombre, apellidos, niv, cuenta bancaria.
- Operaciones de compraventa, incluyendo el cliente, el vehículo, el tipo de operación y el precio acordado.

Escribe una aplicación que sea capaz de realizar las siguientes tareas:

1. Introducir un nuevo vehículo.
2. Introducir un nuevo cliente.
3. Realizar una venta a un cliente.
4. Realizar una compra a un cliente.
5. Obtener el saldo total de un cliente que ha realizado ventas/compras en el concesionario.

**Actividad 7.** Nos han encargado una aplicación para gestionar un aparcamiento de vehículos requisados. Cuando llega un nuevo vehículo, se anotan una serie de datos, que varían dependiendo del tipo de vehículo. Por ejemplo, los datos según vehículo serían los siguientes:

- Barcos
    - Nombre
    - Fecha de fabricación
    - Fecha de entrada
    - Número de bastidor
    - Eslora
    - Calado
    - Manga

- Camiones
    - Matrícula
    - Fecha de entrada
    - Fecha de fabricación
    - Número de bastidor
    - Ancho
    - Altura
    - Longitud

- Coches
    - Matrícula
    - Fecha de entrada
    - Fecha de fabricación
    - Número de bastidor
    - Ancho
    - Altura
    - Longitud

Los vehículos, una vez requisados pasan a formar parte de la lista de vehículos en espera a ser subastado. Conforme se van autorizando nuevas subastas, los vehículos pasan a subasta. Una vez vendidos, entran en la lista de vendidos, junto con los datos del vendedor y el precio de venta.

Los vehículos pueden ser comprados por dos tipos de compradores:
- Personas físicas
    - Nombre y apellidos
    - DNI
    - Dirección

- Personas jurídicas
    - Nombre
    - CIF
    - Razón social

NOTA: También pueden haber personas extranjeras que no tengan DNI, y en su lugar cuenten con un NIE.

El programa debe permitir hacer lo siguiente:

1. introducir nuevos vehículos en el depósito, 
2. poner en subasta un vehículo,
3. registrar compradores autorizados,
3. vender un vehículo subastado a un comprador registrado por un precio, y en una fecha concreta,
4. registrar un vehículo como vendido,
3. listar la información de los vehículos del depósito,
3. listar los vehículos que están en espera a ser subastados,
3. listar los vehículos vendidos, y a qué comprador se han vendido así como el precio y la fecha de venta

**Actividad 8.** Escribe una aplicación para gestionar un hotel, similar al que se detalla en el documento [hote-producto-backlog.pdf](http://politecnico-ed.es/ED/introduccion/hotel-product-backlog.pdf).