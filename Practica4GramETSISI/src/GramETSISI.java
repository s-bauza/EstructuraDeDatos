public class GramETSISI {
    private int maxNodos;             // Tamaño máximo de la tabla.
    private int numVertices;          // Número de vértices.
    private boolean matrizAdy[][];    // Matriz de adyacencias del grafo.
    private Persona contactos[];


    public GramETSISI(int n) { //construye una matriz de nxn sin arcos
        maxNodos = n;
        numVertices = 0;
        matrizAdy = new boolean[n][n];
        contactos = new Persona[n];
    }

    public int getMaxNodos() {
        return maxNodos;
    }

    public int getNumVertices() {
        return numVertices;
    }

    // ------------------------------------

    // MÉTODOS PARA INSERTAR Y ELIMINAR VERTICES

    // ------------------------------------


    public void insertaVertice() {
        if (maxNodos == numVertices)
            System.out.println("Error, se supera el número de nodos máximo del grafo");
        else {
            for (int i = 0; i <= numVertices; i++) {
                //simplemento añado el valor false a las celdas
                matrizAdy[i][numVertices] = matrizAdy[numVertices][i] = false;
            }
            Persona nuevo = new Persona();
            nuevo.leerDatos();
            contactos[numVertices] = nuevo;
            numVertices++;
        }
    }

    public void insertaVertice(Persona a) {
        if (maxNodos == numVertices)
            System.out.println("Error, se supera el número de nodos máximo del grafo");
        else {
            for (int i = 0; i <= numVertices; i++) {
                matrizAdy[i][numVertices] = matrizAdy[numVertices][i] = false;
            }
            contactos[numVertices] = a;
            numVertices++;
        }
    }

    public void eliminarVertice(int v) {
        if (v < numVertices && v >= 0) {
            numVertices--;
            int i;
            for (i = 0; i < v; i++) {
                for (int j = v; j < numVertices; j++) {
                    matrizAdy[i][j] = matrizAdy[i][j + 1];
                }
            }
            for (i = v; i < numVertices; i++) {
                contactos[i] = contactos[i + 1];
                int j;
                for (j = 0; j < v; j++) {
                    matrizAdy[i][j] = matrizAdy[i + 1][j];
                }
                for (j = v; j < numVertices; j++) {
                    matrizAdy[i][j] = matrizAdy[i + 1][j + 1];
                }
            }
        } else System.out.println("Error, fuera de rango");
    }

    // ------------------------------------

    // MÉTODOS PARA INSERTAR Y ELIMINAR ARISTAS

    // ------------------------------------

    public void insertaArista(int i, int j) {
        if ((i >= numVertices) || (j >= numVertices))
            System.out.println("Error, los vertices no se encuentran en el grafo.");
        else {
            matrizAdy[i][j] = true;
            matrizAdy[j][i] = matrizAdy[i][j];
        }
    }

    public boolean existeArista(int i, int j) {
        if ((i >= numVertices) || (j >= numVertices)) {
            System.out.println("Error, los vertices no se encuentran en el grafo.");
            return false;
        }
        return matrizAdy[i][j];
    }

    public void imprimirGrafo() {
        System.out.println("Contenido de la matriz: ");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdy[i][j]) System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
        }
        System.out.println("Existen " + numVertices + " contactos:");
        for (int i = 0; i < numVertices; i++) {
            System.out.print((i + 1) + ": ");
            contactos[i].mostrarPersona();
        }
    }


    public int contarGrupos(GramETSISI gramETSISI) {
        int numeroGropos = 0;
        boolean visitados[] = new boolean[gramETSISI.getNumVertices()];
        for (int i = 0; i < gramETSISI.getNumVertices(); i++)
            visitados[i] = false;
        for (int i = 0; i < gramETSISI.getNumVertices(); i++) {
            if (!visitados[i]) {
                contarGrupos(gramETSISI, i, visitados);
                numeroGropos++;
            }
        }
        return numeroGropos;
    }

    private void contarGrupos(GramETSISI gramETSISI, int v, boolean[] visitados) {
        visitados[v] = true;
        for (int i = 0; i < gramETSISI.getNumVertices(); i++) {
            if ((v != i) && (!visitados[i]) && (gramETSISI.existeArista(v, i)))
                contarGrupos(gramETSISI, i, visitados);
        }
    }

    public void mostrarAmigos(String nombre) {
        int i = 0;
        boolean encontrado = false;
        while (i < numVertices && !encontrado) {
            if (nombre.equals(contactos[i].getNombre())) {
                System.out.println("Amigos de " + nombre);
                encontrado = true;
                for (int j = 0; j < numVertices; j++) {
                    if (matrizAdy[i][j]) {
                        contactos[j].mostrarPersona();
                    }
                }
            }
            i++;
        }
        if (!encontrado) System.out.println(nombre + " no existe en los contactos");
    }

    public void mayorGrupo(GramETSISI gramETSISI) {
        int numeroDeAlumnos, maximo = 0;
        int vertice = 0;
        boolean visitados[] = new boolean[gramETSISI.getNumVertices()];
        for (int i = 0; i < gramETSISI.getNumVertices(); i++)
            visitados[i] = false;
        for (int i = 0; i < gramETSISI.getNumVertices(); i++) {
            if (!visitados[i]) {
                numeroDeAlumnos = 1 + mayorGrupo(gramETSISI, i, visitados);
                if (maximo < numeroDeAlumnos) {
                    maximo = numeroDeAlumnos;
                    vertice = i;
                }
            }
        }
        System.out.println("El máximo número de alumnos del mayor  grupo es " + maximo);
        mostrarGrupo(vertice);
    }

    private int mayorGrupo(GramETSISI gramETSISI, int v, boolean[] visitados) {
        int resultado = 0;
        visitados[v] = true;
        for (int i = 0; i < gramETSISI.getNumVertices(); i++) {
            if ((v != i) && (!visitados[i]) && (gramETSISI.existeArista(v, i))) {
                resultado = 1 + mayorGrupo(gramETSISI, i, visitados);
            }
        }
        return resultado;
    }

    private void mostrarGrupo(int vertice) {
        boolean[] visitados = new boolean[numVertices];
        mostrarGrupo(vertice, visitados);
        for (int i = 0; i < numVertices; i++) {
            if (visitados[i]) {
                contactos[i].mostrarPersona();
            }
        }
    }

    private void mostrarGrupo(int vertice, boolean[] visitados) {
        visitados[vertice] = true;
        for (int i = 0; i < numVertices; i++) {
            if ((matrizAdy[vertice][i]) && (!visitados[i])) {
                mostrarGrupo(i, visitados);
            }
        }
    }


}





