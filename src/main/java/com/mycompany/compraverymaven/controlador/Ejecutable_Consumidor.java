package com.mycompany.compraverymaven.controlador;

import com.mycompany.compraverymaven.vista.*;
import com.mycompany.compraverymaven.dao.*;

public class Ejecutable_Consumidor {

    public static void main(String[] args) {
        DaoConsumidor daoconsumidor = new ConsumidorImp();
        DaoTrabajador daotrabajador = new TrabajadorImp();
        Consumidor_Menu consumidor_menu = new Consumidor_Menu();
        Consumidor_Login consumidor_login = new Consumidor_Login();
        
        ControladorConsumidor cc=new ControladorConsumidor(daoconsumidor, daotrabajador, consumidor_menu, consumidor_login);
        cc.InitController();
        
    }

}
