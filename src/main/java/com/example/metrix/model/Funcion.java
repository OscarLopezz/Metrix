package com.example.metrix.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class Funcion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "counstom_id")
    @NotNull(message = "El nombre no puede ser nulo")
    private Pelicula pelicula;

    @NotNull(message = "La fecha no puede ser nula")
    private Date fecha;
    @NotNull
    private int hora;

    @NotNull
    @Column(name = "precio_boleto" )
    private double precioBoleto;

    @NotNull
    private String estado;

    public Funcion(Integer id, Pelicula pelicula, Date fecha, int hora, double precioBoleto, String estado) {
        this.id = id;
        this.pelicula = pelicula;
        this.fecha = fecha;
        this.hora = hora;
        this.precioBoleto = precioBoleto;
        this.estado = estado;
    }

    public Funcion() {

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public double getPrecioBoleto() {
        return precioBoleto;
    }

    public void setPrecioBoleto(double precioBoleto) {
        this.precioBoleto = precioBoleto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
