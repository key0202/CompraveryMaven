package com.mycompany.compraverymaven.dao;

import com.mycompany.compraverymaven.biblioteca.Conexion;
import com.mycompany.compraverymaven.dto.Consumidor;
import com.mycompany.compraverymaven.dto.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsumidorImp implements DaoConsumidor{
    private final Conexion conecta;
    private String mensaje;

    public ConsumidorImp() {
        this.conecta = new Conexion();
    }
    
    public Consumidor login(String usuario, String clave) {
        Consumidor consumidor = new Consumidor ();
        try{
           Connection cn=conecta.conexionDB();
           CallableStatement procedur=cn.prepareCall("{call SP_LoginConsumidor(?,?)}");
           procedur.setString(1,usuario);
           procedur.setString(2, clave);
           ResultSet rs=procedur.executeQuery();
           if(rs.next()){
               consumidor.setNombre(rs.getString(1));
               consumidor.setDireccion(rs.getString(2));
               consumidor.setCelular(rs.getString(3));
               consumidor.setDni(rs.getString(4));
           }else{
               consumidor=null;           
           }
        }catch(Exception e){
           e.getMessage();
        }
        
        return consumidor;
      
    }
    
    public ArrayList<Producto> Listar_Productos(){
        ArrayList<Producto> list = new ArrayList<Producto>();
        
    
        try{
            Connection cn=conecta.conexionDB();
           CallableStatement procedur=cn.prepareCall("{call SP_LoginConsumidor(?,?)}");
           ResultSet rs=procedur.executeQuery();
            while(rs.next()){
                Producto producto = new Producto();
                producto.setId(rs.getInt(1));
                producto.setNombre(rs.getString(3));
                producto.setCategoria(rs.getString(4));
                producto.setFoto(rs.getBytes(5));
                producto.setDescripcion(rs.getString(6));
                list.add(producto);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return list;
        
    }
    
    public ArrayList<Producto> Buscar_Productos(String nombreProducto){
        ArrayList<Producto> list = new ArrayList<Producto>();
        
        String sql = "SELECT * FROM producto;";
        Connection cn = null;
        ResultSet rs = null;
        CallableStatement procedur = null;
        try{
            cn=conecta.conexionDB();
           procedur=cn.prepareCall("{call SP_buscarProductos(?)}");
           procedur.setString(1, nombreProducto);
          rs=procedur.executeQuery();
            while(rs.next()){
                Producto producto = new Producto();
                producto.setId(rs.getInt(1));
                producto.setNombre(rs.getString(3));
                producto.setCategoria(rs.getString(4));
                producto.setFoto(rs.getBytes(5));
                producto.setDescripcion(rs.getString(6));
                list.add(producto);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                procedur.close();
                rs.close();
                cn.close();
            }catch(Exception ex){}
        }
        return list;
    } 
    
    
    public void registroDetalleCompraConsumidor (){
        
    }
    
    
    
    public void registraOrdenCompraConsumidor(){
        
    }
    
    
    
    
}
