package com.proyecto.gazillionare_back.clases;

import java.util.List;

public class ComparacionInversiones {

    private List<Inversion> inversiones;
    private double totalMonto;
    private double totalValorFuturo;
    private double promedioRendimiento;

    public ComparacionInversiones(List<Inversion> inversiones) {
        this.inversiones = inversiones;

        // Calcular total invertido y valor futuro
        this.totalMonto = 0;
        this.totalValorFuturo = 0;
        double sumaRendimientos = 0;
        int contadorRendimientos = 0;

        for (Inversion inv : inversiones) {
            this.totalMonto += inv.getMonto();
            this.totalValorFuturo += inv.getValorFuturo();

            // Solo Bono y Fondo tienen rendimiento
            if (inv instanceof Bono) {
                Bono b = (Bono) inv;
                sumaRendimientos += b.getRetornoAnual();
                contadorRendimientos++;
            } else if (inv instanceof Fondo) {
                Fondo f = (Fondo) inv;
                sumaRendimientos += f.getRendimientoAnual();
                contadorRendimientos++;
            }
            // Accion: no aporta al promedio (0% implícito)
        }

        if (contadorRendimientos > 0) {
            this.promedioRendimiento = sumaRendimientos / contadorRendimientos;
        } else {
            this.promedioRendimiento = 0.0;
        }
    }

    // Getters
    public List<Inversion> getInversiones() {
        return inversiones;
    }

    public double getTotalMonto() {
        return totalMonto;
    }

    public double getTotalValorFuturo() {
        return totalValorFuturo;
    }

    public double getPromedioRendimiento() {
        return promedioRendimiento;
    }
}
