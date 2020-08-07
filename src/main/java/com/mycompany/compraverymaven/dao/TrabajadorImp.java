package com.mycompany.compraverymaven.dao;

import com.mycompany.compraverymaven.biblioteca.*;
import com.mycompany.compraverymaven.dto.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrabajadorImp implements DaoTrabajador {

    private final Conexion conecta;
    private String mensaje;

    public TrabajadorImp() {
        this.conecta = new Conexion();
    }
    //Login del almacenero

    @Override
    public Trabajador login(String user, String pass) {
        Trabajador almacenero = new Trabajador();
        try {
            Connection cn = conecta.conexionDB();
            CallableStatement procedur = cn.prepareCall("{call SP_LoginTrabajador(?,?)}");
            procedur.setString(1, user);
            procedur.setString(2, pass);
            ResultSet rs = procedur.executeQuery();
            if (rs.next()) {
                almacenero.setNombre(rs.getString(1));
                almacenero.setCelular(rs.getString(2));
                almacenero.setCargo(rs.getString(3));
                almacenero.setDireccion(rs.getString(4));
                almacenero.setDni(rs.getString(5));
            } else {
                almacenero = null;
                mensaje = "Error de login";
            }
        } catch (Exception e) {
            Logger.getLogger(TrabajadorImp.class.getName()).log(Level.SEVERE, null, e);
        }
        return almacenero;
    }

    //Registro de trabajadores:
    @Override
    public String registrar_empleado(Trabajador trabajador) {
        try {
            Connection cn = conecta.conexionDB();
            CallableStatement procedur = cn.prepareCall("{call SP_AgregarTrabajador(?,?,?,?,?,?,?)}");
            procedur.setString(1, trabajador.getNombre());
            procedur.setString(2, trabajador.getDni());
            procedur.setString(3, trabajador.getDireccion());
            procedur.setString(4, trabajador.getCelular());
            procedur.setString(5, trabajador.getCargo());
            procedur.setString(6, trabajador.getFecha_ingreso().toString());
            procedur.setString(7, trabajador.getFecha_cese().toString());

            ResultSet rs = procedur.executeQuery();
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    //Tarea del administrador para agregar proveedores
    @Override
    public void registrar_proveedor(Proveedor proveedor) {
        try {
            Connection cn = conecta.conexionDB();
            CallableStatement procedur = cn.prepareCall("{call SP_AgregarProveedor(?,?,?,?,?)}");
            procedur.setString(1, proveedor.getRazonsocial());
            procedur.setString(2, proveedor.getRuc());
            procedur.setString(3, proveedor.getDireccion());
            procedur.setString(4, proveedor.getTelefono());
            procedur.setString(5, proveedor.getCorreo());
            ResultSet rs = procedur.executeQuery();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    //Tarea del administrador para añadir productos
    @Override
    public void registrar_producto(Producto producto) {

        try {
            Connection cn = conecta.conexionDB();
            CallableStatement procedur = cn.prepareCall("{call SP_AgregarProducto(?,?,?,?,?)}");
            procedur.setString(1, producto.getProveedor());
            procedur.setString(2, producto.getNombre());
            procedur.setString(3, producto.getDescripcion());
            procedur.setString(4, producto.getCategoria());
            procedur.setBytes(5, producto.getImagen());
            ResultSet rs = procedur.executeQuery();

        } catch (Exception e) {
            e.getMessage();
        }
    }

    //Tarea del administrador para realizar compras
    @Override
    public void generar_compra_proveedor(String ruc, ComprasTiendaProveedor fecha_compra, Double importe) {
       
        try {
            Connection cn = conecta.conexionDB();
            CallableStatement procedure = cn.prepareCall("{call SP_CompraProovedor(?,?,?)}");
            procedure.setString(1, ruc);
            procedure.setString(2, fecha_compra.getFecha_compra().toString());
            procedure.setDouble(3, importe);
            ResultSet rs = procedure.executeQuery();

        } catch (Exception e) {
            e.getMessage();
        }

    }

    //Metodo para grabar los detalles de la compra:
    @Override
    public void detalle_orden_compra(Integer id_compra_proveedor, Producto producto, Integer cantidad, Double precio) {
        try {
            Connection cd = conecta.conexionDB();
            CallableStatement procedur = cd.prepareCall("{call SP_GrabarDetalleCompras(?,?,?,?)}");
            procedur.setInt(1,id_compra_proveedor);
            procedur.setString(2,producto.getNombre());
            procedur.setInt(3,cantidad);
            procedur.setDouble(4,precio);
            ResultSet rs=procedur.executeQuery();           
        } catch (Exception e) {
            e.getMessage();
        }
    }

    //Tarea admi almacen:
    @Override
    public String getMessage() {
        return mensaje;
    }

    //Metodo para cargar el comboBox con los proveedores
    @Override
    public List<Proveedor> Cargar_comboProveedores() {
        List<Proveedor> resultado = null;
        try {
            Connection cn = conecta.conexionDB();
            CallableStatement procedure = cn.prepareCall("{call SP_ComboBox_Proveedores()}");
            ResultSet rs = procedure.executeQuery();
            resultado = new ArrayList<>();
            while (rs.next()) {
                Proveedor provedorcito = new Proveedor();
                provedorcito.setRazonsocial(rs.getString(1));
                resultado.add(provedorcito);
            }
            rs.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return resultado;
    }

    //Metodo para cargar el comboBox con las categorias de productos
    @Override
    public List<Producto> Cargar_categoriaProducto() {
        List<Producto> categoria = null;
        try {
            Connection cn = conecta.conexionDB();
            CallableStatement procedure = cn.prepareCall("{call SP_ListarCategorias()}");
            ResultSet rs = procedure.executeQuery();
            categoria = new ArrayList<>();
            while (rs.next()) {
                Producto produc = new Producto();
                produc.setCategoria(rs.getString(1));
                categoria.add(produc);
            }
            rs.close();

        } catch (Exception e) {
            e.getMessage();
        }
        return categoria;
    }

    //Metodo para mostrar los trabajadores por cargos
    @Override
    public List<Trabajador> listar_trabajadores(String cargo) {
        List<Trabajador> mis_empleados = null;
        try {
            Connection cn = conecta.conexionDB();
            CallableStatement procedur = cn.prepareCall("{call SP_ListarEmpleados(?)}");
            procedur.setString(1, cargo);
            ResultSet rs = procedur.executeQuery();
            mis_empleados = new ArrayList<>();
            while (rs.next()) {
                Trabajador trabajador = new Trabajador();
                trabajador.setNombre(rs.getString(1));
                trabajador.setDni(rs.getString(2));
                trabajador.setCelular(rs.getString(3));
                trabajador.setDireccion(rs.getString(4));
                trabajador.setFecha_ingreso(LocalDate.parse(rs.getString(5)));
                trabajador.setFecha_cese(LocalDate.parse(rs.getString(6)));
                mis_empleados.add(trabajador);
            }
            rs.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return mis_empleados;
    }

    //Metodo para mostrar los proveedores por alguna categoria de producto:
    @Override
    public List<Proveedor> mostrar_proveedores(String categoria) {
        List<Proveedor> mis_proveedores = null;
        try {
            Connection cn = conecta.conexionDB();
            CallableStatement procedur = cn.prepareCall("{call SP_ListarProveedores(?)}");
            procedur.setString(1, categoria);
            ResultSet rs = procedur.executeQuery();
            mis_proveedores = new ArrayList<>();
            while (rs.next()) {
                Proveedor prove = new Proveedor();
                prove.setId(rs.getInt(1));
                prove.setRazonsocial(rs.getString(2));
                prove.setRuc(rs.getString(3));
                prove.setDireccion(rs.getString(4));
                prove.setTelefono(rs.getString(5));
                prove.setCorreo(rs.getString(6));
                mis_proveedores.add(prove);
            }
            rs.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return mis_proveedores;
    }

    @Override
    public List<Producto> Cargar_categorias_Proveedor(String proveedor) {
        List<Producto> categor_provee = null;
        try {
            Connection cn = conecta.conexionDB();
            CallableStatement procedur = cn.prepareCall("{call SP_cargarCategorias_Proveedor(?)}");
            procedur.setString(1, proveedor);
            ResultSet rs = procedur.executeQuery();
            categor_provee = new ArrayList<>();
            while (rs.next()) {
                Producto productmin = new Producto();
                productmin.setCategoria(rs.getString(1));
                categor_provee.add(productmin);
            }
            rs.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return categor_provee;

    }

    @Override
    public List<Producto> Cargar_producto_catego_proveedor(String proveedor, String categoria) {
        List<Producto> list_produ = null;
        try {
            Connection cn = conecta.conexionDB();
            CallableStatement procedur = cn.prepareCall("{call SP_CargarProductos_ProveeCategoria(?,?)}");
            procedur.setString(1, proveedor);
            procedur.setString(2, categoria);
            ResultSet rs = procedur.executeQuery();
            list_produ = new ArrayList<>();
            while (rs.next()) {
                Producto produc = new Producto();
                produc.setNombre(rs.getString(1));
                list_produ.add(produc);
            }
            rs.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return list_produ;
    }

    //metodo para Obtener un Id_compra:
    @Override
    public Integer ordencompramasuno() {
        Integer actual = 0;
        try {
            Connection cn = conecta.conexionDB();
            CallableStatement procedure = cn.prepareCall("{call SP_ordencompramaximo()}");
            ResultSet rs = procedure.executeQuery();
            if (rs.next()) {
                actual = rs.getInt(1);
            } else {
                actual = 0;
            }

        } catch (Exception e) {
            e.getMessage();
        }

        return actual + 1;
    }
    
    //Metodo para ver los estados de las ordenes de compras:
    @Override
    public  List<ComprasTiendaProveedor> ver_estado_orden_compra(String estado){
        List<ComprasTiendaProveedor>mis_ordenes=null;
        try{
            Connection cn=conecta.conexionDB();
            CallableStatement procedur=cn.prepareCall("{call SP_VerEstadoCompras(?)}");
            procedur.setString(1,estado);
            ResultSet rs=procedur.executeQuery();
            mis_ordenes=new ArrayList<>();
            while(rs.next()){
                ComprasTiendaProveedor compr=new ComprasTiendaProveedor();
                compr.setId(rs.getInt(1));
                compr.setProveedor(rs.getString(2));
                compr.setFecha_compra(LocalDate.parse(rs.getString(3)));
                compr.setFecha_ingresar(rs.getString(4)); 
                mis_ordenes.add(compr);
            }
            rs.close();
            
        }catch(Exception e){
            e.getMessage();
        }
      return mis_ordenes;             
    }

}
