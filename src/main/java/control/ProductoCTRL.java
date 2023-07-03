/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.Producto;
import model.ProductoDAO;

/**
 *
 * @author elias
 */
public class ProductoCTRL {
    private Producto producto;
    
    public ProductoCTRL(){
       this.producto = null;
    }
    
    public boolean guardarProducto(String nombre, int cantidad, double precio){
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setStock(cantidad);
        producto.setPrecio(precio);
        
        ProductoDAO dbProducto = new ProductoDAO();
        return dbProducto.crearProducto(producto);
    }
    
    
        
        
    
}
