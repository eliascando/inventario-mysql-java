package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private String url;
    private String user;
    private String pass;
    
    public DataBase() {
        this.url = "jdbc:mysql://localhost:3306/prueba";
        this.user = "admin";
        this.pass = "112471";
    }
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }

    public void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conectarse a la base de datos
            Connection conexion = getConnection();

            // Realiza operaciones con la base de datos utilizando la conexión
            
            // No es necesario cerrar la conexión aquí, ya que se cerrará en el método que la utiliza.
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
