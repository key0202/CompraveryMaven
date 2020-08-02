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
    private final Admin_Menu_Proveedores_Compras admin_menu_proveedorescompras = new Admin_Menu_Proveedores_Compras();
    private final Admin_Menu_Ventas admin_menu_ventas = new Admin_Menu_Ventas();

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
    
    
    
    }
    
    

}
