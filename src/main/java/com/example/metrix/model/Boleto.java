package com.example.metrix.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Boleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private int fila;

    @NotNull
    private int coluna;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    public int getFila() {
        return fila;
    }

    public void setFila(@NotNull int fila) {
        this.fila = fila;
    }

    @NotNull
    public int getColuna() {
        return coluna;
    }

    public void setColuna(@NotNull int coluna) {
        this.coluna = coluna;
    }
}
