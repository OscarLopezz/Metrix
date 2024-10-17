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

}
