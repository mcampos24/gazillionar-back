package com.proyecto.gazillionare_back.clases;

public class Fondo extends Inversion {

    private final String tipoFondo;
    private final double rendimientoAnual;

    public Fondo() { super("default",0); }
    public Fondo(String nombre, double monto, String tipoFondo, double rendimientoAnual) {
        super(nombre, monto);

        if (tipoFondo == null || tipoFondo.isBlank())
            throw new IllegalArgumentException("El tipo de fondo no puede estar vacío");

        if (rendimientoAnual < 0)
            throw new IllegalArgumentException("El rendimiento no puede ser negativo");

        this.tipo = tipoFondo;
        this.rendimientoAnual = rendimientoAnual;
    }

    @Override
    public String getTipo() {
        return "Fondo";
    }

    public double getRendimientoAnual() {
        return rendimientoAnual;
    }
    public void setRendimientoAnual(double rendimientoAnual) {
        this.rendimientoAnual = rendimientoAnual;
    }

    public double getTipoFondo() {
        return tipoFondo;
    }
    public void setTipoFondo(double TipoFondo) {
        this.TipoFondo = TipoFondo;
    }
    @Override
    public double calcularValorFuturo() {
        return calcularValorFuturo(1);
    }


    public double calcularValorFuturo(int años) {
        if (anios < 1) throw new IllegalArgumentException("Años inválidos");
        return monto * Math.pow(1 + rendimientoAnual / 100.0, anios);
    }


    @Override
    public void mostrarDetalles() {
        printHeader();
        System.out.println("  Tipo de fondo: " + tipo);
        System.out.println("  Rendimiento anual estimado: " + rendimientoAnual + "%");
        System.out.println("  Valor futuro estimado (1 año): $" + calcularValorFuturo());
    }
}
