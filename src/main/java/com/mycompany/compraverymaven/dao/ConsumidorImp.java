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
import java.util.HashMap;

public class ConsumidorImp implements DaoConsumidor {

    private final Conexion conecta;
    private String mensaje;

    public ConsumidorImp() {
        this.conecta = new Conexion();
    }

    @Override
    public Consumidor login(String usuario, String password) {
        Consumidor consumidor = null;
        try {
            Connection cn = conecta.conexionDB();
            CallableStatement procedur = cn.prepareCall("{call SP_LoginConsumidor(?,?)}");
            procedur.setString(1, usuario);
            procedur.setString(2, password);
            procedur.execute();

            ResultSet rs = procedur.executeQuery();
            consumidor = new Consumidor();

            if (rs.next()) {
                consumidor.setId(rs.getInt(1));
                consumidor.setNombre(rs.getString(2));
                consumidor.setCelular(rs.getString(3));
                consumidor.setDireccion(rs.getString(4));
                consumidor.setDni(rs.getString(5));
            } else {
                consumidor = null;
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }

        return consumidor;

    }

    @Override
    public ArrayList<Producto> Listar_Productos() {
        //  HashMap<Producto,String > claveValor ;
        ArrayList<Producto> list = new ArrayList<Producto>();

        try {
            Connection cn = conecta.conexionDB();
            CallableStatement procedur = cn.prepareCall("{call SP_listarProductos}");
            ResultSet rs = procedur.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt(1));
                producto.setFoto(rs.getBytes(2));
                producto.setNombre(rs.getString(3));
                producto.setDescripcion(rs.getString(4));
                producto.setPrecio(rs.getDouble(5));
                 producto.setId_pi(rs.getInt(6));

                list.add(producto);
            }//Id_producto
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return list;

    }

    @Override
    public ArrayList<Producto> Buscar_Productos(String nombreProducto) {
        ArrayList<Producto> list = new ArrayList<Producto>();
        
        Connection cn =null;
        CallableStatement procedur =null;
        ResultSet rs = null;
        try {
            cn = conecta.conexionDB();
            procedur = cn.prepareCall("{call SP_buscarProductos(?)}");
            procedur.setString(1, nombreProducto);
            rs = procedur.executeQuery();
            while (rs.next()) {
                 Producto producto = new Producto();
                producto.setId(rs.getInt(1));
                producto.setFoto(rs.getBytes(2));
                producto.setNombre(rs.getString(3));
                producto.setDescripcion(rs.getString(4));
                producto.setPrecio(rs.getDouble(5));
                producto.setId_pi(rs.getInt(6));
                //   producto.setFoto(rs.getBytes(1));

                list.add(producto);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                procedur.close();
                rs.close();
                cn.close();
            } catch (Exception ex) {
            }
        }
        return list;
    }

   
    @Override
    public Producto getDatosProducto ( int id_productoInv){
        Producto producto = null;
        
        try {
            Connection cn = conecta.conexionDB();
            CallableStatement procedur = cn.prepareCall("{call SP_DatosProducto(?)}");
            procedur.setInt(1, id_productoInv );
            procedur.execute();
            ResultSet rs = procedur.executeQuery();
            
            producto = new Producto();
            
   
            if (rs.next()) {
                
                if( rs.getMetaData().getColumnCount() == 7 ){
                    producto.setId(rs.getInt(1));
                    producto.setFoto(rs.getBytes(2));
                    producto.setNombre(rs.getString(3));
                    producto.setDescripcion(rs.getString(4));
                    producto.setPrecio(rs.getDouble(5));
                    producto.setPrecioOferta(rs.getDouble(6));
                    producto.setId_pi(rs.getInt(7));           
                }else{
                    producto.setId(rs.getInt(1));
                    producto.setFoto(rs.getBytes(2));
                    producto.setNombre(rs.getString(3));
                    producto.setDescripcion(rs.getString(4));
                    producto.setPrecio(rs.getDouble(5));
                    producto.setId_pi(rs.getInt(6));    
                    producto.setPrecioOferta(rs.getDouble(5));
                }
     
            } else {
                producto = null;
            }
            
            
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        
        
        return producto;
    }
    
    
    
    
    @Override
    public int obtenerUltimoId (){
   
        int ultimoId =1;
      
        String sql = "SELECT MAX(Id_orden_compra) AS id from orden_compra_consumidor";
       
        try (Connection cn = conecta.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ultimoId = rs.getInt(1) +1 ;
                } else {
                   return  ultimoId;
                }
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        
        return ultimoId;
    }
    
    @Override
    public String registroDetalleCompraConsumidor(int idConsumidor, String fechaCompra,int idProInv, int idOrdenCompra, int cant, double precio) {
     
        try (Connection cn = conecta.conexionDB()) {
            CallableStatement procedur = cn.prepareCall("{call SP_AgregarDetalleOrdenCompraConsumidor(?,?,?,?,?,?)}");
            procedur.setInt(1, idConsumidor );
            procedur.setString(2, fechaCompra);
            procedur.setInt(3, idProInv);
            procedur.setInt(4 ,idOrdenCompra);
            procedur.setInt(5, cant);
            procedur.setDouble(6, precio);
            

            int ctos = procedur.executeUpdate();
            if (ctos == 0) {
                mensaje = "cero filas insertadas";
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }

        return mensaje;
    }

   /* public void registraOrdenCompraConsumidor(int idOrdenCompra) {
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE curso SET ")
                .append("Precio_total = ? ")
                .append("WHERE id = ? ");

        try (Connection cn = conecta.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, idOrdenCompra);
            
            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                message = "No se pudo actualizar";
            }
        } catch (SQLException e) {
            message = e.getMessage();
        }

        return message;
        

    }*/

    @Override
    public String getMessage() {

        return mensaje;
    }

}
