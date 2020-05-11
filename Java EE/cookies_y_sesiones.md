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

