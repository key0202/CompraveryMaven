package com.mycompany.compraverymaven.dto;

import java.time.LocalDate;

public class ComprasTiendaProveedor {
    private Integer id;
    private Proveedor proveedor;
    private LocalDate fecha_compra;
    private Double importe;
    private String estado;

    public ComprasTiendaProveedor(Integer id, Proveedor proveedor, LocalDate fecha_compra, Double importe, String estado) {
        this.id = id;
        this.proveedor = proveedor;
        this.fecha_compra = fecha_compra;
        this.importe = importe;
        this.estado = estado;
    }

    public ComprasTiendaProveedor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public LocalDate getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(LocalDate fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
