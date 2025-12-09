package com.proyecto.gazillionare_back.clases;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Bono extends Inversion {

    private double retornoAnual;
    private int aniosRestantes;

    @JsonCreator
    public Bono(
            @JsonProperty("nombre") String nombre,
            @JsonProperty("monto") double monto,
            @JsonProperty("retornoAnual") double retornoAnual,
            @JsonProperty("aniosRestantes") int aniosRestantes
    ) {
        super(nombre, monto);

        if (retornoAnual <= 0) {
            throw new IllegalArgumentException("Retorno anual inválido");
        }
        if (aniosRestantes <= 0) {
            throw new IllegalArgumentException("Años inválidos");
        }

        this.retornoAnual = retornoAnual;
        this.aniosRestantes = aniosRestantes;
    }

    @Override
    public String getTipo() {
        return "BONO";
    }

    public double getRetornoAnual() {
        return retornoAnual;
    }

    public int getAniosRestantes() {
        return aniosRestantes;
    }

    @Override
    public double calcularValorFuturo() {
        return calcularValorFuturo(aniosRestantes);
    }

    public double calcularValorFuturo(int anios) {
        if (anios < 1) {
            throw new IllegalArgumentException("Años inválidos");
        }
        return getMonto() * Math.pow(1 + retornoAnual / 100.0, anios);
    }

    @Override
    public void mostrarDetalles() {
        printHeader();
        System.out.println("  Monto invertido: $" + getMonto());
        System.out.println("  Retorno anual: " + retornoAnual + "%");
        System.out.println("  Años restantes: " + aniosRestantes);
        System.out.println("  Valor futuro estimado: $" + calcularValorFuturo());
    }
}