
package guia4ejerciciocomplementario;

import java.time.LocalDate;

abstract class Servicio {
    private String trabajador;
    private LocalDate fechaInicio;
    private String cliente;

    public Servicio(String trabajador, LocalDate fechaInicio, String cliente) {
        this.trabajador = trabajador;
        this.fechaInicio = fechaInicio;
        this.cliente = cliente;
    }

    public String getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(String trabajador) {
        this.trabajador = trabajador;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public abstract double costeMaterial();

    public abstract double costeManoObra();

    public double costeTotal() {
        double costeMaterial = costeMaterial();
        double costeManoObra = costeManoObra();
        double costeTotal = costeMaterial + costeManoObra;

        if (costeMaterial > 0 && costeManoObra > 0) {
            if (costeMaterial < 50) {
                costeTotal += costeTotal * 0.15; // Coste adicional del 15% para superficies menores a 50 m²
            }
        }

        return costeTotal;
    }

    public abstract String detalleServicio();
}
