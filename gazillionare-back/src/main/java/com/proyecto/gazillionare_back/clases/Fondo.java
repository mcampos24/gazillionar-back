package com.proyecto.gazillionare_back.clases;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Fondo extends Inversion {

    private String tipoFondo;
    private double rendimientoAnual;

    @JsonCreator
    public Fondo(
            @JsonProperty("nombre") String nombre,
            @JsonProperty("monto") double monto,
            @JsonProperty("tipoFondo") String tipoFondo,
            @JsonProperty("rendimientoAnual") double rendimientoAnual
    ) {
        super(nombre, monto);

        if (tipoFondo == null || tipoFondo.isBlank()) {
            throw new IllegalArgumentException("El tipo de fondo no puede estar vacío");
        }
        if (rendimientoAnual < 0) {
            throw new IllegalArgumentException("El rendimiento no puede ser negativo");
        }

        this.tipoFondo = tipoFondo;
        this.rendimientoAnual = rendimientoAnual;
    }

    @Override
    public String getTipo() {
        return "FONDO";
    }

    public String getTipoFondo() {
        return tipoFondo;
    }

    public double getRendimientoAnual() {
        return rendimientoAnual;
    }

    @Override
    public double calcularValorFuturo() {
        return calcularValorFuturo(1);
    }

    public double calcularValorFuturo(int anios) {
        if (anios < 1) {
            throw new IllegalArgumentException("Años inválidos");
        }
        return getMonto() * Math.pow(1 + rendimientoAnual / 100.0, anios);
    }

    @Override
    public void mostrarDetalles() {
        printHeader();
        System.out.println("  Tipo de fondo: " + tipoFondo);
        System.out.println("  Rendimiento anual estimado: " + rendimientoAnual + "%");
        System.out.println("  Valor futuro estimado (1 año): $" + calcularValorFuturo());
    }
}
