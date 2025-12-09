package com.proyecto.gazillionare_back.clases;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Bono.class, name = "BONO"),
        @JsonSubTypes.Type(value = Fondo.class, name = "FONDO"),
        @JsonSubTypes.Type(value = Accion.class, name = "ACCION")
})
public abstract class Inversion {

    protected String nombre;
    protected double monto;

    public Inversion() {}
    public Inversion(String nombre, double monto) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre no puede estar vacío");

        if (monto <= 0)
            throw new IllegalArgumentException("El monto debe ser mayor a 0");

        this.nombre = nombre;
        this.monto = monto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getMonto() {
        return monto;
    }

    public double getValorFuturo() {
        return calcularValorFuturo();
    }

    public String getResumen() {
        return getTipo() + " - " + getNombre() + " ($" + getMonto() + ")";
    }
    public abstract String getTipo();

    public abstract double calcularValorFuturo();

    public abstract void mostrarDetalles();

    protected void printHeader() {
        System.out.println(getTipo().toUpperCase() + " → " + nombre);
    }

    @Override
    public String toString() {
        return getTipo() + ": " + nombre + " (Monto: $" + monto + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Inversion that = (Inversion) obj;
        return nombre.equals(that.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}

