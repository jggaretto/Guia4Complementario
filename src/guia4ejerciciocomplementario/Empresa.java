
package guia4ejerciciocomplementario;

class Empresa {
private double costoTotalObras;
public Empresa() {
    this.costoTotalObras = 0;
}

public void contratar(Servicio service) {
    if (service instanceof TrabajoPintura) {
        TrabajoPintura pintura = (TrabajoPintura) service;
        System.out.println("Edificación a pintar: " + pintura.getEdificacion());
        System.out.println(pintura.detalleServicio());
    } else if (service instanceof RevisionAlarma) {
        System.out.println(service.detalleServicio());
    }

    costoTotalObras += service.costeTotal();
}

public void mostrarCostoTotalDeObras() {
    System.out.println("Costo total de las obras contratadas: " + costoTotalObras);
}
}
