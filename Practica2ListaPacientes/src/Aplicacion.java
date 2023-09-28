import java.util.Iterator;

public class Aplicacion {

    public static void main(String[] args) {
        ListaOrdinal list = new ListaOrdinal();

        Paciente p1 = new Paciente("Alberto", "Frecuentes mareos");
        Paciente p2 = new Paciente("Ana", "Infección resistente");
        Paciente p3 = new Paciente("Eva", "Problemas digestivos");
        Paciente p4 = new Paciente("Ernesto", "Problemas cardiovasculares");
        list.insertar(p1, 0);
        list.insertar(p2, 1);
        list.insertar(p3, 2);
        list.insertar(p4, 3);
        p2.darAlta();
        p3.darAlta();
        System.out.println("PACIENTES DEL HOSPITAL:");
        Iterador it = list.obtenerIterador();
        while (it.hasNext()) {
            it.next().verPaciente();
        }
        System.out.println("--------------------");
        list.borrarAltas();
        System.out.println("DESPUÉS DE BORRAR LAS ALTAS:");
        it = list.obtenerIterador();
        while (it.hasNext()) {
            it.next().verPaciente();
        }
        System.out.println("--------------------");
        list.insertar(p2, 1);
        list.insertar(p3, 2);
        verAltas(list);
        System.out.println("--------------------");
        pacientesSintoma(list, "mareo");
        System.out.println("--------------------");
    }

    public static void verAltas(ListaOrdinal lista) {
        System.out.println("PACIENTES DE ALTA:");
        int i = 0;
        Iterador it = lista.obtenerIterador();
        it = lista.obtenerIterador();
        while (it.hasNext()) {
            if (it.next().estaAlta() == true)
                lista.get(i).verPaciente();
            i++;
        }
    }

    public static ListaOrdinal pacientesSintoma(ListaOrdinal lista, String sintoma) {
        System.out.println("PACIENTES CON " + sintoma.toUpperCase() + ":");
        int i = 0;
        Iterador it = lista.obtenerIterador();
        it = lista.obtenerIterador();
        while (it.hasNext()) {
            if (it.next().getSintomas().toUpperCase().indexOf(sintoma.toUpperCase()) != -1)
                lista.get(i).verPaciente();
            i++;
        }
        return null;
    }
}