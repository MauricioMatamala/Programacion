# Patrones de diseño

Existen tres tipos generales de patrones de diseño:
- Patrones creacionales.
- Patrones estructurales.
- Patrones de comportamiento.

Vamos a ir viendo tipos de cada uno, y finalmente, veremos el *rey de los patrones*, MVC, por ser una composición de varios tipo de patrón.

La lista de patrones es amplia, y sólo veremos algunos de ellos. La lista "oficial" de patrones es la siguiente:

- **Patrones creacionales:**
    - Factory Method
    - Astract Factory
    - Builder
    - Singleton
    - Prototype
- **Patrones estructurales:**
    - Adapter
    - Bridge
    - Composite
    - Decorator
    - Facade
    - Flyweight
    - Proxy
- **Patrones de comportamiento:**
    - Chain of Responsibility
    - Command
    - Iterator
    - Mediator
    - Memento
    - Observer
    - State
    - Strategy
    - Template Method
    - Visitor

> Esta lista es una propuesta del libro *Design Pattern, Elements of Reusable Object-Oriented Software* escrito por Erich Gamma, Richard Helm, Ralph Johnson, y John Vlissides, que fue el libro que popularizó el concepto de *patrón de diseño*.

## Patrones creacionales

> Los patrones creacionales proporcionan mecanismos para crear objetos, buscando incrementar la flexibilidad y la reusabilidad del código.

# Patrón número 1. Factory Method

Imaginemos que estamos creando una aplicación de gestión logística. La primera versión de la aplicación sólo trabaja con transportes en camión, de forma que en el código aparece la clase **Camión**. 
Supongamos que la aplicación se hace popular, y se reciben peticiones de compañías de transporte marítimo que desean que la logística marítima se meta también en la aplicación. Inicialmente, nuestra aplicación tiene el siguiente aspecto:

![8ce2684df8d58b9b999904d920b76076.png](img/fm1.png)
*Ilustracción artística de la apliación.*

Ahora mismo, el código estrá repleto de objetos *Camión* por todas partes. Para añadir los barcos, tendremos en primer lugar que crear una interfaz común para nuestros medios de transporte:

![4a301e12db1b3765758663015778afa3.png](img/fm2.png)

Suponiendo que esto es todo lo que hacemos, tendremos que modificar el código, allí donde aparezca la clase *Camión*, para añadir la clase *Barco*, terminando con fragmentos como el siguiente:

```
    Transporte t;
    if (tipoTransporte == Transporte.CAMION){
        t = new Camion();
    } else if (tipoTransporte == Transporte.BARCO){
        t = new Barco();
    }
```
Conforme vayan apareciendo nuevos medios de transporte, tendremos que volver a modificar el código, añadiendo el nuevo medio de transporte a lo largo de la aplicación.

## Solución. 

El patrón **Factory Method** sugiere que en lugar de crear directamente los objetos, los objetos sean creados por un método *factory* específico

![80b7f3200e93a7083394baed4b0e7552.png](img/fm3.png)

1. **Product** declara la interfaz, que es común a todos los objetos que pueden ser creados y sus subclases.
2. **Concrete Products** son implementaciones diferentes de la interfaz *Product* (en nuestro caso, *Camión*, *Barco*, etc.).
3. **Creator** declara el método *factory* que devuelve el nuevo producto. Es importante que el tipo devuelto por este método sea de tipo *Product*. Se puede declarar el método *factory* como abstracto en la case base (*Creator*), para forzar a todas las subclases a implementar sus propias versiones del método. Como alternativa, la clase base puede devolver algún tipo *Product* por defecto.
4. **Concrete Creators** sobreescribe el método *factory*, de forma que devuelve diferentes tipos de producto.

> ¡OJO! Un *factory method* no tiene por qué crear nuevas instancias todo el rato. Puede también devolver objetos de una caché, una lista de objetos, etc.

## Ejemplo

Puedes ver un ejemplo en [src/Patrones_diseño.zip](https://github.com/MauricioMatamala/Programacion/blob/master/Patrones%20de%20dise%C3%B1o/src/patrones_dise%C3%B1o.zip)

## Cuándo aplicar el patrón *Factory method*

- Cuando no sepamos de antemano los tipos exactos de objetos con los que tendrá que trabajar el código. Con este patrón separamos la construcción de un objeto de su uso. 
- Cuando queramos proporcionar a los usuarios de nuestro código una forma de extender los componentes internos.
- Cuando queramos ahorra recursos de cómputo, reutilizando objetos que ya han sido creados anteriormente. Para reutilizar un objeto ya creado anteriormente:
    1. Debemos contar con un depósito donde almacenar los objetos creados (podría ser un objeto de clase *List*, por ejemplo).
    2. Cuando nos solicitan un objeto, el programa puede buscar un objeto libre en dicho depósito. Si existe dicho objeto, devolverlo.
    3. Si no hay objetos libres, se puede crear uno

## Ventajas e inconvenientes

- Minimizamos el acoplamiento entre las clases cliente y sus dependencias.
- Garantizamos el principio SRP, ya que quitamos la responsabilidad de crear el producto adecuado a la clase cliente.
- Garantizamos OCP. Se pueden introducir nuevas clases de producto sin romper el código existente.
- El código se vuelve más complicado.

---------
**Actividad 1**. Deseas poder mostrar información de texto por consola usando diferentes formatos. Para ello, cuentas con las siguientes clases:

- **TextDataViewer** - muestra el contenido de los objetos mediante texto plano.
- **HTMLDataViewer** - muestra el contenido de los objetos mediante código html.

Los datos que necesitas mostrar están en el archivo [poblacion-por-nacionalidades_2016-2018.xml](https://github.com/MauricioMatamala/Programacion/raw/master/Patrones%20de%20dise%C3%B1o/doc/poblacion-por-nacionalidades_2016-2018_alcobendas.xml). 

Para saber cómo mostrar la información, utilizarás un archivo de configuración llamado *.env* que incluye un parámetro llamado *viewer*. Por ejemplo si la impresión debe ser en html, *.env* contendrá:

```
viewer=html
```
en caso de querer mostrarlo en formato de texto, *.env* contendrá:
```
viewer=text
```
#### Cómo debe verse:
Supongamos la línea siguiente del archivo *poblacion-por-nacionalidades_2016-2018.xml*
```
<row Año="2016" Nacionalidad="Afganistán" Número_de_empadronados="9"></row>
```
El resultado en html debe ser como sigue:
```
<table>
    <tr>
        <th>Nacionalidad</th><th>Año</th><th>Total</th>
    </tr>
    
    ...
    
    <tr>
        <td>Afganistán</td><td>2016</td><td>9</td>
    </tr>
    
    ...
    
</table>
```
El resultado en texto debe ser como sigue:
```
Listado de empadronamientos:
    ...
    
    El total de empadronados en 2016 procedentes de Afganistán fue de 9 personas.
    
    ...
```
Aplica el patrón *Factory Method* para crear un proyecto que resuelva el problema. La información que debes mostrar por pantalla es la siguente: [poblacion-por-nacionalidades_2016-2018.xml](https://github.com/MauricioMatamala/Programacion/raw/master/Patrones%20de%20dise%C3%B1o/doc/poblacion-por-nacionalidades_2016-2018_alcobendas.xml)


