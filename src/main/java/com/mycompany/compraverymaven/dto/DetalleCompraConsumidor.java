package com.mycompany.compraverymaven.dto;

public class DetalleCompraConsumidor {

    private Integer id;
    private Integer id_productoinventario;
    private Integer cantidad;
    private ProductoInventario productoinventario;
    private Double subtotal;

    public DetalleCompraConsumidor(Integer id, Integer cantidad, ProductoInventario productoinventario, Double subtotal) {
        this.id = id;
        this.cantidad = cantidad;
        this.productoinventario = productoinventario;
        this.subtotal = subtotal;
    }

    public DetalleCompraConsumidor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoInventario getProductoinventario() {
        return productoinventario;
    }

    public void setProductoinventario(ProductoInventario productoinventario) {
        this.productoinventario = productoinventario;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getId_productoinventario() {
        return id_productoinventario;
    }

    public void setId_productoinventario(Integer id_productoinventario) {
        this.id_productoinventario = id_productoinventario;
    }
    
    
    
}
