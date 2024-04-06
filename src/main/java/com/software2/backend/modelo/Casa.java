package com.software2.backend.modelo;

public class Casa {
    private Long id;
    private String barrio;
    private String direccion;
    private double precio;

    public Casa() {
    }

    public Casa(Long id, String barrio, String direccion, double precio) {
        this.id = id;
        this.barrio = barrio;
        this.direccion = direccion;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
