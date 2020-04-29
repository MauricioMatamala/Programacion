# Introducción

Saber lo que está ocurriendo en el interior de una aplicación es útil, y en muchas ocasiones necesario. Java tiene sus propios mecanismos de Logging, y aunque existen librerías de terceros, el logging que ofrece Java por defecto tiene características más que suficientes para la mayoría de los casos. 

¿De qué hablo en este apartado? Sobre cómo volcar mensajes sobre un archivo de logs, que me permitan revisar qué ha pasado en las ejecuciones anteriores. La mayoría de los servicios tienen sus propios archivos de log. Nosotros vamos a tener nuestro archivo de logs para nuestra aplicación.

![log1.png](img/log1.png)

Esta imagen muestra cómo trabaja el API *java.util.logging*. Sigue las siguientes reglas:
- Los logs son enviados por una instancia de *Logger*.
- Los *loggers* reunen datos en un registro o *LogRecord*.
- Los *Logger* envían los *LogRecord* a un *Handler*, que es el encargado de decidir qué hacer con él.
- Un *LogRecord* es gestionado por un *Handler*, que decide a qué archivo enviarlo.
- Tanto un *Logger* como un *Handler* pueden pasar un *LogRecord* a través de un *Filter*, que determina si debe ser enviado o no (en función de la criticidad, por ejemplo).
- Un *Handler* puede aplicar un formato a un *LogRecord* mediante un *Formatter*, para que ofrezca una u otra información.


# Uso básico

```
public class LoggingExamples {
    ...
    private static final Logger logger = Logger.getLogger(LoggingExamples.class.getName());
    ...
    
    logger.log(Level.SEVERE, "Error doing XYZ", e);
}
```

La cadena pasada como parámetro al método *getLogger()* es el nombre del *Logger* que se va a crear. Se puede elegir cualquier nombre, pero, éste indica dónde se encuentra el Logger. Por eso se suele indicar el nombre de la clase.

Existen mucho métodos diferentes de crear un *log record*, especificados en [https://docs.oracle.com/javase/8/docs/api/java/util/logging/Logger.html](https://docs.oracle.com/javase/8/docs/api/java/util/logging/Logger.html). Algunos son:

```
log  (Level level, String message);
log  (Level level, String message, Object param1);
log  (Level level, String message, Object[] params);

log  (Level level, String message, Throwable t);

log  (LogRecord record);

logp (Level level, String sourceClass, String sourceMethod, String msg);
logp (Level level, String sourceClass, String sourceMethod, String msg, Object param1); 
logp (Level level, String sourceClass, String sourceMethod, String msg, Object[] params);
logp (Level level, String sourceClass, String sourceMethod, String msg, Throwable t);

logrb(Level level, String sourceClass, String sourceMethod, String bundle, String msg);
logrb(Level level, String sourceClass, String sourceMethod, String bundle, String msg, Object param1);
logrb(Level level, String sourceClass, String sourceMethod, String bundle, String msg, Object[] params);
logrb(Level level, String sourceClass, String sourceMethod, String bundle, String msg, Throwable t);


entering(String sourceClass, String sourceMethod);
entering(String sourceClass, String sourceMethod, Object param1);
entering(String sourceClass, String sourceMethod, Object[] params);

exiting (String sourceClass, String sourceMethod);
exiting (String sourceClass, String sourceMethod, Object result);

fine    (String message);
finer   (String message);
finest  (String message);

config  (String message);
info    (String message);
warning (String message);
severe  (String message);

throwing(String sourceClass, String sourceMethod, Throwable t);
```

Por ejemplo:

```
Logger logger = Logger.getLogger("myLogger");
logger.log(Level.SEVERE, "Hello logging");
```

# Agregar un Handler a un Logger

Se puede asignar un *Handler* programáticamente:

```
    Logger logger = Logger.getLogger(this.getClass().getName());
    FileHandler handler = null;
    try {
        handler = new FileHandler("/opt/tomcat/logs/app/app.log");
        Formatter formatter = new SimpleFormatter(); // new XMLFormatter();
        handler.setFormatter(formatter);
        logger.addHandler(handler);
    } catch (IOException e){
        logger = Logger.getLogger(this.getClass().getName());
        logger.severe("Error en la creación de la bitácora");
    }
```

# Asignar un nivel de severidad
Al asignar un nivel de severidad, no se registrarán los mensajes de nivel inferior.

```
    logger.setLevel(Level.INFO);
```
Los niveles de severidad son:

- SEVERE
- WARNING
- INFO
- CONFIG
- FINE
- FINER
- FINEST

Para crear un log de una cierta severidad se puede usar el método *log*:

```
logger.log(Level.SEVERE, "A severe message!");
```

Algunos métodos tienen su propio nivel de servidad. Por ejemplo, el método *entering* tiene nivel *FINER*.

# Formatters

Se pueden usar formateadores predefinidos (*SimpleFormatter* o *XMLFormatter*), o bien definir uno propio.

```
   handler = new FileHandler("/opt/tomcat/logs/app/app.log");
   Formatter formatter = new SimpleFormatter(); // new XMLFormatter();
   handler.setFormatter(formatter);
   logger.addHandler(handler);
```

Para definir un formateador propio:

```
public class MyFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        return record.getLevel() + ":" + record.getMessage();
    }
}
```

# Filters

Para filtrar los logs, hay que definir un filtro:

```
public class MyFilter implements Filter {
    public boolean isLoggable(LogRecord record) {
        return false; // Filtra todos los mensajes
    }
}
```
Para aplicar el filtro al *Logger*:
```
Filter filter = new MyFilter();
logger1.setFilter(filter);

```

# Handlers

Un *Handler* envía los logs a algún lugar fuera de la librería. Se puede añadir más de un *Handler* a un *Logger*. El proceso es el siguiente:

1. El *Logger* envía el *LogRecord* al *Handler*.
2. El *Handler* aplica el filtro al *LogRecord*, determinando y se puede o no "loguear".
3. Si el *LogRecord* es "logueable", se escribe en el destino.
    
Existen múltiples *Handlers* predefinidos, aunque los más utilizados son *ConsoleHandler* y *FileHandler*.

- ConsoleHandler -> reenvía los logs a *logs/catalina.out*
- FileHandler -> reenvia los logs a un archivo especificado. Como por ejemplo en:

```
    FileHandler handler = new FileHandler("myapp-log.%u.%g.txt");
```
Los símbolos que se pueden emplear son:

```
    / 	Separador de directorio.
    %t 	Directorio temporal del sistema.
    %g 	Número de rotación de archivo.
    %u 	Número para evitar conflictos de nombre.
    %% 	Símbolo % solo (escapado)
```
# Información de un LogRecord

En *Formatter* y *Filter* se toma comparámetro un *LogRecord*. Dependiendo del método de log usado, incluye información que se puede obtener mediante los siguientes métodos.

```
getLevel() - devuelve el nivel de severidad
getLoggerName() - devuelve el nombre del logger
getMessage() - mensaje enviado
getMillis() - instante en que se produjo el log
getParameters() - parámetros a insertar en el log
getResourceBundle() - recurso que generó el log
getResourceBundleName() - nombre del recurso que generó el log
getSequenceNumber() - número interno de secuencia del log
getSourceClassName() - nombre de la clase que lanzó el log
getSourceMethodName() - nombre del métod que lanzó el log
getThreadID() - id del hilo de ejecución
getThrown() - *Throwable* agregado en el log
```
# [Java.util.logging vs JULI](https://tomcat.apache.org/tomcat-9.0-doc/logging.html)

La implementación por defecto de *java.util.logging* es demasiado limitada, ya que no permite organizar los log por cada aplicación web. JULI es una implementación del *LogManager* por defecto, que permite definir de manera más personalizada el comportamiento de los logs para cada aplicación. JULI soporta los mismos mecanismos que *java.util.logging*, aunque ofrece más posibilidades para redefinir configuraciones diferentes para cada aplicación.

JULI está activado por defecto, y puede ser configurado en los siguientes niveles:
- Globalmente, mediante un archivo de configuración en *${catalina.base}/conf/logging.properties*
- Por cada aplicación web, en *WEB-INF/classes/logging.properties* (se puede alcanzar esta ubicación colocando el archivo *logging.properties* en la carpeta *resources* del proyecto *Maven*).

Un archivo de configuración para una aplicación, puede ser:

```
handlers = org.apache.juli.FileHandler, java.util.logging.ConsoleHandler

############################################################
# Handler specific properties.
# Describes specific configuration info for Handlers.
############################################################

# Configuración del handler FileHandler
# Con estas líneas indicamos que el logger de la aplicación userá por defecto el FileHandler con la siguiente configuración
#   Nivel de severidad cuando se escriba un log en el fichero
org.apache.juli.FileHandler.level = FINE
#   Directorio donde estará el fichero de logs
org.apache.juli.FileHandler.directory = ${catalina.base}/logs
#   Nombre del archivo donde de escribirán los logs
org.apache.juli.FileHandler.prefix = ${classloader.webappName}.


java.util.logging.ConsoleHandler.level = FINE
java.util.logging.ConsoleHandler.formatter = java.util.logging.OneLineFormatter
```
# [Modificar el formato de los logs sin necesidad de escribir un formateador](https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax)

Desde el archivo de configuración se puede modificar el formato de los logs. Esto se puede añadir en el archivo de configuración una línea como la siguiente: 

```
java.util.logging.SimpleFormatter.format=%4$s -> %5$s [%1$tc]%n
```

Donde los índices de argumento son:
- %1$ = Fecha
- %2$ = Fuente, una cadena que representa a la entidad que realizó la llamada (si está disponible), o en su defecto el nombre del logger.
- %3$ = Nombre del logger.
- %4$ = Nivel de severidad.
- %5$ = Mensaje.
- %6$ = Cadena de texto con la excepción lanzada (si es que se lanzó) o una cadena vacía.

Los argumentos, pueden acompañarse de otros caracteres que enriquecen su mostrado. La forma general de un argumento es:

```
   %[argument_index$][flags][width][.precision]conversion
```  
> Donde *%[argument_index$]* representa una cadena como *%1$*, siendo *argument_index* == 1.

Las opciones *flags*, *width* y *precision* afectan a los detalles de visualización. Para saber más, ir a [https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax](https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax)

**Conversion:**

Indica cómo debe formatearse un cierto dato. Se dividen en las siguientes categorías:

- **General** - Se puede aplicar a cualquier tipo
- **Carácter** - Se puede aplicar a tipos básicos representados por codificación Unicode: char, Character, byte, Byte, short y Short. Esta conversión se puede aplicar a tipos *int* e *Integer* cuando *Character.isValidCodePoint(int)* devuelve true.
- **Numeric** 
    - **Integral** - Se aplica a los tipos *byte*, *Byte*, *short*, *Short*, *int*, *Integer*, *long*, *Long* y *BigInteger*.
    - **Floating Point** - Se aplica a los tipos *float*, *Float*, *double*, *Double* y *BigDecimal*.
- **Date/Time** - Se aplica a los tipos que codifican fechas: *long*, *Long*, *Calendar*, y *Date*.
- **Percent** - Produce el literal '%' ('\u0025')
- **Line Separator** - Introduce un separador de línea según el sistema. 

Las conversiones posibles pueden aparecer en mayúscula (por ejemplo, 'B', 'H', 'S', 'C', 'X', 'E', 'G', 'A' y 'T') o en minúscula. El resultado es igual, salvo que el resultado es mostrado en mayúscula.

Conversión |Categoría |	Descripción
-----------|---------|---------|------------------
'b', 'B' | 	general | 	If the argument arg is null, then the result is "false". If arg is a boolean or Boolean, then the result is the string returned by String.valueOf(arg). Otherwise, the result is "true".
'h', 'H' |	general |	If the argument arg is null, then the result is "null". Otherwise, the result is obtained by invoking Integer.toHexString(arg.hashCode()).
's', 'S' |	general |	If the argument arg is null, then the result is "null". If arg implements Formattable, then arg.formatTo is invoked. Otherwise, the result is obtained by invoking arg.toString().
'c', 'C' |	character |	The result is a Unicode character
'd' |	integral |	The result is formatted as a decimal integer
'o' |	integral |	The result is formatted as an octal integer
'x', 'X' |	integral |	The result is formatted as a hexadecimal integer
'e', 'E' |	floating point |	The result is formatted as a decimal number in computerized scientific notation
'f' |	floating point |	The result is formatted as a decimal number
'g', 'G' |	floating point |	The result is formatted using computerized scientific notation or decimal format, depending on the precision and the value after rounding.
'a', 'A' |	floating point |	The result is formatted as a hexadecimal floating-point number with a significand and an exponent
't', 'T' |	date/time |	Prefix for date and time conversion characters. See Date/Time Conversions.
'%' |	percent |	The result is a literal '%' ('\u0025')
'n' |	line separator |	The result is the platform-specific line separator

# Conversiones de fecha

Los sufijos de conversión de fecha están definidos por conversiones 't' o 'T'. Hay conversiones adicionales para el acceso a funcionalidades específicas de Java (como 'L' para los milisegundos dentro de un segundo)

Los siguientes caracteres de conversión son usados para formatear fechas:

Conversión | Descripción
-----------|---------------
'H' |	Hour of the day for the 24-hour clock, formatted as two digits with a leading zero as necessary i.e. 00 - 23.
'I' |	Hour for the 12-hour clock, formatted as two digits with a leading zero as necessary, i.e. 01 - 12.
'k' |	Hour of the day for the 24-hour clock, i.e. 0 - 23.
'l' |	Hour for the 12-hour clock, i.e. 1 - 12.
'M' |	Minute within the hour formatted as two digits with a leading zero as necessary, i.e. 00 - 59.
'S' |	Seconds within the minute, formatted as two digits with a leading zero as necessary, i.e. 00 - 60 ("60" is a special value required to support leap seconds).
'L' |	Millisecond within the second formatted as three digits with leading zeros as necessary, i.e. 000 - 999.
'N' |	Nanosecond within the second, formatted as nine digits with leading zeros as necessary, i.e. 000000000 - 999999999.
'p' |	Locale-specific morning or afternoon marker in lower case, e.g."am" or "pm". Use of the conversion prefix 'T' forces this output to upper case.
'z' |	RFC 822 style numeric time zone offset from GMT, e.g. -0800. This value will be adjusted as necessary for Daylight Saving Time. For long, Long, and Date the time zone used is the default time zone for this instance of the Java virtual machine.
'Z' |	A string representing the abbreviation for the time zone. This value will be adjusted as necessary for Daylight Saving Time. For long, Long, and Date the time zone used is the default time zone for this instance of the Java virtual machine. The Formatter's locale will supersede the locale of the argument (if any).
's' |	Seconds since the beginning of the epoch starting at 1 January 1970 00:00:00 UTC, i.e. Long.MIN_VALUE/1000 to Long.MAX_VALUE/1000.
'Q' |	Milliseconds since the beginning of the epoch starting at 1 January 1970 00:00:00 UTC, i.e. Long.MIN_VALUE to Long.MAX_VALUE.
'B' |	Locale-specific full month name, e.g. "January", "February".
'b' |	Locale-specific abbreviated month name, e.g. "Jan", "Feb".
'h' |	Same as 'b'.
'A' |	Locale-specific full name of the day of the week, e.g. "Sunday", "Monday"
'a' |	Locale-specific short name of the day of the week, e.g. "Sun", "Mon"
'C' |	Four-digit year divided by 100, formatted as two digits with leading zero as necessary, i.e. 00 - 99
'Y' |	Year, formatted as at least four digits with leading zeros as necessary, e.g. 0092 equals 92 CE for the Gregorian calendar.
'y' |	Last two digits of the year, formatted with leading zeros as necessary, i.e. 00 - 99.
'j' |	Day of year, formatted as three digits with leading zeros as necessary, e.g. 001 - 366 for the Gregorian calendar.
'm' |	Month, formatted as two digits with leading zeros as necessary, i.e. 01 - 13.
'd' |	Day of month, formatted as two digits with leading zeros as necessary, i.e. 01 - 31
'e' |	Day of month, formatted as two digits, i.e. 1 - 31.
'R' |	Time formatted for the 24-hour clock as "%tH:%tM"
'T' |	Time formatted for the 24-hour clock as "%tH:%tM:%tS".
'r' |	Time formatted for the 12-hour clock as "%tI:%tM:%tS %Tp". 
'D' |	Date formatted as "%tm/%td/%ty".
'F' |	ISO 8601 complete date formatted as "%tY-%tm-%td".
'c' |	Date and time formatted as "%ta %tb %td %tT %tZ %tY", e.g. "Sun Jul 20 16:17:00 EDT 1969".

 # Ejemplos
 
``` 
java.util.logging.SimpleFormatter.format="%4$s: %5$s [%1$tc]%n"**
```
Muestra: 
```    
WARNING: esto es un mensaje [Tue Apr 22 13:11:31 PDT 2020]
```
Donde:

- %4$s genera "WARNING"
- %5$s genera "esto es un mensaje" (el mensaje enviado)
- %1$tc genera "Tue Apr 22 13:11:31 PDT 2020"
----------------------
```
java.util.logging.SimpleFormatter.format="%1$tc %2$s%n%4$s: %5$s%6$s%n"
```
Muestra:
```
     Tue Apr 22 13:11:31 PDT 2020 MyClass
         SEVERE: mensaje grave con una excepción
         java.lang.IllegalArgumentException: invalid argument
                 at MyClass.mash(MyClass.java:9)
                 at MyClass.crunch(MyClass.java:6)
                 at MyClass.main(MyClass.java:3)
         
```

Donde:

- %1$tc genera  "Tue Apr 22 13:11:31 PDT 2020"
- %2$s genera "MyClass"
- %4$s genera "SEVERE"
- %5$s genera "mensaje grave con una excepción"
- %6$s genera "java.lang.IllegalArgumentException: invalid argument
                 at MyClass.mash(MyClass.java:9)
                 at MyClass.crunch(MyClass.java:6)
                 at MyClass.main(MyClass.java:3)"

---------
```
java.util.logging.SimpleFormatter.format="%1$tb %1$td, %1$tY %1$tl:%1$tM:%1$tS %1$Tp %2$s%n%4$s: %5$s%n"
```
Muestra:

```
Apr 22, 2020 1:11:31 PM MyClass
         SEVERE: mensaje grave con una excepción
```

Donde:

- %1$tb genera "Apr"
- %1$td genera "22"
- %1$tY genera "2020"
- %1$tl genera "1"
- %1$tM genera "11"
- %1$tS genera "31"
- %1$Tp genera "PM"
- %2$s genera "MyClass"
- %4$s genera "SEVERE"
- %5$s genera "mensaje grave con una excepción"

Utilizando estos formateadores, el archivo *logging.properties* comentado antes quedaría así:

```
handlers = org.apache.juli.FileHandler, java.util.logging.ConsoleHandler

############################################################
# Handler specific properties.
# Describes specific configuration info for Handlers.
############################################################

org.apache.juli.FileHandler.level = FINE
org.apache.juli.FileHandler.directory = ${catalina.base}/logs/${classloader.webappName}
org.apache.juli.FileHandler.prefix = ${classloader.webappName}.
org.apache.juli.FileHandler.formatter = java.util.logging.SimpleFormatter

java.util.logging.ConsoleHandler.level = FINE
java.util.logging.ConsoleHandler.formatter = java.util.logging.SimpleFormatter
java.util.logging.SimpleFormatter.format=[%4$s]:%2$s -> %5$s [%1$tc]%n
```

--------------------------

**Actividad 1.** Escribe una aplicación siguiendo el patrón MVC, usando una página frontal html (llamada *suma.html*) con un formulario que tome dos números, un servlet (llamado *SumaServlet*) y un archivo JSP (llamado *suma.jsp*). Además, crea una clase llamada *Suma* que sume dos números. Configura el proyecto para escribir logs como los siguientes:

![actividad](img/log2.png)

Ten en cuenta las siguientes cuestiones:

- El archivo de logs debe ubicarse en una carpeta dedicada para el proyecto. Por ejemplo, en la captura los logs están en la carpeta */opt/tomcat/latest/logs/SumaLogging*. El contenido del archivo de logs generado debe tener una estructura similar a la mostrada:

```
18:53 (servlets.SumaServlet doPost) [INFO]: El resultado es 25

hora (origen del log) [severidad]: mensaje
```

- El último log, realizado desde el archivo JSP debe contener tu nombre.

- El comando *pwd* muestra tu ubicación en el sistema de archivos. Ejecútalo para poder comprobar en qué punto está el archivo de Logs.

- El comando *cat* muestra el contenido de un archivo. Muestra el contenido del archivo de logs.

Toma una captura similar a la mostrada, donde se pueda ver:

1. El resultado de ejecutar el comando *pwd*.
2. El resultado de ejecutar el comando *cat* sobre el archivo de logs.
3. Tu nombre en el último log, realizado desde el archivo JSP.

