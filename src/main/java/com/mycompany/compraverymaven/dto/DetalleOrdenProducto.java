package com.mycompany.compraverymaven.dto;

public class DetalleOrdenProducto {

    private Integer id;
    private Integer idcompratiendaconsumidor;
    private Producto producto;
    private Integer cantidad;
    private Double preciocompra;

    public DetalleOrdenProducto() {
    }

    public DetalleOrdenProducto(Integer id, Integer idcompratiendaconsumidor, Producto producto, Integer cantidad, Double preciocompra) {
        this.id = id;
        this.idcompratiendaconsumidor = idcompratiendaconsumidor;
        this.producto = producto;
        this.cantidad = cantidad;
        this.preciocompra = preciocompra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdcompratiendaconsumidor() {
        return idcompratiendaconsumidor;
    }

    public void setIdcompratiendaconsumidor(Integer idcompratiendaconsumidor) {
        this.idcompratiendaconsumidor = idcompratiendaconsumidor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(Double preciocompra) {
        this.preciocompra = preciocompra;
    }

}
