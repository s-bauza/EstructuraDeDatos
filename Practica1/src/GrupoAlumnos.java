public class GrupoAlumnos {

    //    Atributos
    static int max = 10;
    private Alumno[] listaAlumnos = new Alumno[max];
    private int numAlumnos, maximo;
    private String nombre;
//    Metodos

    public GrupoAlumnos() {
        this.nombre = "GrupoDesconocido";
        this.maximo = 10;
        this.numAlumnos = 0;
        listaAlumnos = new Alumno[max];
    }

    public GrupoAlumnos(int max, String nom) {
        this.nombre = nom;
        this.numAlumnos = 0;
        listaAlumnos = new Alumno[max];
        this.maximo = max;
    }

    public int getNumAlumnos() {
        return numAlumnos;
    }

    public int getMaximo() {
        return maximo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void alumnoPos(int i) {
        Alumno a;
        if (i < numAlumnos) {
            a = listaAlumnos[i];
        }
    }

    public boolean insertarAlumno(Alumno a) {
        boolean result = false;
        if (numAlumnos < maximo) {
            listaAlumnos[numAlumnos] = a;
            numAlumnos++;
            result = true;
        }
        return result;
    }

    public void mostrarGrupo() {
        System.out.println("Grupo: " + nombre);
        for (int i = 0; i < numAlumnos; i++) {
            listaAlumnos[i].mostrarAlumno();
            listaAlumnos[i].mostrarAsignaturs();
        }
    }

    public double mediaCalific() {
        double n = 0;
        for (int i = 0; i < numAlumnos; i++) {
            n += listaAlumnos[i].getCalificacion();
        }
        return n / numAlumnos;
    }

    public void masxclif() {
        int a = 0;
        for (int i = 1; i < numAlumnos; i++) {
            if (listaAlumnos[i - 1].getCalificacion() < listaAlumnos[i].getCalificacion() && (listaAlumnos[a].getCalificacion() < listaAlumnos[i].getCalificacion()))
                a = i;
        }
        listaAlumnos[a].mostrarAlumno();
        listaAlumnos[a].mostrarAsignaturs();
    }
}
