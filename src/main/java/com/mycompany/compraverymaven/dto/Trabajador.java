package com.mycompany.compraverymaven.dto;

import java.time.LocalDate;

public class Trabajador extends Persona {

    private String cargo;
    private LocalDate fecha_ingreso;
    private LocalDate fecha_cese;
    private Tienda tienda;

    public Trabajador(String cargo, LocalDate fecha_ingreso, LocalDate fecha_cese, Tienda tienda) {
        this.cargo = cargo;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_cese = fecha_cese;
        this.tienda = tienda;
    }

    public Trabajador() {
    }

    public Trabajador(String cargo, LocalDate fecha_ingreso, LocalDate fecha_cese, Tienda tienda, Integer id, String nombre, String direccion, String dni, String usuario, String celular) {
        super(id, nombre, direccion, dni, usuario, celular);
        this.cargo = cargo;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_cese = fecha_cese;
        this.tienda = tienda;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(LocalDate fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public LocalDate getFecha_cese() {
        return fecha_cese;
    }

    public void setFecha_cese(LocalDate fecha_cese) {
        this.fecha_cese = fecha_cese;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
  public String getTrabajador() {
        StringBuilder informacion = new StringBuilder();
        super.getPersona();
        informacion.append("Persona:").append(super.getPersona()).
                append("cargo: ").append(cargo)
                .append("\nfechaI: ").append(fecha_ingreso)
                .append("\nfechaF: ").append(fecha_cese);                       
        return informacion.toString();
    }
    
 
}
