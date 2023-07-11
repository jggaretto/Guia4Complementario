
package guia4ejerciciocomplementario;

import java.time.LocalDate;

class RevisionAlarma extends Servicio {
private int numeroAlarmas;
public RevisionAlarma(LocalDate fechaRevision, String cliente, int numeroAlarmas) {
    super("Revisor Especialista Contraincendios", fechaRevision, cliente);
    this.numeroAlarmas = numeroAlarmas;
}

public int getNumeroAlarmas() {
    return numeroAlarmas;
}

public void setNumeroAlarmas(int numeroAlarmas) {
    this.numeroAlarmas = numeroAlarmas;
}

@Override
public double costeMaterial() {
    return 0;
}

@Override
public double costeManoObra() {
    return (numeroAlarmas / 3) * 40;
}

@Override
public String detalleServicio() {
    double costeManoObra = costeManoObra();
    double costeTotal = costeTotal();

    return "REVISIÓN PERIÓDICA ALARMAS CONTRAINCENDIOS\n" +
            "Cliente: " + getCliente() + "\n" +
            "Fecha revisión: " + getFechaInicio() + "\n" +
            "TOTAL: " + costeTotal;
}
}
