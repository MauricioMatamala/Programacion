# Introducción a Java
## Bloque 1. Introducción al lenguaje de programación Java (Módulo Programación del CPGS DAW)
 
### 1.1. Introducción a Java
- [Introducción a la historia de Java ](docs/historiaJava.md) ```Traducción del libro "Java: The complete Reference" de Herbert Schildt```
- [Instalación de OpenJDK en GNU/Linux](https://maslinux.es/como-instalar-openjdk-11-en-ubuntu-18-04-16-04-o-14-04-linux-mint-19-18-o-17/)
- [Instalación de OpenJDK en Windows 10](https://www.jackrutorial.com/2018/10/how-to-install-java-jdk-11-on-windows-10.html)
- [Hola mundo!](https://www.w3schools.com/java/java_getstarted.asp)

### 1.2. El IDE 
- [Proceso de instalación](https://www.jetbrains.com/help/idea/installation-guide.html)
- [Licencia de estudiante](https://www.evernote.com/shard/s205/sh/78035d37-2c09-4c90-ad6d-99c10dc9e414/04b92e3ea49fe5825599bd3b6049e478)
- [Ejecución de un programa simple](https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html)
 

[Guía de instalación de Intellij IDEA]

### 1.3. Tipos de datos y variables
- [Entrada y salida de datos por consola](https://www.w3schools.com/java/java_user_input.asp)
- [Comentarios](https://www.w3schools.com/java/java_comments.asp)
- [Tipos primitivos](https://www.w3schools.com/java/java_data_types.asp)
- [Declaración de variables](https://www.w3schools.com/java/java_variables.asp)
- [Casting](https://www.w3schools.com/java/java_type_casting.asp)


### 1.4. [Arrays](https://www.w3schools.com/java/java_arrays.asp)
- Arrays de una dimensión
- Arrays de dos dimensiones
- Declaraciones alternativas de arrays

### 1.5. [Cadenas de caracteres](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html)
- Acceso a los caracteres de un String
- Mayúsculas y minúsculas
- Ocurrencias de caracteres
- Subcadenas
- Prefijos y sufijos
- Posición de un substring dentro de la cadena
- Concatenar cadenas
- La clase StringBuffer
- Conversión entre números y cadenas
- Representación numérica en diferentes bases
- Usar expresiones regulares para particionar una cadena
- Comparación de cadenas

### 1.6. [Operadores](https://www.w3schools.com/java/java_operators.asp)
- Operadores aritméticos
- Operadores lógicos
- Operadores relacionales
- Operadores lógicos de bit
- Operadores de desplazamiento de bit

### 1.7. Sentencias de control

Alteran el flujo de ejecución según el estado del programa.

    Existen tres tipos:
    - Selección (if, switch)
    - Iteración (while, do-while, for)
    - Salto (break, continue)

- [If](https://www.w3schools.com/java/java_conditions.asp)
- [Switch](https://www.w3schools.com/java/java_switch.asp)
- [While](https://www.w3schools.com/java/java_while_loop.asp)
- [do-while](https://www.w3schools.com/java/java_while_loop.asp)
- [for](https://www.w3schools.com/java/java_for_loop.asp)
- [for each](https://www.w3schools.com/java/java_for_loop.asp)
- [Herederos del espagueti](https://www.w3schools.com/java/java_break.asp)


 [Tutorial de Java de W3Schools](https://www.w3schools.com/java/)

---

# Actividades

**Actividad 1.** Instalar OpenJDK en tu ordenador. Crear un programa "Hola mundo!" utilizando el editor de textos.

**Actividad 2.** Instala IntelliJ Community en tu equipo.


**Actividad 3.** Crea un ejercicio que muestre por pantalla el siguiente menú:

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



**Actividad 4.** Reescribe el ejercicio 3 utilizando Switch.

**Actividad 5.** Los comerciales Isabel Castillo y Vicente Calzado han realizado las siguientes ventas (en unidades) durante esta semana:

Isabel: 7, 7, 10, 6, 4
Vicente: 4, 7, 5, 4, 5

Se necesita un programa que pide por pantalla un número de items, y una vez introducido muestra por pantalla quién ha vendido esa cantidad exactamente. Por ejemplo, si se introduce el número 7, se debe obtener un mensaje como el siguiente:
```
Los empleados que vendieron 7 items fueron:

    - Isabel
    - Vicente
```

**Actividad 6.** Modifica el código del ejercicio anterior para poder obtener la siguiente información:

1. Obtener el promedio de ventas de cada uno.
2. Averiguar quién ha conseguido el mayor número de ventas en un día.

La información se puede mostrar de la siguiente forma:

```
Promedio de ventas:

Isabel                                      6,8     *
Vicente                                     5

Isabel es la vendedora de la semana con 10 items en un día.
```


Finalmente, esta información debe publicarse por pantalla.

**Actividad 7.** Imprimir una pirámide de dígitos como la siguiente:
```
            1
           121
          12321
         1234321
        123454321
       12345654321
      1234567654321
     123456787654321
    12345678987654321
```

**Actividad 8.** Escribe un programa que lea un entero postivo N y muestre por pantalla una tabla como la siguiente, con el factorial de cada número entre 1 y N.
```
-------------------------------------------
        I       1   2   3   4   .....   N
-------------------------------------------
Factorial(I)    1   2   6   24  .....   N*
-------------------------------------------
```






