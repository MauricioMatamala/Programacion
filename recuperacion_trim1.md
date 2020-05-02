# Actividad de repaso para la Recuperación del primer trimestre.

Para poder recuperar el primer trimestre, realiaremos una actividad práctica el próximo lunes 11 de mayo. Daré instrucciones concretas sobre el examen el próximo fin de semana. Para que podáis preparar dicha actividad propondré un ejercicio práctico, que deberíais hacer para reforzar vuestros conocimientos de cara al examen. Estaré disponible para resolver las dudas sobre el ejercicio el martes, el jueves y el viernes a partir de las 18.00 en reuniones por Google Meeting cuya invitación enviaré por correo un día antes de cada reunión.

Los alumnos que deban recuperar el primer trimestre deben centrarse en esta actividad de repaso, y no seguir avanzando con el temario del tercer trimestre.

El ejercicio de repaso será el siguiente:

**Actividad de repaso**. Se necesita un software para gestionar los diferentes tipos de medios de transporte públicos de una ciudad. Entre los medios de transporte se encuentran el autobús, el metro y el tranvía. Cuentas con diversos archivos donde se almacena la siguiente información:

[lineas.xml](docs/lineas.xml)

- Tipo de vehículo
- Nombre de la línea
- Nombre de las paradas

Desarrolla una aplicación que pueda consultar la información relativa a las siguientes consultas:

1. Obtener una lista de líneas
2. Obtener una lista de líneas de un cierto tipo (autobús, tranvía o metro)
3. Obtener una lista de paradas disponibles
4. Obtener una lista de líneas que pasen por una parada (Prueba con "Clínico", "El Cónsul" y "Puente de la Aurora", ya que aparecen en más de una línea).
5. Introducir un nuevo vehículo/línea, con sus paradas, a la lista de paradas

Para que trabajes los aspectos que se vieron en el primer trimestre, deberás cubrir los siguientes items:

- Polimorfismo y herencia: Debe existir una clase llamada *Linea* y tres subclases llamadas *Autobus*, *Metro* y *Tranvia*. Evita la repetición de código utilizando el polimorfismo en la medida de lo posible.
- Crea una clase con una interfaz de texto, llamada "UI", que ofrezca todas las opciones pedidas. Asegúrate de que sólo se imprima en consola desde esta interfaz.
- Crea una clase que se llame *Lineas* utilizada por la clase UI, que contenga toda la información sobre las líneas.
- Utiliza objetos de tipo *Collection* para almacenar la información sobre las líneas y las paradas.
- Crea una clase que pueda leer el documento XML y coloque los datos en la clase *Lineas*.


