import java.util.concurrent.Callable;

public class ColaPrioridades {
    private NodoPrioridad inicio;

    public ColaPrioridades() {
        inicio = null;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    /**
     * Inserta el paciente en la cola que le corresponde según su prioridad.
     * Si no hay ningún paciente con la misma prioridad, crea una cola nueva en la que mete al paciente.
     */
    public void encolar(int prioridad, Paciente paciente) {
        NodoPrioridad anterior = null;
        NodoPrioridad actual = inicio;
        while ((actual != null) && (actual.getClave() < prioridad)) {
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if ((actual != null) && (actual.getClave() == prioridad)) {
            actual.getDato().encolar(paciente);
        } else {
            Cola c2 = new Cola();
            c2.encolar(paciente);
            NodoPrioridad nuevo = new NodoPrioridad(prioridad, c2, actual);
            if (actual == inicio) {
                inicio = nuevo;
            } else {
                anterior.setSiguiente(nuevo);
            }
        }
    }

    /**
     * Busca la clave en la lista. Si la encuentra devuelve el alumno asociado a dicha clave,
     * y si no la encuentra devuelve NULL.
     */
    public Paciente desencolar() {
        NodoPrioridad actual = inicio;
        Paciente result = null;
        if (inicio == null) {
            return result;
        } else {
            if (actual.getDato().colaVacia() == true)
                actual = actual.getSiguiente();
            result = actual.getDato().desencolar();
            return result;
        }

    }

    /**
     * Visualizar todos los pacientes del hospital, ordenados por prioridad
     */
    public void verColaPrioridades() {
        NodoPrioridad aux = inicio;
        while (aux != null) {
            if (aux.getDato().colaVacia() != true)
                System.out.println("Prioridad " + aux.getClave());
            aux.getDato().verCola();
            aux = aux.getSiguiente();
        }
    }
}


