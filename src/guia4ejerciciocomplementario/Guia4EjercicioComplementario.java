/*
Práctica con Clases Abstractas

Empresa de Mantenimiento
Se va a realizar una aplicación que controle los servicios que realiza una
empresa de mantenimiento. Estos servicios son muy variados, pero todos
ellos comparten una serie de características comunes.
Así pues, se pide que programe una clase abstracta llamada Servicio que
especificará esas características comunes y que servirá para crear, a través
de herencia, las distintas clases de servicios que ofrece la empresa.

Clase Abstracta Servicio
Un servicio siempre tendrá las siguientes propiedades:
Trabajador (String) – nombre y apellidos del trabajador que realiza el
servicio.
FechaInicio (LocalDate) – fecha de inicio del servicio.
Cliente (String) – Es el nombre y apellidos del cliente (o nombre de la
empresa cliente)

Debe haber un constructor que reciba las tres propiedades anteriores.
Debe haber métodos set y get para estas dos propiedades.

Además, un servicio siempre debe tener programados los siguientes
métodos:
double costeMaterial();
Este método calculará el total gastado en material.
double costeManoObra();
Este método calculará el total gastado en mano de obra.

double costeTotal();
Este método calculará el coste total del servicio.
String detalleServicio();
Este método devolverá una cadena con información detallada de lo que
ha costado el Servicio

Clase TrabajoPintura
Esta clase describirá un trabajo de pintura (pintar una casa, una
habitación, etc...) Heredará de la clase Servicio y tendrá las siguientes
características:

Propiedades:
(Además de las de la clase Servicio)
Edificacion(String)-Es el tipo de edificación a pintar: Casa, departamento,
habitación, etc.
Superficie (double) – Es la superficie a pintar (metros cuadrados).
PrecioPintura (double) – Es el precio de un litro de pintura.

Constructor
Crear un constructor que reciba: el trabajador que hace el servicio, la
fecha de inicio, el cliente, la superficie y el precio del litro de pintura.

Métodos get y set
Programe un método get y set para las propiedades de la clase.

Página 3 de 6

Métodos sobrescritos
Se sobreescribirán los métodos abstractos, dándoles un significado según
la siguiente especificación:

double costeMaterial();
Según nos indica el cliente, el coste de material se calcula con la siguiente
fórmula:
Coste_material = (Superficie / 7.8) * PrecioPintura;

double costeManoObra();
Según nos indica el cliente, el coste de mano de obra se calcula con la
siguiente fórmula:
Coste_mano_obra = (Superficie / 10) * 9.5;

double costeTotal();
Según nos indica el cliente, el coste total del servicio se calcula así:
Coste_total = coste_material + coste_mano_obra;
Hay que tener en cuenta que cuando la superficie a pintar es de menos de
50 metros cuadrados se añade un coste adicional del 15% sobre el anterior
coste.

String detalleServicio();
Este método devolverá un resumen del servicio con la siguiente
estructura:

TRABAJO DE PINTURA
Cliente: (cliente)
Fecha de inicio: (fecha)

Pintor: (pintor)
Coste Material..... (coste material)
Coste Mano Obra.... (coste mano de obra)
Coste Adicional.... (coste adicional)
TOTAL: ............ (total coste servicio)

Clase RevisionAlarma
Uno de los servicios que realiza la empresa es la revisión de las alarmas
contraincendios. Para definir este tipo de trabajo programe la clase
RevisionAlarma, heredándola de Servicio, con las siguientes
características:

Propiedades:
Solo tendrá una: el número de alarmas a revisar (int)

Constructor:
Un constructor que reciba: la fecha de la revisión, el nombre del cliente y
el número de alarmas. Este constructor inicializará el nombre del
trabajador a “Revisor Especialista Contraincendios”

Página 5 de 6

Métodos get y set
Un get y set para el número de alarmas.

Métodos sobrescritos

double costeMaterial();
El coste de material en este tipo de trabajo es 0.

double costeManoObra();
El coste de mano de obra dependerá del número de alarmas a revisar y se
calculará de la siguiente forma:
Coste_mano_obra = (número_alarmas / 3) * 40;

double costeTotal();
El coste total es igual al coste de mano de obra.

String detalleServicio();
Este método devolverá un resumen del servicio con la siguiente
estructura:

REVISIÓN PERIÓDICA ALARMAS CONTRAINCENDIOS
Cliente: (cliente)
Fecha revisión: (fecha)

TOTAL: ....... (total coste servicio)


Clase Empresa
Esta clase NO ES UN SERVICIO, posee un acumulador como atributo,
inicializado en 0, un constructor por defecto y los siguientes métodos:
void contratar(Servicio service) Que recibe un servicio; si es TrabajoPintura
mostrará la edificación a pintar y el detalle del servicio; sumando el coste
total; si el servicio es: RevisionAlarme solamente mostrará el detalle del
servicio y también sumará el coste total.
void mostrarCostoTotalDeObras()-> Este método mostrará por pantalla la
suma de todos los servicios contratados a la empresa.
Programa de Prueba

Realice un programa de prueba en el que se creen varios trabajos de
pintura y revisiones de alarmas.

Crear una instancia de Empresa e invocar el método contratar por cada
servicio creado anteriormente.

Al finalizar solicite a la empresa que muestre el coste total de las obras
contratadas.
 */
package guia4ejerciciocomplementario;

import java.time.LocalDate;


public class Guia4EjercicioComplementario {

    
    public static void main(String[] args) {
        // Trabajos de pintura
        TrabajoPintura trabajo1 = new TrabajoPintura("Mario Gonzales", LocalDate.now(), "Cliente 1", "Casa", 100, 10);
        TrabajoPintura trabajo2 = new TrabajoPintura("Hernan Costa", LocalDate.now(), "Cliente 2", "Habitación", 30, 8.5);

        // Revisiones de alarmas
        RevisionAlarma revision1 = new RevisionAlarma(LocalDate.now(), "Cliente 3", 5);
        RevisionAlarma revision2 = new RevisionAlarma(LocalDate.now(), "Cliente 4", 10);

        // Instancia de Empresa
        Empresa empresa = new Empresa();

        // Contratar los servicios
        empresa.contratar(trabajo1);
        System.out.println("---------------------------");
        empresa.contratar(trabajo2);
        System.out.println("---------------------------");
        empresa.contratar(revision1);
        System.out.println("---------------------------");
        empresa.contratar(revision2);
        System.out.println("---------------------------");

        // Costo total de las obras
        empresa.mostrarCostoTotalDeObras();
    }
}

    

