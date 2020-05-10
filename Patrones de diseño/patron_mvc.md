# El patrón MVC

El patrón es un patrón compuesto. Incluye varios tipos de patrón. La siguiente imagen muestra los detalles:

![Imagen mvc](img/mvc1.png)

Los patrones que se pueden ver son: 

- Strategy: la vista y el controlador implementan el patrón *Strategy*: la vista es un objeto configurado con una estrategia. El controlador proporciona dicha estrategia. La vista se preocupa sólo de los aspectos visuales de la aplicación, y delega al controlador las deciones sobre el comportamiento de la interfaz, como por ejemplo "¿Qué vista debe mostrarse ahora?".
 Usando este patrón, permite mantener la vista desacoplada del modelo, ya que és el controlador quien interactúa con él.

 - Composite: La vista se compone de un conjunto de elementos, paneles, botones y etiquetas de texto. Cada componente de la vista sigue el patrón composite, aunque es algo que dejamos que gestione la librería correspondiente (por ejemplo, *Swing*)

 - Observer: El modelo implementa el patrón observer, para mantener actualizada la vista. Usando este patrón, el modelo se mantiene totalmente independiente de la vista y los controladores. Permite usar diferentes vistas con el mismo modelo.

## MVC en la web

![](img/mvc2.png)

1. Petición HTTP recibida por un servlet
2. El servlet es el controlador. Procesa la petición, y hace peticiones al modelo (con una base de datos detrás). El resultado son objetos con los datos (beans).
3. El controlador elige la vista, representada por un JSP. 
4. La vista obtiene los datos, encapsulados en objetos (beans).
5. La vista es devuelta al navegador.

## Ejemplo

He modificado el ejemplo del patrón observer para que se ajuste a MVC. Dentro hay más anotaciones sobre los detalles del patrón.

[Eejmplo de patrón MVC](src/ejemploPatronesDiseñoConMVC.zip)

**Actividad.** Modifica la actividad del patrón Observer para que se ajuste al patrón MVC. La vista debe tener los siguientes elementos:
- Una lista donde se muestran las temperaturas leídas.
- Un botón llamado "Temperaturas críticas". Al hacer clic sobre él, se muestra un panel con una lista de temperaturas críticas.
- Un botón llamado "Promedio de temperaturas". Al hacer clic sobre él, se muestra un panel con el promedio de temperaturas.

NOTA: Recuerda que: 
- la información es mantenida y calculada por el modelo.
- la vista se limita a mostrar información actualizada en el modelo con el patrón observer (y en casos necesarios pide información al modelo).
- el controlador es un mero transmisor de peticiones desde la vista al modelo y organizador de las vistas.
