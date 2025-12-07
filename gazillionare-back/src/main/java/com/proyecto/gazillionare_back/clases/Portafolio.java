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

    public boolean eliminar(Inversion inv) {
        if (inv == null)
            throw new IllegalArgumentException("La inversión no puede ser null");
        return inversiones.remove(inv);
    }

    public boolean eliminarPorNombre(String nombre) {
        return inversiones.removeIf(inv -> inv.getNombre().equalsIgnoreCase(nombre));
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

    @Override
    public String toString() {
        return "Portafolio con " + inversiones.size() + " inversiones.";
    }

}