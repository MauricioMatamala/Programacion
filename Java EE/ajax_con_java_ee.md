# Envío de datos mediante consultas AJAX

AJAX es un sueño hecho realidad para los programadores, porque:

- Actualiza una página sin tener volver a cargarla
- Solicita datos del servidor, después de que la página se haya cargado
- Recibe datos desde el servidor, después de que la página se haya cargado
- Se comunica con el servidor en segundo plano

## 1. Enviando una solicitud al servidor mediante AJAX (javascript)

### Paso 1. Inicialización de la solicitud HTTP

```
var xhrequest = new XMLHttpRequest();
xhrequest.open('GET', 'send-ajax-data.php');
```

### Paso 2. Definición de la función callback

Antes de realizar la solicitud, hay que decirle al objeto XMLHttpRequest qué debe hacer cuando llegue la respuesta. Esto se hace mediante la propiead *onreadystatechange*.

```
xhrequest.onreadystatechange = nombreFuncionCallback
```

La función *nombreFuncionCallback* contendrá un código como el siguiente:

```
if (xhrequest.readyState == 4 && xhrequest.status == "200") {
    // HACER ALGO CON LOS DATOS RECIBIDOS: xhrequest.responseText
} else {
	// HUBO UN ERROR
}
```

El atributo *readyState* puede tener diferentes valores, dependiendo del estado de la conexión. La siguiente tabla lo muestra:

| Value |	State	            |   Description |
|-------|-----------------------|----------------|
|0	    |  UNSENT	            |   An XMLHttpRequest object has been created, but the open() method hasn't been called yet (i.e. request not initialized).|
|1	    |  OPENED	            |   The open() method has been called (i.e. server connection established).|
|2	    |  HEADERS_RECEIVED	    |   The send() method has been called (i.e. server has received the request).|
|3	    |  LOADING	            |   The server is processing the request.|
|4	    |  DONE	                |   The request has been processed and the response is ready.|

Por otra parte, el atributo *status* hace referencia al código de estado de la cabecera HTTP recibida desde el servidor: [Descripción de estados HTTP en mozilla.org](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)

### PASO 3. Envío de la solicitud

```
xhrequest.send();

```

En este punto, el paquete *HTTP* ha sido enviado, con la cadena JSON en la carga útil.


### Inciso. Objetos en JavaScript

Las cadenas JSON son consecuencia de la notación para objetos de javascript. De hecho, JSON significa *Java Script Object Notation* (notación de objetos javascript). JavaScript incluye diferentes notaciones para crear clases y objetos, a continuación dejo algunas de ellas, aunque la que nos interesa de cara al envío de datos es la notación de objetos (no la funcional ni de clase).

#### Creación clásica de objetos (notación funcional)

```
function Book (type, author) {
    this.type = type;
    this.author = author;
    this.getDetails = function () {
        return this.type + " written by " + this.author;
    }
}

var book = new Book("Fiction", "Peter King");
alert(book.getDetails());

```

Se pueden usar prototipos para ahorrar memoria, de manera que no se vuelva a declarar la función cada vez que se crea un nuevo objeto.

```
function Book (type, author) {
    this.type = type;
    this.author = author;
    this.prototype.getDetails = function () {
        return this.type + " written by " + this.author;
    }
}

var book = new Book("Fiction", "Peter King");
alert(book.getDetails());

```

#### Creación de objetos mediante clases (notación de clases)
```
 class Car {
  constructor(brand) {
    this.carname = brand;
  }

  present() {
    return "I have a " + this.carname;
  }
}

mycar = new Car("Ford");
document.getElementById("demo").innerHTML = mycar.present();

```

#### Creación de objetos mediante JSON (JavaScript Object Notation)

Esta notación es especialmente apropiada para la creación de objetos tipo DTO (Data Transfer Objet) para el intercambio de datos.

```
var circle = {
    radius : 10,
    area : function() { 
       return Math.PI * this.radius * this.radius; 
    }
};
alert(circle.area());
alert(typeof circle.area);
```

# 2. Envío de un JSON al servidor (todo lo anterior junto) 

Para enviar información mediante AJAX por POST se puede utilizar la notación JSON. En el servidor se un paquete HTTP con la cadena JSON en la carga útil.

```
var jsonEnviado = {valor1: "valor1", valor2: 2}

var xhrequest = new XMLHttpRequest();
xhrequest.open("POST", url, true);
xhrequest.setRequestHeader('Content-type','application/json; charset=utf-8');

xhrequest.onreadystatechange = function () {
	if (xhrequest.readyState == 4 && xhrequest.status == "200") {
	    var JSONrecibido = JSON.parse(xhrequest.responseText);	// El servidor también puede devolver un objeto JSON
        // ... hacer algo con el objeto recibido
	} else {
		console.log("Se produjo un error de comunicación");
	}
}

xhrequest.send(jsonEnviado)
```

# 3. Recepción de la cadena JSON en un servlet.

Existen dos enfoques para obtener el contenido del JSON. Lo que desde luego no funciona es usar *req.getParameter*, porque este método busca en la carga útil datos en formato *x-www-form-urlencoded* o bien *multipart/form-data*, los utilizados para enviar datos desde un formulario.

----------------------------
<img align="left" src="img/tip.png"> 

**NOTA sobre los formatos x-www-form-urlencoded y multipart/form-data**

- Tanto *x-www-form-urlencoded* como *multipart/form-data* son tipos MIME que se utilizan para enviar contenidos por HTTP. 
- Ambas son formas de enviar en pares clave-valor los detalles introducidos en un formulario a un servidor.
- Ambos contenidos se utilizan enviando mediante el método *POST*.
- *x-www-form-urlencoded* es el más usado para enviar datos de texto, mientras que *multipart/form-data* se usa para enviar datos binarios, en concreto archivos.
- Los navegadores soportan ambos tipos MIME
- En el caso de *x-www-form-urlencoded*, todos los pares nombre-valor se envían como una cadena alfanumérica y los caracteres reservados son codificados como una URL (por ejemplo un carácter espacio se reemplaza por *%20*. La longitud de la cadena no está determinada por HTTP, y viene limitada por el servidor).
- En el caso de *multipart/form-data*, cada parte está separada por una cadena, llamada *string boundary*, definida automáticamente por el navegador que separa las partes.
-----------------------------
<br clear="left">

Al enviar una cadena JSON, se está enviando una cadena de texto que no sigue el estándar *x-www-form-urlencoded* ni el *multipart/form-data*. Por ello el método pasa por extraer la carga útil y procesarla manualmente.

> Esto no es preciso si utilizamos JQuery ya que transforma internamente los datos JSON a formato *x-www-form-urlencoded* antes de enviarlos.

### Extraer la cadena JSON de la carga útil

El código necesario para extraer la carga útil como una cadena texto puede ser cualquier de los siguientes:

-  Opción 1. 
```
String json = request.getReader().lines().collect(Collectors.joining());
```
- Opción 2.

```
    String json = "";
    String linea = "";
    BufferedReader br = req.getReader();
    while ((linea = br.readLine()) != null){
        json += linea;
    }
```
### Parsear el contenido de la cadena JSON

El parseo de los datos tiene dos posibles enfoques:

#### Parsear usando JSONParser

Parsear la cadena JSON a un objeto genérico *JSONObject* y acceder a los pares clave-valor como *String* mediante el método *get*.

```
    String value = "";
    JSONParser parser = new JSONParser();
    try {
        JSONObject jsonObj = (JSONObject) parser.parse(json);
        value = (String) jsonObj.get("key");
    } catch (ParseException e) {
        e.printStackTrace();
    }
```

#### Parsear usando GSON a un objeto concreto. 

Primero debemos contar con la clase a la que parsearemos la cadena JSON, en este caso llamada *Contenido*.

```
    Gson gson = new Gson();
    Contenido contenido = gson.fromJson(json, Contenido.class);
```

Para poder utilizar esta opción debemos entender qué clase de equivalencias lleva a cabo GSON. La documentación se puede encontrar en [GSON](https://github.com/google/gson/blob/master/UserGuide.md). Existen algunas líneas generales que podemos seguir:

```
Collection<Integer> ints = Lists.immutableList(1,2,3,4,5);
String json = gson.toJson(ints);  // ==> json is [1,2,3,4,5]

int[] ints = {1, 2, 3, 4, 5};
gson.toJson(ints);     // ==> [1,2,3,4,5]

String[] strings = {"abc", "def", "ghi"};
gson.toJson(strings);  // ==> ["abc", "def", "ghi"]


```

Así pues, prueba este pequeño proyecto para comprender mejor cómo actúa GSON en la serialización y deserialización: [Serialización con GSON](src/SerializacionGSON.zip)

En resumen, lo que se puede ver es que:

| Java | Gson  |
|------|-------------------|
|int numero = 1 | "numero":1|
|String cadena = "AAA" | "cadena":"AAA"|
|List<String> listaDeCadenas | "listaDeCadenas"=["AAA",...,"ZZZ"]|
|Map<Integer,Integer> mapaDeNumeros | "mapaDeNumeros":{"1":"1000",.... "9":"9000"} | 

Además de estos ejemplos, en el ejemplo se pueden ver más casos, como la inclusión de referencias a otros objetos.

# 4. Respuesta desde un servlet (JSON)

Suponiendo que se está devolviendo la información en una cadena JSON, podemos afirmar que no se requere ubicar la capa de presentación en el servidor. Por esto, es adecuado usar un servlet directamente para devolver la respuesta sin usar un script JSP para ello.

Usando esta arquitectura, la presentación queda completamente relegada al lado cliente, y la lógica de negocio y datos quedan en el servidor.

La respuesta de un JSON se puede hacer de varias formas:_

## Crear un JSON manualmente y devolverlo

Siempre podemos crear a mano un JSON, escapando las comillas (a pico y pala):

```
    PrintWriter out = resp.getWriter();
    resp.setContentType("text/json");
    resp.setCharacterEncoding("UTF-8");
    out.write("{\"clave\":\""+miObjeto.getCampo()+"\"}");
```

Para pocos datos, puede ser más que suficiente.

## Utilizar una librería como GSON

Podemos dejar que una librería haga el trabajo:

```
    PrintWriter out = resp.getWriter();
    resp.setContentType("application/json");
    resp.setCharacterEncoding("UTF-8");
    out.write(gson.toJson(persona));
```

Esta opción es más adecuada cuando tengamos objetos complejos con varios campos.

# Un ejemplo sencillo juntándolo todo

El ejemplo en [json_javaee.zip](src/json_javaee.zip) es muy simple, pero ilustra cómo funciona el envío y recepción de cadenas JSON mediante AJAX. Lo que hace es lo siguiente:

----------------------------------
<img align="left" src="img/tip.png"> 

**Descripción del funcionamiento del ejemplo**

En una página hay un formulario con dos campos, *nombre* y *edad*.

Al hacer clic sobre el botón "Enviar", se envía una solicitud AJAX con una cadena JSON que contiene las claves *nombre* y *edad*, y los valores de los campos del formulario. Por ejemplo, para los valores "Pepe" y 33, el JSON enviado es:

    {"nombre":"Pepe","edad":33}

En el servidor se recibe la cadena JSON, y se parsea a un objeto *Persona*. Se incrementa en uno el campo edad del objeto Java. 

Finalmente, se devuelve una cadena JSON con el contenido del objeto.

En el navegador se vuelve a parsear la cadena JSON, y se presenta el resultado.
<br clear="left">

--------------------------------------------------------

