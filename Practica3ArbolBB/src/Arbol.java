public class Arbol {
    private NodoArbol raiz;

    public Arbol() {
        raiz = null;
    }

    // Escribe las claves del árbol binario de raiz a en preorden.
    private void preOrden(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print(nodo.getClave() + " "); // Nodo
            nodo.getDato().mostrarAlumno();
            preOrden(nodo.getIz()); // Izquierda
            preOrden(nodo.getDe()); // Derecha
        }
    }

    public void preOrden() {
        preOrden(raiz);
    }

    // Escribe las claves del árbol binario de raiz a en postorden.
    private void postOrden(NodoArbol nodo) {
        if (nodo != null) {
            postOrden(nodo.getIz()); // Izquierda
            postOrden(nodo.getDe()); // Derecha
            System.out.print(nodo.getClave() + " "); // Nodo
            nodo.getDato().mostrarAlumno();
        }
    }

    public void postOrden() {
        postOrden(raiz);
    }

    // Escribe las claves del árbol binario de raiz a en orden central.
    private void ordenCentral(NodoArbol nodo) {
        if (nodo != null) {
            ordenCentral(nodo.getIz()); // Izquierda
            System.out.print(nodo.getClave() + " "); // Nodo
            nodo.getDato().mostrarAlumno();
            ordenCentral(nodo.getDe()); // Derecha
        }
    }

    public void ordenCentral() {
        ordenCentral(raiz);
    }

    public void listarAmplitud() {
        NodoArbol p = raiz;
        Cola c = new Cola();
        if (p != null)
            c.encolar(p);
        while (!c.colaVacia()) {
            p = c.desencolar();
            System.out.print(p.getClave() + " ");
            if (p.getIz() != null)
                c.encolar(p.getIz());
            if (p.getDe() != null)
                c.encolar(p.getDe());
        }
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol nodo) {
        raiz = nodo;
    }

    private NodoArbol insertar(NodoArbol nodo, int clave, Alumno dato) {
        if (nodo != null)
            if (nodo.getClave() < clave)
                nodo.setDe(insertar(nodo.getDe(), clave, dato));
            else if (nodo.getClave() > clave)
                nodo.setIz(insertar(nodo.getIz(), clave, dato));
            else
                System.out.println("la clave ya existe");
        else nodo = new NodoArbol(clave, dato);
        return nodo;
    }

    public void insertar(int clave, Alumno dato) {
        raiz = insertar(raiz, clave, dato);
    }

    private float calificacionMedia(NodoArbol nodoArbol, int[] num) {
        float resultado = 0;
        if (nodoArbol != null) {
            num[0]++;
            resultado += calificacionMedia(nodoArbol.getDe(), num);
            resultado += calificacionMedia(nodoArbol.getIz(), num);
            resultado += nodoArbol.getDato().getCalificacion();
        }
        return resultado;
    }

    public float calificacionMedia() {
        int[] num = {0};
        System.out.print("LA calificaion media es: ");
        return calificacionMedia(raiz, num) / num[0];
    }

    private void mejorCalificacion(NodoArbol nodoArbol, NodoArbol mejor) {
        if (nodoArbol != null) {
            if (nodoArbol.getDato().getCalificacion() > mejor.getDato().getCalificacion()) {
                mejor.setDato(nodoArbol.getDato());
            }
            if ((nodoArbol.getDato().getCalificacion() == mejor.getDato().getCalificacion()) && (nodoArbol.getClave() < mejor.getClave())) {
                mejor.setDato(nodoArbol.getDato());
            }
            mejorCalificacion(nodoArbol.getDe(), mejor);
            mejorCalificacion(nodoArbol.getIz(), mejor);
        }
    }

    public void maxCalif() {
        NodoArbol arbolAlumnoMejor = raiz;
        System.out.print("Alumno con mejor nota (clave menor): ");
        mejorCalificacion(raiz, arbolAlumnoMejor);
        arbolAlumnoMejor.getDato().mostrarAlumno();
    }
}
