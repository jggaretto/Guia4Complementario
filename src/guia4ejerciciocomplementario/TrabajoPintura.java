
package guia4ejerciciocomplementario;

import java.time.LocalDate;

class TrabajoPintura extends Servicio {
    private String edificacion;
    private double superficie;
    private double precioPintura;

    public TrabajoPintura(String trabajador, LocalDate fechaInicio, String cliente, String edificacion, double superficie, double precioPintura) {
        super(trabajador, fechaInicio, cliente);
        this.edificacion = edificacion;
        this.superficie = superficie;
        this.precioPintura = precioPintura;
    }

    public String getEdificacion() {
        return edificacion;
    }

    public void setEdificacion(String edificacion) {
        this.edificacion = edificacion;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public double getPrecioPintura() {
        return precioPintura;
    }

    public void setPrecioPintura(double precioPintura) {
        this.precioPintura = precioPintura;
    }

    @Override
    public double costeMaterial() {
        return (superficie / 7.8) * precioPintura;
    }

    @Override
    public double costeManoObra() {
        return (superficie / 10) * 9.5;
    }

    @Override
    public String detalleServicio() {
        double costeMaterial = costeMaterial();
        double costeManoObra = costeManoObra();
        double costeTotal = costeTotal();

        return "TRABAJO DE PINTURA\n" +
                "Cliente: " + getCliente() + "\n" +
                "Fecha de inicio: " + getFechaInicio() + "\n" +
                "Pintor: " + getTrabajador() + "\n" +
                "Coste Material: " + costeMaterial + "\n" +
                "Coste Mano Obra: " + costeManoObra + "\n" +
                "Coste Adicional:  " + (costeTotal - costeMaterial - costeManoObra) + "\n" +
                "TOTAL: " + costeTotal;
}
}