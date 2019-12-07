# Actividades de repaso

## Actividad 1

Una empresa está creciendo y va necesitando controlar las actividades de sus empleados. Por eso, está desarrollando una aplicación para que al final de la jornada, cada empleado pueda introducir información sobre las actividades que ha llevado a cabo.

Los proyectos de la empresa están especificados en un documento XML, cuya estructura es la siguiente:

```
<proyectos>
    <proyecto nombre="Alphasec" departamento="Seguridad" fprod="2.5">Descripción</proyecto>
</proyectos>
```

Cada empleado está identificado por su nombre y apellidos, su DNI, su categoría, su productividad y su sueldo. La categoría de un empleado, determina su sueldo base, según la siguiente tabla:

| Categoría | Sueldo base |
|-----------|-------------|
| Técnico| 900€
| Administrador| 1400€
| Programador | 1800€
| Jefe de proyecto | 2500€
| Jefe de operaciones | 3500€

Además de su sueldo base, la nómina de un empleado incluye la productividad, determinada por las actividades que ha llevado a cabo y el tiempo que le ha llevado hacerlas. Cada proyecto con que cuenta la empresa, tiene una factor de productividad dependiendo de su complejidad, de forma que la fórmula *horas x factor de productividad* devuelve los complementos por productividad a pagar al empleado.

Al final de cada jornada, los empleados introducen un resumen de los trabajos que han llevado a cabo, donde especifican los proyectos que han llevado a cabo y el tiempo que han dedicado a cada uno. 

La aplicación debe permitir realizar las siguientes consultas:

1. Listado de tareas realizadas por un empleado, indicando el tiempo dedicado y los proyectos implicados. El resultado se almacenará en un archivo xml DNI como nombre.
2. Tareas llavadas a cabo relacionadas con un proyecto. El resultado se guardará en un archivo xml con el nombre de proyecto como nombre.
3. Lista de Nóminas, incluyendo el apartado de sueldo base, complemento de productividad y sueldo total. El resultado de guardará en un archivo xml con el nombre *nominas.xml*

----------------------------

## Actividad 2

Se necesita una aplicación "Cuaderno del profesor". Esta aplicación permitirá realizar las siguientes tareas:

1. Introducir un nuevo curso.
2. Introducir una nueva asignatura y asociarla a un curso.
3. Introducir un nuevo alumno y asignarlo a un curso.
4. Matricular a un alumno en una asignatura de su curso.
5. Definir un nuevo indicador para una asignatura, que puede ser un ejercicio, un examen o una nota de actitud. Un indicador se aplica a todos los alumnos de la asignatura.
6. Asignar una nota a un indicador para una asignatura y un alumno determinado.
7. Obtener un listado de asignaturas de un curso.
8. Obtener un listado de alumnos de una asignatura.
9. Obtener un listado de notas de un alumno.
10. Exportar/leer los cursos a/desde un documento XML llamado "cursos.xml".
11. Exportar/leer los alumnos de una asignatura y sus calificaciones a/desde un documento XML. Si la asignatura tiene el id *prog* y se imparte en el curso *S11AW*, el documento se llamará *prog_S11AW.xml*

Observa los documentos de ejemplo descritos a continuación para entender la información que deberás gestionar:

El documento *cursos.xml* tendrá un formato como el siguiente:
```
<cursos>
    <curso id="S11AW" nombre="1º Desarrollo de Aplicaciones Web">
        <asignatura id="prog" nombre="Programación"/>
        <asignatura id="ed" nombre="Entornos de desarrollo"/>
                ...
    </curso>
    <curso ...>
            ...
    </curso>
</cursos>
```

El documento relativo a los alumnos y calificaciones de una asignatura (el ejemplo siguiente se llamaría *prog_S11AW.xml*) tendrá un formato similar al siguiente:
```
<asignatura id="prog" nombre="Programación" curso="S11AW">
    <alumno nombre="Juan José López López">
        <indicador tipo="actividad" nombre="Ejercicio 1. Programación estructurada" nota="7.5">
            El alumno no siguió las indicaciones.
        </indicador>
        <indicador tipo="examen" nombre="Examen tema 1" nota="6.75">
            Errores en el apartado b) del ejercicio 2. Ejercicio 3 sin hacer.
        </indicador>
    </alumno>
    ....
</asignatura>
```
-----------------------------------

## Actividad 3

En una fábrica se necesita tener control sobre el inventario de los componentes empleados para fabricar cada uno de los productos. Cada proucto fabricado contiene un conjunto específico de componentes, de forma que cada vez que se fabrica una unidad, se consumen los componentes necesarios para fabricarlo. Veamos un ejemplo:

- El producto "P33" incluye los siguientes componentes:
    - 2 unidades del componente "C130"
    - 1 unidad del componente "C55"
    - 12 unidades del componente "C12"
    - 5 unidades del componente "C7"

Estos requisitos vienen especificados en un documento XML como el siguiente:

```
<productos>
    <producto id="P33">
        <componente id="C130" cantidad="2"/>
        <componente id="C55" cantidad="1"/>
        <componente id="C12" cantidad="12"/>
        <componente id="C7" cantidad="5"/>
    </producto>
    <producto id="P11">
        ....
    </producto>
    ...
</productos>
```
El objetivo de la aplicación es el siguiete

- Monitorizar la fabricación de productos, para que cada vez que se fabrica un nuevo producto se actualice el inventario de componentes. Tras fabricar un cierto producto, si quedan menos unidades de las necesarias para fabricar 10 productos, se debe generar un mensaje informando de la escasez de dicho componente. 
- Mostrar el inventario por pantalla.
- Tambien se desa leer/generar desde/a un documento XML con el inventario de componentes:

```
<inventario>
    <componente id="C1" existencias="200"/>
    <componente id="C2" existencias="5000"/>
    <componente id="C3" existencias="400"/>
    ....
</inventario>
```

-----------------------------------

## Actividad 4

Se desea crear construir un simulador de un sistema de gestión  de tareas. En dicho sistema, existen varios tipos de tareas:

Tipo de tarea | Duración | Prioridad
--------------|----------|----------
A             | 1200     | 1
B             | 600      | 2
C             | 1800     | 3

Existe un planificador que selecciona la siguiente tarea a realizar según algún criterio (que se explica más adelante). Las tareas pueden estar en diferentes estados:

- En espera
- En ejecución
- Terminada

Sólo hay una tarea en ejecución a la vez, aunque pueden haber varias en espera o completadas. Cada tarea puede ser completada en un solo turno, o bien se puede hacer una parte de la tarea y dejar el resto para otro turno. En cualquier caso, hay un registro de tiempo que contabiliza el inicio y el final de cada periodo de espera y de ejecución. El sistema está en una fase de estudio inicial, por lo que la cadena de tareas se va a suministrar manualmente. Por mantener la simplicidad del problema asumiremos que todas las tareas a realizar se saben desde un principio. Por ejemplo, una posibilidad podría ser:  

AAABBCCAAAABABABACCCCAAABACCCCAACACABBABCACB

Esta cadena representa el orden de llegada de las tareas. Es decir, habrían llegado 3 tareas de tipo A, 2 de tipo B, 2 de tipo C, después 4 de tipo A, etc.

EL planificador emplea un algoritmo para determinar cuál es la siguiente tarea a ejecutar. El objetivo principal del proyecto es calcular y comparar los tiempos de espera generados por diferentes algoritmos de planficiacón. A continuación se exponen varios de estos algoritmos de planificación.

Dado un conjunto de tareas a realizar, existen diferentes estrategias para planificarlas:

## FIFO: First In First Out

El algoritmo FCFS no incluye ninguna lógica compleja, solo coloca las solicitudes de proceso en una cola y las ejecuta una por una. Hasta que una tarea no ha sido ejecutada por completo, no se da por concluida.

## SJF: Shortest Job First

Las tareas más cortas se ejecutan primero y luego las más largas.

## RR: Round Robin

Cada tarea es atendida durante un tiempo fijo, por lo que todas las tareas tienen la misma prioridad.
Ninguna tarea queda relegada, ya que cada una tiene un tiempo fijo para ser atendida.
Al tiempo que se dedica a cada tarea, se le llama "cuanto", "tiempo cuántico" o "quantum"

## SRT: Shortest Remaining Time first

Las tareas se eligen según el tiempo que les queda para ser completadas.


## Priority Queue

La prioridad de una tarea se puede seleccionar diferentes criterios, aunque no deben coincidir con SRT ni SJF.

Objetivo: Diseñar un sistema que simule la planificación y ejecución de la secuencia de tareas utilizando cualquiera de los 5 algoritmos anteriores, y genere una estadística con los resultados de la ejecución. Esta estadística debe incluir la siguiente información:
- Tiempo total de ejecución
- Tiempo de espera media de las tareas.
- Tiempo de espera de cada tarea.

---------------------------------

Nota de ayuda: para poder resolver el ejercicio, debes considerar las siguientes cuestiones:
1. Ten en cuenta que sólo se pretenden calcular los tiempos. No es necesario ejecutar realmente las tareas, sino calcular cuánto tiempo  está esperando a ser ejecutado en su totalidad.
2. Debe registrarse el momento de inicio del programa, y usarlo como referencia.
3. Cada tarea debe hacer un seguimiento de su tiempo de espera y de ejecución.
4. En algunos de los algoritmos, una tarea puede ser interrumpida y puesta en cola de nuevo. Esto implica que el tiempo de espera de una tarea se obtiene sumando uno o más tiempos de espera a cada turno de ejecución. Del mismo modo, el tiempo de ejecución de una tarea se obtiene sumando uno o más tiempos de ejecución.
5. Si lo necesitas, puedes consultar el diagrama de clases propuesto como análisis inicial del problema en [diagrama_clases_repaso4.png](diagrama_clases_repaso4.png). No tienes porqué seguir este modelo.
