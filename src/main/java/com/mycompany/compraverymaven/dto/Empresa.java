package com.mycompany.compraverymaven.dto;

public class Empresa {
    private Integer id;
    private String razonsocial;
    private String ruc;
    private String direccion;
    private String telefono;
    private String correo;
    private Trabajador empleado;

    public Empresa() {
    }

    public Empresa(Integer id, String razonsocial, String ruc, String direccion, String telefono, String correo, Trabajador empleado) {
        this.id = id;
        this.razonsocial = razonsocial;
        this.ruc = ruc;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.empleado = empleado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Trabajador getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Trabajador empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return  razonsocial;
    }
    
    
    
    
}
