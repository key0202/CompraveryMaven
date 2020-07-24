package com.mycompany.compraverymaven.dto;

import java.time.LocalDate;

public class ProductoInventario extends Producto{

    private Integer id;
    private Integer stock;
    private Double precioventa;
    private String lote;
    private LocalDate fecha_ingreso;
    private LocalDate fecha_vencimiento;
    private Oferta oferta;
    private DetalleOrdenProducto detalleordenproducto;

    public ProductoInventario(Integer id, Integer stock, Double precioventa, String lote, LocalDate fecha_ingreso, LocalDate fecha_vencimiento, Oferta oferta, DetalleOrdenProducto detalleordenproducto) {
        this.id = id;
        this.stock = stock;
        this.precioventa = precioventa;
        this.lote = lote;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_vencimiento = fecha_vencimiento;
        this.oferta = oferta;
        this.detalleordenproducto = detalleordenproducto;
    }

    public ProductoInventario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(Double precioventa) {
        this.precioventa = precioventa;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public LocalDate getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(LocalDate fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public LocalDate getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(LocalDate fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    public DetalleOrdenProducto getDetalleordenproducto() {
        return detalleordenproducto;
    }

    public void setDetalleordenproducto(DetalleOrdenProducto detalleordenproducto) {
        this.detalleordenproducto = detalleordenproducto;
    }

}
