package ec.edu.uce.dominio;

import java.util.Date;

public class GarantiaPrestamo {
    private String codigoPrestamo;
    private double montoGarantia;
    private Date fechaRegistro;
    private String estado;  // "activa", "eliminada"

    // Constructor
    public GarantiaPrestamo(String codigoPrestamo, double montoGarantia, Date fechaRegistro, String estado) {
        this.codigoPrestamo = codigoPrestamo;
        this.montoGarantia = montoGarantia;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

    // Getters y setters
    public String getCodigoPrestamo() {
        return codigoPrestamo;
    }

    public void setCodigoPrestamo(String codigoPrestamo) {
        this.codigoPrestamo = codigoPrestamo;
    }

    public double getMontoGarantia() {
        return montoGarantia;
    }

    public void setMontoGarantia(double montoGarantia) {
        this.montoGarantia = montoGarantia;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Código Préstamo: " + codigoPrestamo + ", Monto Garantía: " + montoGarantia + ", Fecha Registro: " + fechaRegistro + ", Estado: " + estado;
    }
}
