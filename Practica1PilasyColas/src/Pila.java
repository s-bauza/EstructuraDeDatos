public class Pila {

    private Nodo cimaPila;
    private int numElementos;

    public Pila() {
        cimaPila = null;
        numElementos = 0;
    }


    public boolean pilaVacia() {

        return cimaPila == null;
    }

    public void apilar(int dato) {
        if (this.pilaVacia())
            cimaPila = new Nodo(dato, null);
        else {
            Nodo nuevo = new Nodo(dato, cimaPila);
            cimaPila = nuevo;
        }
        numElementos++;
    }

    public int desapilar() {
        int valor;
        if (this.pilaVacia()) {
            System.out.println("Error, la pila está vacía");
            valor = -9999;
        } else {
            valor = cimaPila.getDato();
            cimaPila = cimaPila.getSiguiente();
            numElementos--;
        }
        return valor;
    }

    public int cima() {
        int valor;
        if (this.pilaVacia()) {
            System.out.println("Error, la pila está vacía");
            valor = -9999;
        } else {
            valor = cimaPila.getDato();
        }
        return valor;
    }


    public int numElemPila() {
        return numElementos;
    }

    public void escribirPila() {
        Nodo aux = cimaPila;
        System.out.println("contenido de la pila");

        while (aux != null) {
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        }
    }

    public boolean comprobarOrden() {
        boolean result = true;
        Nodo aux = cimaPila;
        int a;
        while (aux != null && result != false) {
            a = aux.getDato();
            aux = aux.getSiguiente();
            if (aux != null)
                if (a < aux.getDato()) {
                    result = true;
                } else result = false;
        }
        return result;
    }

    public void unirPila(Pila p) {
        int aux2, max = 0;
        int[] aux = new int[p.numElementos];
        for (int i = p.numElementos - 1; i >= 0; i--) {
            aux[i] = p.desapilar();
            max++;
        }
        for (int i = 0; i < max; i++) {
            aux2 = aux[i];
            apilar(aux2);
        }

    }
    public int sumarElementos() {
        int result = 0;
        Nodo aux = cimaPila;
        while (aux != null) {
            result += aux.getDato();
            aux = aux.getSiguiente();
        }
        return result;
    }
}
