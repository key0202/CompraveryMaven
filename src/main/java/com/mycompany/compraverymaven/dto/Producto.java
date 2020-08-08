package com.mycompany.compraverymaven.dto;


public class Producto {

    private Integer id;
    private String nombre;
    private String descripcion;
    private byte[] imagen;
    private String categoria;


    private byte[] foto;

    private String proveedor;

    
    //ATRIBUTOS PARA EL MANEJO DE PRECIO 
    private double precio;
    private double precioOferta;
    private int id_pi;
    private int cantidad;

    public Producto() {
    }

    public Producto(Integer id, String nombre, String descripcion, byte[] imagen, String categoria, String proveedor) {
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

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
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
    public int getId_pi() {
        return id_pi;
    }
    public void setId_pi(int id_pi) {
        this.id_pi = id_pi;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen + ", categoria=" + categoria + ", proveedor=" + proveedor + '}';
    }
  

    
}
