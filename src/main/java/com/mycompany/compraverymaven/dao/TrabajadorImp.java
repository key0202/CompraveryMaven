package com.mycompany.compraverymaven.dao;
import com.mycompany.compraverymaven.biblioteca.*;
import com.mycompany.compraverymaven.dto.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrabajadorImp implements DaoTrabajador{
    private final Conexion conecta;
    private String mensaje;
    
    public TrabajadorImp(){
        this.conecta=new Conexion();
    }
     //Login del almacenero
    @Override
    public Trabajador login(String user, String pass) {
        Trabajador almacenero=new Trabajador();
        try{
           Connection cn=conecta.conexionDB();
           CallableStatement procedur=cn.prepareCall("{call SP_LoginTrabajador(?,?)}");
           procedur.setString(1, user);
           procedur.setString(2, pass);
           ResultSet rs=procedur.executeQuery();
           if(rs.next()){
               almacenero.setNombre(rs.getString(1));
               almacenero.setCelular(rs.getString(2));
               almacenero.setCargo(rs.getString(3));
               almacenero.setDireccion(rs.getString(4));            
               almacenero.setDni(rs.getString(5));              
           }else{
               almacenero=null; 
               mensaje="Error de login";
           }
        }catch(Exception e){
             Logger.getLogger(TrabajadorImp.class.getName()).log(Level.SEVERE, null, e);
        }
        return almacenero;
    }
    //Registro de trabajadores:
    @Override
  public void registrar_empleado(Trabajador trabajador) {
       try{
            Connection cn=conecta.conexionDB();
            CallableStatement procedur=cn.prepareCall("{call SP_AgregarTrabajador(?,?,?,?,?,?,?}");
            procedur.setString(1,trabajador.getNombre());
            procedur.setString(2,trabajador.getDni());
            procedur.setString(3,trabajador.getDireccion());
            procedur.setString(4,trabajador.getCelular());
            procedur.setString(5,trabajador.getCargo());           
            procedur.setDate(6,Date.valueOf(trabajador.getFecha_ingreso()));
            procedur.setDate(7,Date.valueOf(trabajador.getFecha_cese()));
            
            ResultSet rs=procedur.executeQuery();
        }catch(Exception e){
            e.getMessage();
        }
  }
       
   
    
    //Tarea del administrador para agregar proveedores
    @Override
    public void registrar_proveedor(Proveedor proveedor){
        try{
            Connection cn=conecta.conexionDB();
            CallableStatement procedur=cn.prepareCall("{call SP_AgregarProveedor(?,?,?,?,?}");
            procedur.setString(1,proveedor.getRazonsocial());
            procedur.setString(2,proveedor.getRuc());
            procedur.setString(3,proveedor.getDireccion());
            procedur.setString(4,proveedor.getTelefono());
            procedur.setString(5,proveedor.getCorreo());
            ResultSet rs=procedur.executeQuery();
        }catch(Exception e){
            e.getMessage();
        }
    }
    
    //Tarea del administrador para añadir productos
    @Override
    public void registrar_producto(Producto producto){
        Proveedor provedorcito=new Proveedor();
        try{
            Connection cn=conecta.conexionDB();
            CallableStatement procedur=cn.prepareCall("{call SP_AgregarProducto(?,?,?,?,?)}");
            procedur.setString(1,String.valueOf(producto.getProveedor()));
            procedur.setString(2,producto.getNombre());
            procedur.setString(3,producto.getDescripcion());
            procedur.setString(4,producto.getCategoria());
            procedur.setBlob(5,producto.getImagen());
            ResultSet rs=procedur.executeQuery();
            
        }catch(Exception e){
            e.getMessage();
        }
    }
    //Tarea del administrador para realizar compras
    public Integer generar_compra_proveedor(Integer ruc, LocalDate fecha_compra, Double importe){
        Integer id_compra = null;
        try{
            Connection cn=conecta.conexionDB();
            CallableStatement procedure=cn.prepareCall("{call SP_CompraProveedor(?,?,?)}");
            procedure.setInt(1,ruc);
            procedure.setDate(2,Date.valueOf(fecha_compra));
            procedure.setDouble(3,importe);
            ResultSet rs=procedure.executeQuery();
            if(rs.next()){
                id_compra=rs.getInt(1);
            }else{
                id_compra=null;
            }       
                 
        }catch(Exception e){
            e.getMessage();
        }
         return id_compra;  
    }
    
    //Tarea admi almacen:
     @Override
    public String getMessage() {
        return mensaje;
    }
}
