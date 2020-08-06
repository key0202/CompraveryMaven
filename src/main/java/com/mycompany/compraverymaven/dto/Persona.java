package com.mycompany.compraverymaven.dto;

public class Persona {

    private Integer id;
    private String nombre;
    private String direccion;
    private String dni;
    private String usuario;
    private String celular;

    public Persona(Integer id, String nombre, String direccion, String dni, String usuario, String celular) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.usuario = usuario;
        this.celular = celular;
    }

    public Persona() {
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
      public String getPersona() {
        StringBuilder informacion = new StringBuilder();
        informacion.append("nombre: ").append(nombre)
                .append("\ncelular: ").append(celular)
                .append("\nDni: ").append(dni)
                .append("\nDireccion: ").append(direccion);                       
        return informacion.toString();
    }

}
