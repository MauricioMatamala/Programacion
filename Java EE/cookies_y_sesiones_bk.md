# Necesidad de sesiones

HTTP no tiene estado. Las sesiones consisten en un mecanismo que permite añadir estado a la comunicación entre el navegador y el servidor.

Java incluye un API para la adminsitración de las sesiones.

## Sesiones en Java - Cookies

Una cookie es un fragmento de infomración que se almacena en el nevegador del usuario. Las cookies viajan en la cabecera HTTP en cada nueva petición. 

### Crear una nueva petición

```
    Cookie uiColorCookie = new Cookie("color", "red");
    response.addCookie(uiColorCookie);
```   

### Establecer una fecha de expiración (en segundos)

```
    uiColorCookie.setMaxAge(60*60);
```

### Establecer donde será enviada

Se puede indicar cuándo enviar una cookie. Por ejemplo, podemos indicar si una cookie estará asociada a una cierta URL y todos sus subdirectorios.

```
    uiColorCookie.setPath("/welcomeUser");
```

### Leer una cookie

Cuando se crea un cookie, ésta es almacenada en el equipo del usuario, y gestionada por el navegador. A partir de ese momento, y mientras la *cookie* siga viva (no caduque), será enviada desde el cliente (navegador) en cada cabecera HTTP enviada al servidor. En el servidor se puede extraer de la cabecera y consultar su valor. El lugar idóneno donde hacer eso es en un *servlet*.

```
    String color = null;
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
    for(Cookie cookie : cookies){
    	if(cookie.getName().equals("uiColorCookie")) color = cookie.getValue();
    }
```

### Borrar una cookie

Cuando una *cookie* ya no va a ser utilizada más, es deseable eliminarla, para evitar la sobrecarga en las conexiones HTTP. Además, pueden haber más razones para eliminar una *cookie*, como por ejemplo, si cierto comportamiento de la aplicación está asociado al valor de una *cookie*. Cierto evento puede conducir a detener dicho comportamiento, para lo cual será necesario eliminar la *cookie*.

```
    Cookie userNameCookieRemove = new Cookie("userName", "");
    userNameCookieRemove.setMaxAge(0);
    response.addCookie(userNameCookieRemove);
```

Por ejemplo, podemos desear eliminar una cookie cuando un usuario cierra sesión.
    
# Sesiones en Java - HttpSession

Mediante *HttpSession* podemos almacenar **información del usuario en el lado del servidor**. El contenedor (Tomcat) usa la interfaz *HttpSession* para crear una sesión entre un cliente y un servidor HTTP. La sesión se mantiene por un periodo especificado de tiempo, a lo largo de más de una conexión. Una sesión se corresponde con un único usuario, que puede visitar un sitio varias veces, mientras se mantiene dicha información. La interfaz *HttpSession* permite a los *servlets*:

- Ver y mantener información sobre una sesión, como el identificador de sesión, fecha de creación y última acceso.
- Asociar objetos a sesiones, permitiendo a la información de suario persistir a lo largo de muchas conexiones.

Una sesión es asociada a un cliente mediante una **cookie de sesión**, que contiene un identificador generado en el servidor para identificar la sesión actual. El *cliente* almacena y guarda el id de sesión como una *cookie HTTP* llamada *JSESSIONID*. Lo único que sabe el navegador de la *cookie de sesión* es este identificador.

## Obtener una sesión

```
    HttpSession session = request.getSession();
```   

De este modo se obtiene una sesión. 

Si la sesión no existía, es creada de forma que:
- Se crea una *cookie de sesión* en el navegador.
- Se crea un objeto de sesión en el lado servidor, vinculado la *cookie de sesión*.

Si la sesión sí existía, se obtiene el objeto *HttpSession* correspondiente, con toda la información que haya sido guardada en ella.

-------------------------------------------------------------------------
<img align="left" src="img/tip.png"> 

**NOTA**

Si queremos controlar la creación de una nueva sesión en caso de que no exista, podemos usar un parámetro booleano:

```
    HttpSession session = request.getSession(true);
    // Crear sesión si no existe
    
    HttpSession session = request.getSession(false);
    // No crear sesión si no existe.
```
-------------------------------------------------------------------------

Al acceder a un archivo JSP por primera vez, se crea una sesión por defecto. Podemos impedirlo añadiendo lo siguiente:

```
    <%@ page contentType="text/html;charset=UTF-8" session="false" %>
```

Al crear una nueva sesión, la cookie de sesión almacena en el lado cliente se llama *JSESSIONID*.

## Atributos de una sesión

El objeto de sesión permite crear, leer, modificar y borrar atributos mediante los siguientes métodos. Estos atributos pueden ser cualquier cosa que queramos almacenar, incluidos objetos completos:

- *setAttribute(String key, Object value)*: crea o reemplaza un atributo con clave *key* y un valor *value*.
- *Object getAttribute(String key)*: permite recuperar un valor para un atributo. Si no hay atibutos con esa clave, se devuelve *null*.
- *void removeAttribute(String key)*: borra un atributo.
- *long getCreationTime()*: devuelve el instante en que fue creada (siguiendo el esquema de Date). 
- *long getLastAccessedTime()*: devuelve el instante en que fue accedida la sesión por última vez.
- *void setMaxInactiveInterval(int intervalInSecs)*: devuelve el tiempo máximo entre accesos, antes de ser invalidada. Se puede obtener este valor mediante el método *getMaxInactiveInterval()*.
- *void invalidate()*: invalida la sesión y elimina todos los objetos vinculados a ella.

```
HttpSession session = request.getSession();
session.setAttribute("attributeKey", "Sample Value");
session.getAttribute("attributeKey");
```

En el siguiente enlace hay un ejemplo que utiliza sesiones: [Actividad sesiones](src/Actividad_sesiones.zip)

## Cómo utilizar una sesión

Existen algunas indicaciones que pueden ser de ayuda a la hora de usar sesiones. Un ejemplo típico es el inicio de sesión:

- En un servlet se puede obtener la sesión y comprobar si hay un cierto atributo almacenado, como "Usuario":
    - Si el atributo buscado (ejemplo, "Usuario") es null, significa que no hay un usuario logueado.
    - Si existe el atributo (ejemplo, "Usuario"), significa que hay un usuario logueado, y por tanto se puede extraer toda su información del objeto.

Además de la información del usuario, se puede almacenar cualquier información que se desee, incluidos objetos de tipo *Collections*, como *List* o *Map*. De forma que se puede guardar el estado de la aplicación para un usuario en la sesión.
--------------------------

El siguiente ejemplo muestra un programa que utiliza sesiones para almacenar los datos de una persona. Hasta que no se cierra la sesión (mediante el botón "cerrar sesión") no se puede volver a guardar los datos de otra persona. [Código del ejemplo](src/Ejemplo_sesiones.zip)



-------------------------
**Actividad 1.** El objetivo de este ejercicio es crear una *cookie* desde el servidor. En este caso, la *cookie* es el código hexadecimal de un color.

Crea una aplicación que permita elegir un color de fondo de página. Para ello, utiliza el siguiente fragmento de código html:

```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Color</title>
</head>
<body>
    <p>Elige un color de fondo</p>
    <form>
        <input type="color" id="color" name="color"/>
        <button id="enviar_color">Enviar</button>
    </form>
</body>
</html>
```
Cuando elijas el color, éste debe ser enviado a un servlet, llamado *CookieColorServlet*, en una cadena JSON como la siguiente:

    {"color":"#13763c"}

Siendo *#13763c* el color elegido.

El servlet *ColorServlet* creará una *cookie* llamada *color*, con el color elegido, y devolverá una cadena JSON similar a la siguiente:

    {"status":"ok","color":"#13763c"}

Cuando el documento html recibe la cadena JSON, cambia aplica el color elegido al fondo de la página. Para ello, puedes utilizar las siguientes líneas de código:

```
    let body = document.getElementsByTagName("BODY")[0];
    body.style.backgroundColor = jsonRecibido.color;
```

Debes además comprobar que se ha creado la *cookie* correspondiente en el navegador (a través de las herramientas para programadores).

-------------------------------------
**Actividad 2.** En el ejercicio anterior, creaste una *cookie*, pero ahora el objetivo no es crearla, sino leerla. Es decir, si existe, comprobar el valor que tiene, y hacer algo con ese valor.

Imagina que en el ejercicio anterior, cierrras el navegador, y lo vuelves a abrir. A priori, el fondo de página es blanco. Pero si existe una *cookie* creada anteriormente, podrías leerla, y decirle al navegador que cambie el color de fondo de *body*. ¿Cómo se puede hacer esto? Utilizando el evento *onload*:

```
 window.addEventListener("load",function(e){
    // Todo lo que metas aquí se ejecuta al cargar la página
 }
```
Cuando se carge la página, deberás consultar a un servlet llamado *ColorElegidoServlet*, que devolverá lo siguiente al lado cliente:

- En caso de que la *cookie* exista, obtiene su valor, y lo devuelve en una cadena JSON como la siguiente:

    {"status":"ok","color":"#13763c"} // suponiendo que #13763c es el color almacenado en la cookie

- En caso de que la *cookie* no exista, devuelve una cadena JSON como la siguiente:

    {"status":"ko"}

Cuando el lado cliente recibe la cadena JSON, actúa sobre el fondo en caso de que *status* sea *ok*.

Adjunto un vídeo con el comportamiento del ejercicio: [Vídeo](img/act2_cookies.mp4)

---------------------------------------------------

**Actividad 3**. Crea una aplicación que permite añadir nombres de personas y su edad en una lista. Utiliza *HttpSession* para guardar los datos de las personas añadidas. Mientras la sesión esté activa, ve guardando los datos en ella. 

Los datos de las personas añadidas deben mostrarse en una lista por pantalla. 

Debes tener en cuenta que:
- Existe una clase llamada *Persona* que contiene la información relativa a una persona.
- Los datos de cada *Persona* se deben guardar en un *ArrayList* en el servidor.
- Cuando abras el navegador, deben mostrarse desde el primer momento los nombres de las personas añadidas.

Adjunto un vídeo con el comportamiento del ejercicio: [Vídeo](img/act3_sesiones.mp4)