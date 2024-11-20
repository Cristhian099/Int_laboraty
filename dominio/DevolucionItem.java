package ec.edu.uce.dominio;

import java.util.Date;

public class DevolucionItem {
    private String codigoPrestamo;
    private Date fechaDevolucion;
    private String estadoItem;  // "dañado" o "en buen estado"
    private double montoCobro;  // Cobro por daño si aplica

    // Constructor
    public DevolucionItem(String codigoPrestamo, Date fechaDevolucion, String estadoItem, double montoCobro) {
        this.codigoPrestamo = codigoPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estadoItem = estadoItem;
        this.montoCobro = montoCobro;
    }

    // Getters y setters
    public String getCodigoPrestamo() {
        return codigoPrestamo;
    }

    public void setCodigoPrestamo(String codigoPrestamo) {
        this.codigoPrestamo = codigoPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getEstadoItem() {
        return estadoItem;
    }

    public void setEstadoItem(String estadoItem) {
        this.estadoItem = estadoItem;
    }

    public double getMontoCobro() {
        return montoCobro;
    }

    public void setMontoCobro(double montoCobro) {
        this.montoCobro = montoCobro;
    }

    @Override
    public String toString() {
        return "Código Préstamo: " + codigoPrestamo + ", Fecha Devolución: " + fechaDevolucion + ", Estado del Ítem: " + estadoItem + ", Monto Cobro: " + montoCobro;
    }
}
