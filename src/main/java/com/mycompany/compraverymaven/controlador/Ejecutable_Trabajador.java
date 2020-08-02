package com.mycompany.compraverymaven.controlador;

import com.mycompany.compraverymaven.vista.*;
import com.mycompany.compraverymaven.dao.*;

public class Ejecutable_Trabajador {

    public static void main(String[] args) {

        DaoConsumidor daoconsumidor = new ConsumidorImp();
        DaoTrabajador daotrabajador = new TrabajadorImp();
        Admin_Menu admin_menu = new Admin_Menu();
        Admin_Login admin_login = new Admin_Login();

        ControladorTrabajador ct = new ControladorTrabajador(daoconsumidor, daotrabajador, admin_menu, admin_login);
        ct.InitController();
    }

}
