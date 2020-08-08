package com.mycompany.compraverymaven.dto;

import java.time.LocalDate;

public class OrdenCompraConsumidor {

    private Integer id;
    private DetalleCompraConsumidor detallecompraconsumidor;
    private Consumidor consumidor;
    private LocalDate fecha_compra;
    private String estado;
    private Double importe_total;
    private String nombreconsumidor;
    private String direccion;

    public OrdenCompraConsumidor() {
    }

    public OrdenCompraConsumidor(Integer id, DetalleCompraConsumidor detallecompraconsumidor, Consumidor consumidor, LocalDate fecha_compra, String estado, Double importe_total) {
        this.id = id;
        this.detallecompraconsumidor = detallecompraconsumidor;
        this.consumidor = consumidor;
        this.fecha_compra = fecha_compra;
        this.estado = estado;
        this.importe_total = importe_total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DetalleCompraConsumidor getDetallecompraconsumidor() {
        return detallecompraconsumidor;
    }

    public void setDetallecompraconsumidor(DetalleCompraConsumidor detallecompraconsumidor) {
        this.detallecompraconsumidor = detallecompraconsumidor;
    }

    public Consumidor getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
    }

    public LocalDate getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(LocalDate fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(Double importe_total) {
        this.importe_total = importe_total;
    }

    public String getNombreconsumidor() {
        return nombreconsumidor;
    }

    public void setNombreconsumidor(String nombreconsumidor) {
        this.nombreconsumidor = nombreconsumidor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return  "\nId compra:\n " + id + 
                "\nImporte_total:\n " + importe_total + 
                "\nCliente:\n " + nombreconsumidor + 
                "\nDireccion:\n " + direccion+
                "\n---------------------";
    }
    
        public String textos() {
        return  "\nId compra:\n " + id + 
                "\nFecha:\n " + fecha_compra.toString() + 
                "\nImporte_total:\n " + importe_total + 
                "\n---------------------";
    }
    
}
