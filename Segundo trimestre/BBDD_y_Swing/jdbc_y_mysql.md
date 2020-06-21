# JDBC y MySQL

Para conectar a una base de datos en Java, necesitamos contar con JDBC (Java DataBase Connectivity). Esta librería se puede descargar desde [dev.mysql.com](https://dev.mysql.com/downloads/connector/j/) o bien desde 
[El repositorio central de Maven](https://mvnrepository.com/artifact/mysql/mysql-connector-java).

A continuación se muestra un ejemplo de uso, para una base de datos llamada *pizzas*. El SGBD se encuentra en la máquina local (*localhost*) y las credenciales de usuario son *pizzauser/Perro20*.

```
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
    static String db = "pizzas";
    static String login = "pizzasuser";
    static String password = "Perro20";
    static String url = "jdbc:mysql://localhost:3306/" + db + "?useSSL=false";
    Connection conn = null;
    public DBConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,login,password);

            if (conn!=null){
                System.out.println("Conexión ok: " + conn);

                ResultSet rs = conn.prepareStatement("SELECT nombre FROM pizzas").executeQuery();
                while (rs.next()){
                    System.out.println(rs.getString("nombre"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
```

## Se puede consultar más sobre JDBC y MySQL en los siguientes sitios:

- [zetcode.com](http://zetcode.com/db/mysqljava/)
- [mkyong.com](https://mkyong.com/jdbc/how-to-connect-to-mysql-with-jdbc-driver-java/)
- [baeldung.com](https://www.baeldung.com/java-jdbc)
- [docs.oracle.com](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html)
