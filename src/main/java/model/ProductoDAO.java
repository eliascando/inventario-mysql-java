package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    private DataBase db;
    
    public ProductoDAO() {
       db = new DataBase();
    }
    
    public boolean crearProducto(Producto producto) {
        boolean exito = false;
        
        try {
            Connection conexion = db.getConnection();
            
            String query = "INSERT INTO productos (nombre, stock, precio) VALUES (?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            
            statement.setString(1, producto.getNombre());
            statement.setInt(2, producto.getStock());
            statement.setDouble(3, producto.getPrecio());
            
            int filasInsertadas = statement.executeUpdate();
            exito = (filasInsertadas > 0);
            
            statement.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return exito;
    }
    
    public Producto obtenerProducto(int id) {
        Producto producto = null;
        
        try {
            Connection conexion = db.getConnection();
            
            String query = "SELECT * FROM productos WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                int productoId = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                int stock = resultSet.getInt("stock");
                double precio = resultSet.getDouble("precio");
                
                producto = new Producto(productoId, nombre, stock, precio);
            }
            
            resultSet.close();
            statement.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return producto;
    }
    
    public List<Producto> obtenerTodosLosProductos() {
        List<Producto> productos = new ArrayList<>();
        
        try {
            Connection conexion = db.getConnection();
            
            String query = "SELECT * FROM productos";
            Statement statement = conexion.createStatement();
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                int stock = resultSet.getInt("stock");
                double precio = resultSet.getDouble("precio");
                
                Producto producto = new Producto(id, nombre, stock, precio);
                productos.add(producto);
            }
            
            resultSet.close();
            statement.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return productos;
    }
    
    public boolean actualizarProducto(Producto producto) {
        boolean exito = false;
        
        try {
            Connection conexion = db.getConnection();
            
            String query = "UPDATE productos SET nombre = ?, stock = ?, precio = ? WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            
            statement.setString(1, producto.getNombre());
            statement.setInt(2, producto.getStock());
            statement.setDouble(3, producto.getPrecio());
            statement.setInt(4, producto.getId());
            
            int filasActualizadas = statement.executeUpdate();
            exito = (filasActualizadas > 0);
            
            statement.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return exito;
    }
    
    public boolean eliminarProducto(int id) {
        boolean exito = false;
        
        try {
            Connection conexion = db.getConnection();
            
            String query = "DELETE FROM productos WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            
            statement.setInt(1, id);
            
            int filasEliminadas = statement.executeUpdate();
            exito = (filasEliminadas > 0);
            
            statement.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return exito;
    }
}
