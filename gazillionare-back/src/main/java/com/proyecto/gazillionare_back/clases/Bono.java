package com.proyecto.gazillionare_back.clases;

public class Bono extends Inversion {

    private double retornoAnual;
    private int aniosRestantes;

    public Bono() {
        super("default", 0);
    }
    public Bono(String nombre, double monto, double retornoAnual, int aniosRestantes) {
        super(nombre, monto);

        if (retornoAnual <= 0)
            throw new IllegalArgumentException("Retorno anual inválido");

        if (aniosRestantes <= 0)
            throw new IllegalArgumentException("Años inválidos");

        this.retornoAnual = retornoAnual;
        this.aniosRestantes = aniosRestantes;
    }

    @Override
    public String getTipo() {
        return "BONO";
    }

    public double getRetornoAnual() { return retornoAnual; }
    public void setRetornoAnual(double retornoAnual) { this.retornoAnual = retornoAnual; }
    public int getaniosRestantes() { return aniosRestantes; }
    public void setAniosRestantes(int aniosRestantes) { this.aniosRestantes = aniosRestantes; }


    @Override
    public double calcularValorFuturo() {
        return calcularValorFuturo(aniosRestantes);
    }

    public double calcularValorFuturo(int años) {
        if (años < 1) throw new IllegalArgumentException("Años inválidos");
        return monto * Math.pow(1 + retornoAnual / 100.0, años);
    }

    @Override
    public void mostrarDetalles() {
        printHeader();
        System.out.println("  Monto invertido: $" + monto);
        System.out.println("  Retorno anual: " + retornoAnual + "%");
        System.out.println("  Años restantes: " + aniosRestantes);
        System.out.println("  Valor futuro estimado: $" + calcularValorFuturo());
    }
}