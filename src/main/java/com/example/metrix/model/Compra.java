package com.example.metrix.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompra;

    @NotNull(message = "EL MONTO NO PUEDE SER NULO")
    private double monto;

    @NotNull(message = "EL ID FUNCION NO PUEDE SER NULO")
    @ManyToOne
    private Funcion funcion;

    @NotNull
    @ManyToOne
    private Boleto boleto;

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    @NotNull(message = "EL MONTO NO PUEDE SER NULO")
    public double getMonto() {
        return monto;
    }

    public void setMonto(@NotNull(message = "EL MONTO NO PUEDE SER NULO") double monto) {
        this.monto = monto;
    }

    public @NotNull(message = "EL ID FUNCION NO PUEDE SER NULO") Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(@NotNull(message = "EL ID FUNCION NO PUEDE SER NULO") Funcion funcion) {
        this.funcion = funcion;
    }

    public @NotNull Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(@NotNull Boleto boleto) {
        this.boleto = boleto;
    }
}
