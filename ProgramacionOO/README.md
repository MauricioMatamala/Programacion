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

### Abstracción de tipos de datos (Ej. un tipo de datos LIFO)

Una pila o estructura *LIFO* tiene varios métodos:

- *Push* : inserta un elemento en la pila
- *Pop* : estrae el último elemento insertado
- *Top* : muestra el elemento en la cima de la pila, pero no lo extrae.
- *Longitud* : indica el número de elementos que hay.

Con lo que sabemos hasta ahora, un pila tendrá dos limitaciones importantes:

1. Tendrá un tamaño máximo predefinido inicialmente.
2. Almacenará elementos de un cierto tipo concreto.

### Pasar objetos como parámetros

Pasar objetos como parámetros es muy habitual. Por ejemplo, ¿De qué forma podemos comparar dos cajas? ¿De qué forma podemos clonar una caja? Los métodos siguientes (sin implementar) podrían resolver estos problemas:

    Class Caja {
        
        int anchura, altura, profundidad;

        //...

        boolean esIgualQue( Caja caja ){
            if ((caja.getAnchura() == anchura) && 
                (caja.getAltura() == altura) &&
                (caja.getProfundidad() == profundidad))
                    return true;
            else return false;
        }

        void clonar( Caja caja ){
            anchura = caja.getAnchura();
            altura = caja.getAltura();
            profundidad = caja.getProfundidad();
        }

        //...
    }
    
### Paso por valor
Ver [documentación de referencia](https://www.arquitecturajava.com/java-value-vs-reference-y-sus-curiosidades/)

### Recursión
Ver [documentación de referencia](https://javadesdecero.es/intermedio/recursividad-con-ejemplos/)

### Static
Ver [documentación de referencia](https://javadesdecero.es/palabra-clave/static/)

- Variable estática: es una variable global que comparten todos los objetos de la clase.
- Método estático: se puede invocar sin crear un objeto de su clase. Ej. *Math.sqrt*
- Bloque estático: se ejecuta la primera vez que se hace referencia a la clase.

> *"Cualquier variable global es culpables mientras no se demuestre lo contrario."*    
Patterns of Enterprise Application Architecture. Martin Fowler

Las variables globales crean dependencias ocultas, y si cambia su valor, muchos objetos pueden verse afectados sin quedar del todo claro en el código.

### Final
Ver [documentación de referencia](https://www.w3schools.com/java/ref_keyword_final.asp)

Por consenso, se suelen declarar las constantes en letras mayúsculas.

### Clases anidadas

Ver [documentación de referencia](https://www.tutorialspoint.com/java/java_innerclasses.htm)

Las clases anidadas tienen especial sentido en programación orientada a eventos. En estos casos, los eventos pueden llegar a ser tan variados y tan abundantes que crear una clase para manejar cada uno de ellos puede empeorar la legibilidad del código. También puede tener sentido usarlas en los casos en que una clase de objetos B no tenga sentido que exista sin que exista otra clase de objetos A. Por ejemplo, podemos pensar en un libro titulado "Aprendiendo Java desde cero", que se publica en la editorial Antunez, con ISBN 12345678. Podemos decir el ejemplar no tiene sentido sin el libro. Es decir, en cierto diseño, la clase *Ejemplar* puede ser una clase interna de *Libro*.

## 2.3. Herencia y polimorfismo

### Control de acceso

Ver [documentación de referencia](https://javadesdecero.es/poo/modificadores-de-acceso/)

### Herencia

Ver [documentación de referencia](https://www.w3schools.com/java/java_inheritance.asp)

### [Super](https://docs.oracle.com/javase/tutorial/java/IandI/super.html)

Ver [documentación de referencia](https://docs.oracle.com/javase/tutorial/java/IandI/super.html)

### Jerarquía multinivel

Ver [documentación de referencia](https://csveda.com/java/java-multilevel-hierarchy/)

### Sobreescritura de métodos

En herencia de clases, cuando un método en una subclase tiene **el mismo nombre y signatura** que el método de su superclase, entonces el método en la subclase se dice que **sobreescribe** (*Override* en inglés) el método de la superclase. Cuando un método sobreescrito es llamado desde la subclase, siempre se ejecutará la versión definida en dicha subclase. La versión del método definida por la superclase será ignorada. Esta característica aporta una gran potencia a la POO, ya que es la base del polimorfismo.

### Polimorfismo

Ver [documentación de referencia](https://www.w3schools.com/java/java_polymorphism.asp)

### Clases abstractas

Ver [documentación de referencia](https://www.w3schools.com/java/java_abstract.asp)

### Final para evitar sobreescritura de métodos

Ver [documentación de referencia](https://www.tutorialspoint.com/using-final-keyword-to-prevent-overriding-in-java)

### Final para evitar la herencia

Ver [documentación de referencia](http://www.javawithus.com/tutorial/final-classes-and-methods)

### La clase Object
Ver [documentación de referencia](https://www.javatpoint.com/object-class)

### Control de acceso

Ver [documentación de referencia](https://javadesdecero.es/poo/modificadores-de-acceso/)

### Herencia

Ver [documentación de referencia](https://www.w3schools.com/java/java_inheritance.asp)

### [Super](https://docs.oracle.com/javase/tutorial/java/IandI/super.html)

Ver [documentación de referencia](https://docs.oracle.com/javase/tutorial/java/IandI/super.html)

### Jerarquía multinivel

Ver [documentación de referencia](https://csveda.com/java/java-multilevel-hierarchy/)

### Sobreescritura de métodos

En herencia de clases, cuando un método en una subclase tiene **el mismo nombre y signatura** que el método de su superclase, entonces el método en la subclase se dice que **sobreescribe** (*Override* en inglés) el método de la superclase. Cuando un método sobreescrito es llamado desde la subclase, siempre se ejecutará la versión definida en dicha subclase. La versión del método definida por la superclase será ignorada. Esta característica aporta una gran potencia a la POO, ya que es la base del polimorfismo.

### Polimorfismo

Ver [documentación de referencia](https://www.w3schools.com/java/java_polymorphism.asp)

### Clases abstractas

Ver [documentación de referencia](https://www.w3schools.com/java/java_abstract.asp)

### Final para evitar sobreescritura de métodos

Ver [documentación de referencia](https://www.tutorialspoint.com/using-final-keyword-to-prevent-overriding-in-java)

### Final para evitar la herencia

Ver [documentación de referencia](http://www.javawithus.com/tutorial/final-classes-and-methods)

### La clase Object

Ver [documentación de referencia](https://www.javatpoint.com/object-class)

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

**Actividad 2.** Partiendo del código propuesto en [Pasar objetos como parámetros](#pasar-objetos-como-parametros) completa la clase Caja, y escribe un programa basado en el siguiente código:

    Caja caja1 = new Caja(3,3,5);
    Caja caja2 = new Caja(caja1);
    Caja caja3 = new Caja(5);

    System.out.println("¿ caja1 es igual que caja2 ? ==> " + caja1.esIgualQue(caja2)); 
    System.out.println("¿ caja1 es igual que caja3 ? ==> " + caja1.esIgualQue(caja3));

**Actividad 3.** Escribe un programa recursivo que resuelva la [serie de Fibonacci](https://es.wikipedia.org/wiki/Sucesi%C3%B3n_de_Fibonacci). Para ello, crea una clase llamada *Fibonacci*, que incluya el método siguiente:

    int termino(int n)

Dicho método toma el número de término y devuelve el valor del término. Por ejemplo, el término número 10 de la serie de *Fibonacci* es 34.

**Actividad 3.** Escribe una clase LIFO (estructura de datos *Last In First Out*) llamada *Pila* que almacena enteros, siguiendo las siguientes indicaciones:
- una constante llamada *LONGITUD_MAXIMA* con el valor 1000, que representa el número máximo de elementos que puede contener la pila.
- un método llamado *insertar* que permite insertar un nuevo número.
- un método llamado *extraer* que permite extraer el número que está en la cima.
- un método llamado *cima* que muestra el contenido de la cima, pero no lo extrae.
- un método llamado *longitud* que devuelve el número de elementos actual.

Escribe un programa que utilizando la clase *Pila* tome una secuencia de números y los devuelva en orden inverso.

**Actividad 4.** Escribe una clase LIFO (estructura de datos *Last In First Out*) llamada *Pila* que almacena enteros, siguiendo las siguientes indicaciones:
- una constante llamada *LONGITUD_MAXIMA* con el valor 1000, que representa el número máximo de elementos que puede contener la pila.
- un método llamado *insertar* que permite insertar un nuevo número.
- un método llamado *extraer* que permite extraer el número que está en la cima.
- un método llamado *cima* que muestra el contenido de la cima, pero no lo extrae.
- un método llamado *longitud* que devuelve el número de elementos actual.

Escribe un programa que utilizando la clase *Pila* tome una secuencia de números y los devuelva en orden inverso.
 
 **Actividad 5.** Revisa el ejercicio LIFO_CONST. Deseas una estructura de datos que además de todas esas operaciones, tenga dos operaciones adicionales:

 - insertarElementoEnPosicion, que acepta dos enteros, uno indicando el valor a insertar y el otro la posicón donde se insertará. El método insertará el elemento en la posición pedida, desplazando el resto de elementos de la parte superior de la pila. El método devuelve valor booleano, que será *true* si se insertó correctamente, o *false* si no hay espacio para insertar el elemento.

 - ordenar, que ordena los elementos según un orden aritmético. El método acepta dos posibles constantes (declaradas en la misma clase):
    - DE_MENOR_A_MAYOR
    - DE_MAYOR_A_MENOR

**Actividad 6.** Durante el desarrollo de una aplicación de gestión de personal, surge la necesidad de cubrir esta historia: "*Calcular la nómina de cada trabajador, dependiendo de su tipo*".

Los empleados pueden ser de tres tipos:

- Comisionados: cobran un sueldo base, y un sueldo extra de 50€ por venta realizada.
- Por horas: cobran una cierta cantidad por cada hora trabajada, multiplicada por el número de horas trabajadas.
- Asalariados: cobran una cantidad fija al mes.

Deberás simular una base de datos de empleados mediante un *array* que aloje los tres tipos de empleados. El objetivo del ejercicio, es recorrer el *array* de trabajadores y generando un informe, que indique los datos básicos de cada trabajador (nombre, apellidos), así como los datos asociados a su tipo (horas trabajadas, ventas, etc) y la cantidad a percibir en función del tipo de trabajador que sea.

**Actividad 7.** Modifica el código del ejercicio anterior, para que la clase Empleado tenga métodos abstractos (¡Ojo! con algún sentido práctico).

**Actividad 8.** Vuelve a modificar el ejercicio anterior, para que las clases tengan implementado el método *toString*. Basa el informe de las nóminas en este método.