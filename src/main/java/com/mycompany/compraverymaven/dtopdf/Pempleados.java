package com.mycompany.compraverymaven.dtopdf;

public class Pempleados {
    
    private String nombre;
    private String dni;
    private String celular;
    private String direccion;
    private String fingreso;
    private String fcese;

    public Pempleados(String nombre, String dni, String celular, String direccion, String fingreso, String fcese) {
        this.nombre = nombre;
        this.dni = dni;
        this.celular = celular;
        this.direccion = direccion;
        this.fingreso = fingreso;
        this.fcese = fcese;
    }

    public String getFcese() {
        return fcese;
    }

    public void setFcese(String fcese) {
        this.fcese = fcese;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFingreso() {
        return fingreso;
    }

    public void setFingreso(String fingreso) {
        this.fingreso = fingreso;
    }
    
    
}
