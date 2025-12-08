package com.proyecto.gazillionare_back.clases;

public class Accion extends Inversion {

    private int cantidad;
    private double precioActual;
    private double eps;
    private double bvps;

    public Accion(String nombre, int cantidad, double precioActual, double eps, double bvps) {
        super(nombre, cantidad * precioActual);

        if (cantidad <= 0) throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        if (precioActual <= 0) throw new IllegalArgumentException("El precio debe ser mayor a 0");
        if (eps <= 0) throw new IllegalArgumentException("El EPS debe ser positivo");
        if (bvps <= 0) throw new IllegalArgumentException("El BVPS debe ser positivo");

        this.cantidad = cantidad;
        this.precioActual = precioActual;
        this.eps = eps;
        this.bvps = bvps;
    }

    @Override
    public String getTipo() {
        return "Acción";
    }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public double getPrecioActual() { return precioActual; }
    public void setPrecioActual(double precioActual) { this.precioActual = precioActual; }
    public double getEPS() { return eps; }
    public void setEPS(double eps) { this.eps = eps; }
    public double getBVPS() { return bvps; }
    public void setBVPS(double bvps) { this.bvps = bvps; }

    @Override
    public double calcularValorFuturo() {
        return cantidad * precioActual;
    }

    public double calcularPERatio() {
        return precioActual / eps;
    }

    public double calcularPBRatio() {
        return precioActual / bvps;
    }

    @Override
    public void mostrarDetalles() {
        printHeader();
        System.out.println("  Cantidad: " + cantidad);
        System.out.printf("  Precio actual por acción: $%.2f%n", precioActual);
        System.out.printf("  Valor de mercado: $%.2f%n", calcularValorFuturo());
        System.out.printf("  EPS: %.2f, BVPS: %.2f%n", eps, bvps);
        System.out.printf("  P/E: %.2f, P/B: %.2f%n", calcularPERatio(), calcularPBRatio());
    }
}
