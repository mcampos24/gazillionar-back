package com.proyecto.gazillionare_back.clases;

import java.util.ArrayList;
import java.util.List;

public class Portafolio {

    private final List<Inversion> inversiones = new ArrayList<>();

    public void agregar(Inversion inv) {
        if (inv == null)
            throw new IllegalArgumentException("La inversión no puede ser null");
        inversiones.add(inv);
    }


    public boolean eliminarPorNombre(String nombre) {
        if (nombre == null) {
            return false;
        }
        return inversiones.removeIf(inv -> inv.getNombre().equalsIgnoreCase(nombre));
    }

    public Inversion buscarPorNombre(String nombre) {
        if (nombre == null) {
            return null;
        }
        for (Inversion inv : inversiones) {
            if (nombre.equalsIgnoreCase(inv.getNombre())) {
                return inv;
            }
        }
        return null;
    }

    public java.util.List<Inversion> obtenerInversionesPorNombres(java.util.List<String> nombres) {
        java.util.List<Inversion> resultado = new java.util.ArrayList<>();

        if (nombres == null) {
            return resultado;
        }

        for (String nombre : nombres) {
            Inversion inv = buscarPorNombre(nombre);
            if (inv != null) {
                resultado.add(inv);
            }
        }
        return resultado;
    }
    public void limpiar() {
        inversiones.clear();
    }

    public double calcularTotalInvertido() {
        double total = 0;
        for (Inversion inv : inversiones) {
            total += inv.getMonto();
        }
        return total;
    }

    public double calcularValorFuturoTotal() {
        double total = 0;
        for (Inversion inv : inversiones) {
            total += inv.calcularValorFuturo();
        }
        return total;
    }

    public void mostrarTodo() {
        System.out.println("PORTAFOLIO COMPLETO");

        for (Inversion inv : inversiones) {
            inv.mostrarDetalles();
            System.out.println();
        }

        System.out.println("TOTAL INVERTIDO: $" + calcularTotalInvertido());
        System.out.println("VALOR FUTURO TOTAL: $" + calcularValorFuturoTotal());
    }

    public boolean estaVacio() {
        return inversiones.isEmpty();
    }

    public List<Inversion> getInversiones() {
        return inversiones;
    }
    @Override
    public String toString() {
        return "Portafolio con " + inversiones.size() + " inversiones.";
    }


}