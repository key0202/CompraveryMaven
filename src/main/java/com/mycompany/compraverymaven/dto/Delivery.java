package com.mycompany.compraverymaven.dto;

public class Delivery {

    private Integer id;
    private Trabajador trabajador;
    private OrdenCompraConsumidor ordencompraconsumidor;

    public Delivery(Integer id, Trabajador trabajador, OrdenCompraConsumidor ordencompraconsumidor) {
        this.id = id;
        this.trabajador = trabajador;
        this.ordencompraconsumidor = ordencompraconsumidor;
    }

    public Delivery() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public OrdenCompraConsumidor getOrdencompraconsumidor() {
        return ordencompraconsumidor;
    }

    public void setOrdencompraconsumidor(OrdenCompraConsumidor ordencompraconsumidor) {
        this.ordencompraconsumidor = ordencompraconsumidor;
    }

}
