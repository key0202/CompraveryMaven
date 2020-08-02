package com.mycompany.compraverymaven.controlador;
import com.mycompany.compraverymaven.vista.*;
import com.mycompany.compraverymaven.dao.*;

public class ControladorConsumidor {
    
    private final DaoConsumidor daoconsumidor;
    private final DaoTrabajador daotrabajador;
    private final Consumidor_Menu consumidor_menu;
    private final Consumidor_Login consumidor_login; 
    
    private final Consumidor_BusquedaProducto consumidor_busquedaproducto = new Consumidor_BusquedaProducto();
    private final Consumidor_DetallePedidos consumidor_detallepedidos = new Consumidor_DetallePedidos();
    private final Consumidor_DetalleProducto consumidor_detalleproducto = new Consumidor_DetalleProducto();
    private final Consumidor_HistorialPedidos consumidor_historialpedidos = new Consumidor_HistorialPedidos();
    private final Consumidor_Perfil consumidor_perfil = new Consumidor_Perfil();

    public ControladorConsumidor(DaoConsumidor daoconsumidor, DaoTrabajador daotrabajador, Consumidor_Menu consumidor_menu, Consumidor_Login consumidor_login) {
        this.daoconsumidor = daoconsumidor;
        this.daotrabajador = daotrabajador;
        this.consumidor_menu = consumidor_menu;
        this.consumidor_login = consumidor_login;
        InitView();
    }
    
    private void InitView() {
        consumidor_login.setVisible(true);
    }

    public void InitController() {
        
    
    }
}
