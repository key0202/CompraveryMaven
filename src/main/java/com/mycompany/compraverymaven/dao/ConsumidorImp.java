package com.mycompany.compraverymaven.dao;

import com.mycompany.compraverymaven.biblioteca.Conexion;
import com.mycompany.compraverymaven.dto.Consumidor;
import com.mycompany.compraverymaven.dto.OrdenCompraConsumidor;
import com.mycompany.compraverymaven.dto.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

                consumidor.setNombre(rs.getString(1));
                consumidor.setCelular(rs.getString(2));
                consumidor.setDireccion(rs.getString(3));
                consumidor.setDni(rs.getString(4));
                consumidor.setId(rs.getInt(5));
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
                //   producto.setFoto(rs.getBytes(1));

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

        Connection cn = null;
        CallableStatement procedur = null;
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

    /*
    public Producto getDatosProducto ( int id_producto){
        Producto producto = null;
        
        try {
            Connection cn = conecta.conexionDB();
            CallableStatement procedur = cn.prepareCall("{call SP_LoginConsumidor(?,?)}");
            procedur.setInt(1, id_producto );
            procedur.execute();
            ResultSet rs = procedur.executeQuery();
            
            producto = new Producto();
            if (rs.next()) {

                producto.setNombre(rs.getString(1));
                producto.setCelular(rs.getString(2));
                producto.setDireccion(rs.getString(3));
                producto.setDni(rs.getString(4));
            } else {
                producto = null;
            }
            
            
        } catch (Exception e) {
        }
        
        
        return producto;
    }*/
    public void registroDetalleCompraConsumidor() {

    }

    public void registraOrdenCompraConsumidor() {

    }

    @Override
    public String getMessage() {

        return mensaje;
    }

    @Override
    public List<OrdenCompraConsumidor> verordenesconsumidor(Integer id, LocalDate fecha1, LocalDate fecha2) {
        List<OrdenCompraConsumidor> variable = null;
        try {
            Connection cn = conecta.conexionDB();
            CallableStatement procedur = cn.prepareCall("{call SP_HistorialPedidosConsumidor(?,?,?)}");
            procedur.setInt(0,id);
            procedur.setDate(1, Date.valueOf(fecha1));
            procedur.setDate(2, Date.valueOf(fecha2));
            try (ResultSet rs = procedur.executeQuery()) {
                variable = new ArrayList<>();
                while (rs.next()) {
                    OrdenCompraConsumidor compr = new OrdenCompraConsumidor();
                    compr.setId(rs.getInt(1));
                    compr.setFecha_compra(LocalDate.parse(rs.getDate(2).toString()));
                    compr.setImporte_total(Double.parseDouble(rs.getString(3)));
                    variable.add(compr);
                }
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return variable;

    }

}
