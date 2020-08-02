package com.mycompany.compraverymaven.controlador;

import com.mycompany.compraverymaven.vista.*;
import com.mycompany.compraverymaven.dao.*;

public class Ejecutable_Almacenero {

    public static void main(String[] args) {
        DaoConsumidor daoconsumidor = new ConsumidorImp();
        DaoTrabajador daotrabajador = new TrabajadorImp();
        Almacenero_Menu almacenero_menu = new Almacenero_Menu();
        Almacenero_Login almacenero_login = new Almacenero_Login();

        ControladorAlmacenero ca = new ControladorAlmacenero(daoconsumidor, daotrabajador, almacenero_menu, almacenero_login);
        ca.InitController();
    }
}
