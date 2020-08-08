package com.mycompany.compraverymaven.dtopdf;

public class Pordencompra {
    
private String norden;
private String proveedor;
private String fcompra;
private String ruc;
private String producto;
private String cantidad;
private String preciocu ;
private String importe;
private String total;

    public Pordencompra(String norden, String proveedor, String fcompra, String ruc, String producto, String cantidad, String preciocu, String importe, String total) {
        this.norden = norden;
        this.proveedor = proveedor;
        this.fcompra = fcompra;
        this.ruc = ruc;
        this.producto = producto;
        this.cantidad = cantidad;
        this.preciocu = preciocu;
        this.importe = importe;
        this.total = total;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getNorden() {
        return norden;
    }

    public void setNorden(String norden) {
        this.norden = norden;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getFcompra() {
        return fcompra;
    }

    public void setFcompra(String fcompra) {
        this.fcompra = fcompra;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }


    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPreciocu() {
        return preciocu;
    }

    public void setPreciocu(String preciocu) {
        this.preciocu = preciocu;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }
    
    
}
