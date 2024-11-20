package ec.edu.uce.dominio;

public class Item {
    private String nombre;
    private String codigo;
    private String estado;
    private int cantidad;

    // Constructor
    public Item(String nombre, String codigo, String estado, int cantidad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.estado = estado;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Item [nombre=" + nombre + ", codigo=" + codigo + ", estado=" + estado + ", cantidad=" + cantidad + "]";
    }
}

