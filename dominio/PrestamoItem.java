package ec.edu.uce.dominio;

import java.util.Date;

public class PrestamoItem {
    private String codigoItem;
    private String codigoUsuario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private String estado;  // "Activo", "Devuelto", "Retrasado"

    // Constructor
    public PrestamoItem(String codigoItem, String codigoUsuario, Date fechaPrestamo, Date fechaDevolucion, String estado) {
        this.codigoItem = codigoItem;
        this.codigoUsuario = codigoUsuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
    }

    // Getters y setters
    public String getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(String codigoItem) {
        this.codigoItem = codigoItem;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Código Ítem: " + codigoItem + ", Usuario: " + codigoUsuario + ", Fecha Préstamo: " + fechaPrestamo + ", Fecha Devolución: " + fechaDevolucion + ", Estado: " + estado;
    }
}
