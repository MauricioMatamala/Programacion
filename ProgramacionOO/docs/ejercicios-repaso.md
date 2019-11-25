# Actividades de repaso

1. Una empresa está creciendo y va necesitando controlar las actividades de sus empleados. Por eso, está desarrollando una aplicación para que al final de la jornada, cada empleado pueda introducir información sobre las actividades que ha llevado a cabo.

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

