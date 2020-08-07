package com.mycompany.compraverymaven.dto;

import java.time.LocalDate;

public class ComprasTiendaProveedor {

    private Integer id;
    private String proveedor;
    private LocalDate fecha_compra;
    private Double importe;
    private String estado;
    private String fecha_ingresar;

    public ComprasTiendaProveedor(Integer id, String proveedor, LocalDate fecha_compra, Double importe, String estado, String fecha_ingresar) {
        this.id = id;
        this.proveedor = proveedor;
        this.fecha_compra = fecha_compra;
        this.importe = importe;
        this.estado = estado;
        this.fecha_ingresar=fecha_ingresar;
    }

    public ComprasTiendaProveedor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha_ingresar() {
        return fecha_ingresar;
    }

    public void setFecha_ingresar(String fecha_ingresar) {
        this.fecha_ingresar = fecha_ingresar;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
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

    @Override
    public String toString() {
        StringBuilder informacion = new StringBuilder();   
        informacion.append("ID_ordenCompra:").append(id).
                  append("\nProveedor").append(proveedor).
                append("\nFecha_compra: ").append(fecha_compra).
                append("\nProveedor").append(fecha_ingresar);
               
        return informacion.toString();
        
    }

}
