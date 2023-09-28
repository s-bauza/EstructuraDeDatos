public class Arbol {
    private NodoArbol raiz;

    public Arbol() {
        raiz = null;
    }

    public Arbol(char clave) {
        raiz = new NodoArbol(clave);
    }

    // Escribe las claves del árbol binario de raiz a en preorden.
    private void preOrden(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print(nodo.getClave() + " "); // Nodo
            preOrden(nodo.getIz()); // Izquierda
            preOrden(nodo.getDe()); // Derecha
        }
    }

    public void preOrden() {
        System.out.print("Preorden: ");
        preOrden(raiz);
        System.out.println();
    }

    // Escribe las claves del árbol binario de raiz a en postorden.
    private void postOrden(NodoArbol nodo) {
        if (nodo != null) {
            postOrden(nodo.getIz()); // Izquierda
            postOrden(nodo.getDe()); // Derecha
            System.out.print(nodo.getClave() + " "); // Nodo
        }
    }

    public void postOrden() {
        System.out.print("Post orden: ");
        postOrden(raiz);
        System.out.println();
    }

    // Escribe las claves del árbol binario de raiz a en orden central.
    private void ordenCentral(NodoArbol nodo) {
        if (nodo != null) {
            ordenCentral(nodo.getIz()); // Izquierda
            System.out.print(nodo.getClave() + " "); // Nodo
            ordenCentral(nodo.getDe()); // Derecha
        }
    }

    public void ordenCentral() {
        System.out.print("Orden central: ");
        ordenCentral(raiz);
        System.out.println();
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol nodo) {
        raiz = nodo;
    }

    public void juntar(char clave, Arbol a1, Arbol a2) {
        if (a1.raiz == a2.raiz && a1.raiz != null)
            System.out.println("no se pueden mezclar, a1 y a2 son iguales");
        else {
            // Crear el nodo nuevo
            raiz = new NodoArbol(clave, a1.raiz, a2.raiz);
            // Borrar los árboles a1 y a2
            if (this != a1)
                a1.raiz = null;
            if (this != a2)
                a2.raiz = null;
        }
    }

    private String postOrden1(NodoArbol nodoArbol) {
        String resultado = "";
        if (nodoArbol != null) {
            resultado += postOrden1(nodoArbol.getIz()); // Izquierda
            resultado += postOrden1(nodoArbol.getDe()); // Derecha
            resultado += nodoArbol.getClave() + " "; // Nodo
        }
        return resultado;
    }

    public String postOrden1() {//
        String expresion;
        System.out.print("Post orden: ");
        expresion = postOrden1(raiz);
        return expresion;
    }

    private float calcularValor(NodoArbol nodoArbol) {
        MetodosAE metodosAE = new MetodosAE();
        float resultado = 0, de, iz;
        if (metodosAE.esOperador(nodoArbol.getClave())) {
            de = calcularValor(nodoArbol.getDe());
            iz = calcularValor(nodoArbol.getIz());
            if (nodoArbol.getClave() == '-') resultado = iz - de;
            if (nodoArbol.getClave() == '+') resultado = iz + de;
            if (nodoArbol.getClave() == '*') resultado = iz * de;
            if (nodoArbol.getClave() == '/') resultado = iz / de;
        }else resultado=metodosAE.pasarAEntero(nodoArbol.getClave());
        return resultado;
    }

    public float calcularValor() {
        float resultado = calcularValor(raiz);
        System.out.println("El valor del arbol es: ");
        return resultado;
    }

}
