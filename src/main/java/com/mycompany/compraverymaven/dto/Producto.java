package com.mycompany.compraverymaven.dto;

import java.sql.Blob;

public class Producto {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Blob imagen;
    private String categoria;
    private Proveedor proveedor;
    private byte[] foto;
    
    //ATRIBUTOS PARA EL MANEJO DE PRECIO 
    private double precio;
    private double precioOferta;
    private double id_pi;

    public Producto() {
    }

    public Producto(Integer id, String nombre, String descripcion, Blob imagen, String categoria, Proveedor proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.categoria = categoria;
        this.proveedor = proveedor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
    
    //getter y setter aparte

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public double getPrecioOferta() {
        return precioOferta;
    }
    public void setPrecioOferta(double precioOferta) {
        this.precioOferta = precioOferta;
    }
    public double getId_pi() {
        return id_pi;
    }
    public void setId_pi(double id_pi) {
        this.id_pi = id_pi;
    }
    
    
    
}
