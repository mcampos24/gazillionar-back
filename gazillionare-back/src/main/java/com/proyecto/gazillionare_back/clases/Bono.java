package com.proyecto.gazillionare_back.clases;

class Bono extends Inversion {

    private double retornoAnual;
    private int añosRestantes;

    public Bono() {
        super("default", 0);
    }
    public Bono(String nombre, double monto, double retornoAnual, int añosRestantes) {
        super(nombre, monto);

        if (retornoAnual <= 0)
            throw new IllegalArgumentException("Retorno anual inválido");

        if (añosRestantes <= 0)
            throw new IllegalArgumentException("Años inválidos");

        this.retornoAnual = retornoAnual;
        this.añosRestantes = añosRestantes;
    }

    @Override
    public String getTipo() {
        return "Bono";
    }

    public double getRetornoAnual() { return retornoAnual; }
    public void setRetornoAnual(double retornoAnual) { this.retornoAnual = retornoAnual; }
    public int getAñosRestantes() { return añosRestantes; }
    public void setAñosRestantes(int añosRestantes) { this.añosRestantes = aniosRestantes; }
    }

    @Override
    public double calcularValorFuturo() {
        return calcularValorFuturo(añosRestantes);
    }

    public double calcularValorFuturo(int anios) {
        if (anios < 1) throw new IllegalArgumentException("Años inválidos");
        return monto * Math.pow(1 + retornoAnual / 100.0, anios);
    }

    @Override
    public void mostrarDetalles() {
        printHeader();
        System.out.println("  Monto invertido: $" + monto);
        System.out.println("  Retorno anual: " + retornoAnual + "%");
        System.out.println("  Años restantes: " + añosRestantes);
        System.out.println("  Valor futuro estimado: $" + calcularValorFuturo());
    }
}