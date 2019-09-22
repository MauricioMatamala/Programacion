# Bloque 2. Programación orientada a objetos

> Este documento no pretende ser un manual exahaustivo, sino un guión de trabajo. Algunos aspectos no están detallados, o se limitan a un comentario que puede no ser suficientemente claro.

## 2.1. Introducción

Ver [documentación de referencia](https://desarrolloweb.com/articulos/499.php).

## 2.2. Clases y objetos
    
Ver [documentación de referencia](https://www.w3schools.com/java/java_classes.asp).

¿Cuál es la diferencia entre una clase y un objeto?
   
- Clase X: creación de un nuevo tipo de datos llamado X.
- Objeto X: variable de tipo X (instancia de la clase X).

### Variables de referencia a objetos

    Caja b1 = new Caja();
    Caja b2 = b1; // Ambas variables, b1 y b2, apuntan al mismo objeto.

    // ...

    b1 = null; // b1 no apunta a nada, pero b2 siguie apuntando al círculo original.

### Métodos
Ver [documentación de referencia](https://www.w3schools.com/java/java_class_methods.asp)

- Declaración de métodos en una clase.
- Devolución de valores.
- Parámetros

### Constructores
Ver [documentación de rerencia](https://www.w3schools.com/java/java_constructors.asp)

Los constructores son métodos especiales de inicialización del objeto. Pueden estar parametrizados.

### This

Ver [documentación de referencia](https://www.w3schools.com/java/ref_keyword_this.asp)

La palabra reservada *this* hace referencia al *objeto que lo utiliza*. Es habitual utilizar *this* en los constructores cuando sus parámetros coinciden con los atributos de la clase. Ej.

    Rectangulo(double ancho, double alto){
        this.ancho = ancho;
        this.alto = alto;
    }

### Sobrecarga de métodos y constructores

Ver [documentación de referencia](https://www.w3schools.in/java-tutorial/method-overloading/)

Se pueden sobrecargar los métodos y los constructores. 

#### Ej. Objeto *Caja* con sobrecarga de constructores:

- Se puede crear una caja a partir de 3 medidas (alto, ancho y fondo).
- Se puede crear una caja a partir de 1 medida (todos los lados iguales).
- Se puede crear una caja sin medida (porque no la conocemos aún).
- Se puede crear una caja a partir de otra caja (igual que la primera).

#### Ej. Objeto *ComprobadorDeTipoNumericoSimple*.

Podemos usar la sobrecarga para comprobar el tipo simple de una variable, sobrecargando el método *comprobarTipo* que recibe un parámetro:

- Si el parámetro es un entero, el método indica que la variable es de tipo *int*.
- Si el parámetro es un long, el método indica que la varaible es de tipo *long*.
- ...

### Recolección de basura

Cuando no existen referencias a un objeto, se libera la memoria que ocupa el objeto en cuanto ésta es reclamada por el recolector de basura.

---

**Acctividad 1.** Crea una clase llamada *Libro* que incluya la siguiente información del libro:
- Título
- Autor
- Editorial
- Número de edición
- ISBN

Además, la clase *Libro* contará con varios constructores parametrizados:
- Libro(titulo, autor)
- Libro(titulo, autor, editorial, numeroEdicion, isbn)

También contará con métodos para asignar valores a los atributos, y para consultar su valor. Por ejemplo, para el atributo *titulo* existirán los métodos:
- setTitulo(titulo)
- getTitulo()

Finalmente, escribe un programa que solicite la información de varios libros y los almacene en sus objetos correspondientes. Al terminar, el programa deberá mostrar un listado con los datos recogidos. 

----