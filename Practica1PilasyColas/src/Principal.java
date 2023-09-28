public class Principal {
    public static void main(String[] args) {
        Pila p1 = new Pila();
        Pila p11 = new Pila();
        Pila p2 = new Pila();
        Pila p21 = new Pila();
        Pila p12 = new Pila();
        Pila p3 = new Pila();
        System.out.println("Ejercicio 2");
        System.out.println("2.a boolean comprobarOrden()  comprobaciones: si los elementos de la pila han sido " +
                "introducidos de mayor a menor");
        System.out.println("Primera comprobacion verdadera");
        for (int i = 10; i > 5; i--) {
            p1.apilar(i);
        }
        p1.escribirPila();
        System.out.println("¿La pila esta ordenada?\n" + p1.comprobarOrden());
        System.out.println("Segunda comprobacion falsa");
        p11.apilar(1);
        p11.apilar(2);
        p11.apilar(8);
        p11.apilar(6);
        p11.apilar(7);
        p11.escribirPila();
        System.out.println("¿La pila esta ordenada?\n" + p11.comprobarOrden());
        System.out.println("2.b void unirPila(Pila p) Ej: p1.unirPila(p2) une dos pilas en una en un orden predeterminado");
        p2.apilar(1);
        p2.apilar(2);
        p2.apilar(3);
        p21.apilar(10);
        p21.apilar(20);
        p21.apilar(30);
        p21.apilar(40);
        p2.unirPila(p21);
        p2.escribirPila();
        System.out.println("Estado de la pila que se ha unido, ¿Esta vacia?\n" + p21.pilaVacia());
        System.out.println("2.aa int sumarElementos()devuelve la suma de los elementos de una pila");
        p12.apilar(10);
        p12.apilar(9);
        p12.apilar(8);
        p12.apilar(1);
        p12.apilar(2);
        p12.escribirPila();
        System.out.println("Suma de los elementos de una pila: " + p12.sumarElementos());// Seria el primero pero vino despues
        System.out.println("Ejercicio 3");
        System.out.println("3.a int sumarElementos (Pila p) fuera de la clase pila");
        p12.escribirPila();
        System.out.println("Suma de los elementos de una pila: " + sumarElementos(p12));
        System.out.println("Estado de la pila, ¿Esta vacia?\n" + p12.pilaVacia());
        System.out.println("3.b void unirPilas (Pila p1, Pila p2)");
        unirPilas(p2, p21);
        p2.escribirPila();
        System.out.println("Estado de la pila que se ha unido, ¿Esta vacia?\n" + p21.pilaVacia());
/*******************************************************************************************************************/
        System.out.println("Ejercicio 4 Colas");
        Cola c1 = new Cola();
        Cola c2 = new Cola();
        c1.encolar(8);
        c1.encolar(1);
        c1.encolar(9);
        c1.encolar(4);
        c1.encolar(2);
        c1.escribirCola();
        System.out.println("4.(a.b) Metodo void dejarN( int n) deja en la cola solo los n primeros elementos ");
        c1.dejarN(3);
        c1.escribirCola();
        System.out.println("¿Cola vacia?\n" + c1.colaVacia());
        System.out.println("5.(a.b) Metodo fuera de la clase cola void dejarN( int n, Cola c) deja en la cola solo los n primeros elementos");
        c2.encolar(20);
        c2.encolar(40);
        c2.encolar(10);
        c2.encolar(50);
        c2.escribirCola();
        dejarN(3, c2);
        c2.escribirCola();
        System.out.println("¿Cola vacia?\n" + c2.colaVacia());
        System.out.println("*********************************");
        for (int i = 1; i < 5; i++) {
            p3.apilar(i);
        }
        System.out.println("está el elemento 4? \n" + estaContenidoR(p3, 4));
    }


    public static int sumarElementos(Pila p) {
        int result = 0, max = 0;
        int[] aux = new int[p.numElemPila()];
        for (int i = p.numElemPila() - 1; i >= 0; i--) {
            aux[i] = p.desapilar();
            result += aux[i];
            max++;
        }
        for (int i = 0; i < max; i++) {
            p.apilar(aux[i]);
        }
        return result;
    }

    public static void unirPilas(Pila p1, Pila p2) {
        int[] aux = new int[p2.numElemPila()];
        int max = 0;
        for (int i = p2.numElemPila() - 1; i >= 0; i--) {
            aux[i] = p2.desapilar();
            max++;
        }
        for (int i = 0; i < max; i++) {
            p1.apilar(aux[i]);
        }
    }

    public static void dejarN(int n, Cola c) {
        if (n > c.numElem) n = c.numElem;
        int i = 0;
        int[] aux = new int[n];
        while (c.numElem != 0) {
            if (i < n) {
                aux[i] = c.desencolar();
                i++;
            } else c.desencolar();
        }
        for (int j = 0; j < n; j++) {
            c.encolar(aux[j]);
        }
    }

    public static boolean estaContenidoR(Pila pilaM, int dato) {
        if (!pilaM.pilaVacia()) {
            int actual = pilaM.desapilar();
            if (actual == dato) {
                return true;
            } else {
                boolean resul = estaContenidoR(pilaM, dato);
                pilaM.apilar(actual);
                return resul;
            }
        } else
            return false;
    }
}