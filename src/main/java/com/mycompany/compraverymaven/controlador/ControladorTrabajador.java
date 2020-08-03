package com.mycompany.compraverymaven.controlador;

import com.mycompany.compraverymaven.vista.*;
import com.mycompany.compraverymaven.dao.*;

public class ControladorTrabajador {

    private final DaoConsumidor daoconsumidor;
    private final DaoTrabajador daotrabajador;
    private final Admin_Menu admin_menu;
    private final Admin_Login admin_login;

    private final Admin_Menu_Almacen admin_menu_almacen = new Admin_Menu_Almacen();
    private final Admin_Menu_AtencionPedido admin_menu_atencionpedido = new Admin_Menu_AtencionPedido();
    private final Admin_Menu_ComprasEstado admin_menu_comprasestado = new Admin_Menu_ComprasEstado();
    private final Admin_Menu_Empleados admin_menu_empleados = new Admin_Menu_Empleados();
    private final Admin_Menu_OfertasPrecios admin_menu_ofertasprecios = new Admin_Menu_OfertasPrecios();
    private final Admin_Menu_Perfil admin_menu_perfil = new Admin_Menu_Perfil();
    private final Admin_Menu_Proveedores admin_menu_proveedores = new Admin_Menu_Proveedores();
    private final Admin_Menu_Proveedores_Compras admin_menu_proveedores_compras = new Admin_Menu_Proveedores_Compras();
    private final Admin_Menu_Ventas admin_menu_ventas = new Admin_Menu_Ventas();
    private final Admin_Anadir_Empleados admin_anadir_empleados = new Admin_Anadir_Empleados();
    private final Admin_Anadir_Productos admin_anadir_productos = new Admin_Anadir_Productos();
    private final Admin_Anadir_Proveedores admin_anadir_proveedores = new Admin_Anadir_Proveedores();

    public ControladorTrabajador(DaoConsumidor daoconsumidor, DaoTrabajador daotrabajador, Admin_Menu admin_menu, Admin_Login admin_login) {
        this.daoconsumidor = daoconsumidor;
        this.daotrabajador = daotrabajador;
        this.admin_menu = admin_menu;
        this.admin_login = admin_login;
        InitView();
    }

    private void InitView() {
        admin_login.setVisible(true);
    }

    public void InitController() {

        admin_anadir_empleados.getBtnAgregar().addActionListener(e -> anadir("empleados"));
        admin_anadir_empleados.getBtnRegresar().addActionListener(e -> regresar("empleados"));

        admin_anadir_productos.getBtnRegresar().addActionListener(e -> anadir("producto"));
        admin_anadir_productos.getBtnAgregar().addActionListener(e -> regresar("producto"));
        admin_anadir_productos.getBtnImagen().addActionListener(e -> cargarimagen());

        admin_anadir_proveedores.getBtnAgregar().addActionListener(e -> regresar("proveedores"));
        admin_anadir_proveedores.getBtnRegresar().addActionListener(e -> anadir("proveedores"));
        
        admin_login.getBtnIniciarSesion().addActionListener(e -> login());
        
        admin_menu.getBtnAlmacen().addActionListener(e -> abrir_internal("almacen"));
        admin_menu.getBtnPedidosCliente().addActionListener(e -> abrir_internal("pedidos"));
        admin_menu.getBtnCompras().addActionListener(e -> abrir_internal("compras"));
        admin_menu.getBtnEmpleados().addActionListener(e -> abrir_internal("empleados"));
        admin_menu.getBtnOfertas().addActionListener(e -> abrir_internal("ofertas"));
        admin_menu.getBtnPerfil().addActionListener(e -> abrir_internal("perfil"));
        admin_menu.getBtnProveedores().addActionListener(e -> abrir_internal("proveedores"));
        admin_menu.getBtnVentas().addActionListener(e -> abrir_internal("ventas"));
        admin_menu.getBtnProductos().addActionListener(e -> abrir_internal("productos"));
        
        admin_menu_almacen.getBtnBuscar().addActionListener(e -> buscarproducto());
        admin_menu_almacen.getBtnGenerarReporte().addActionListener(e -> reporteexcel("almacen"));
        
        admin_menu_atencionpedido.getBtnImprimir().addActionListener(e -> reportepdf("pedidos"));
        
        admin_menu_comprasestado.getBtnImprimir().addActionListener(e -> reporteexcel("comprasestado"));
        
        admin_menu_empleados.getBtnAgregarEmpleado().addActionListener(e -> abrir_frame("anadirempleado"));
        
        admin_menu_ofertasprecios.getBtnGuardar().addActionListener(e -> actualizar("producto"));
        admin_menu_ofertasprecios.getBtnGuardarOferta().addActionListener(e -> guardaroferta());
        
        admin_menu_proveedores.getBtnAgregarProovedor().addActionListener(e -> abrir_frame("anadirproveedor"));
        
        admin_menu_proveedores_compras.getBtnAgregar().addActionListener(e -> agregarproductoAtabla());
        admin_menu_proveedores_compras.getBtnComprar().addActionListener(e -> comprarproductos());
        
        admin_menu_ventas.getBtnGenerarResumen().addActionListener(e -> reporteexcel("ventas"));
        
    }

    private void anadir(String opcion) {
        //crear un nuevo registro
        switch (opcion) {
            case "empleados":

                break;
            case "producto":

                break;
            case "proveedores":

                break;
            default:
                throw new AssertionError();
        }

    }

    private void regresar(String opcion) {
        //todos los que usen este metodo van a retornar al menu principal
        switch (opcion) {
            case "empleados":

                break;
            case "producto":

                break;
            case "proveedores":

                break;
            default:
                throw new AssertionError();
        }

    }

    private void cargarimagen() {
        //asignar una imagen para el producto

    }

    private void login() {
        //logeo del administrador
        
    }

    private void abrir_internal(String opcion) {
        //cargar los internalframe segun la opcion
        switch (opcion) {
            case "almacen":
                
                break;
            case "pedidos":
                
                break;
            case "compras":
                
                break;
            case "empleados":
                
                break;
            case "ofertas":
                
                break;
            case "perfil":
                
                break;
            case "proveedores":
                
                break;
            case "ventas":
                
                break;
            case "productos":
                
                break;
            default:
                throw new AssertionError();
        }
        
    }
    
    private void abrir_frame(String opcion) {
       //carga los frame segun la opcion
        switch (opcion) {
            case "anadirempleado":
                
                break;
            case "anadirproducto":
                
                break;
            case "anadirproveedor":
                
                break;
            default:
                throw new AssertionError();
        }
       
    }

    private void buscarproducto() {
        //busca productos para tabla segun operacion, categoria, fechas inicial y final

    }

    private void reporteexcel(String opcion) {
        //genera un excel segun la tabla enviada
        switch (opcion) {
            case "almacen":
                
                break;
            case "comprasestado":
                
                break;
            case "ventas":
                
                break;
            default:
                throw new AssertionError();
        }
    }

    private void reportepdf(String opcion) {
        //genera un reporte en pdf
        switch (opcion) {
            case "pedidos":
                
                break;
            default:
                throw new AssertionError();
        }
    }

    private void actualizar(String opcion) {
        //actualizar los registros seleccionados segun las tablas
                switch (opcion) {
            case "producto":
                
                break;
            default:
                throw new AssertionError();
        }       
        
    }

    private void guardaroferta() {
        //guarda la oferta segun producto seleccionado
        
    }

    private void agregarproductoAtabla() {
        //agrega los productos seleccionados a la tabla del frame
        
    }

    private void comprarproductos() {
        //cambia estado de orden de compra y traspasa cada detalle hacia productoinventario
        
    }


}
