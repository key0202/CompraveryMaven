package com.mycompany.compraverymaven.controlador;
import com.mycompany.compraverymaven.vista.*;
import com.mycompany.compraverymaven.dao.*;

public class ControladorAlmacenero {

    private final DaoConsumidor daoconsumidor;
    private final DaoTrabajador daotrabajador;
    private final Almacenero_Menu almacenero_menu;
    private final Almacenero_Login almacenero_login;

    private final Almacenero_Menu_Inventario almacenero_menu_inventario = new Almacenero_Menu_Inventario();
    private final Almacenero_Menu_Perfil almacenero_menu_perfil = new Almacenero_Menu_Perfil();

    public ControladorAlmacenero(DaoConsumidor daoconsumidor, DaoTrabajador daotrabajador, Almacenero_Menu almacenero_menu, Almacenero_Login almacenero_login) {
        this.daoconsumidor = daoconsumidor;
        this.daotrabajador = daotrabajador;
        this.almacenero_menu = almacenero_menu;
        this.almacenero_login = almacenero_login;
        InitView();
    }

    private void InitView() {
        almacenero_login.setVisible(true);
    }

    public void InitController() {       
        
        
        
    }

}
