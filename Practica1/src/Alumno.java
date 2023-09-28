/**
 * Created by bo0476.
 */
public class Alumno {
    //    Atributos
    static int MAX = 5;
    private String nombre, apellidos, matricula;
    private double calificacion;
    private String[] asignaturas = new String[MAX];
    private int numAsigs;

//    Metodos

    public Alumno() {
        this.nombre = "";
        this.apellidos = "";
        this.matricula = "";
        this.calificacion = 0;
        asignaturas = new String[MAX];
        this.numAsigs = 0;
    }

    public Alumno(String nombre, String apellidos, String matricula, double calificacion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.matricula = matricula;
        this.calificacion = calificacion;
        asignaturas = new String[MAX];
        this.numAsigs = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public int getNumAsigs() {
        return numAsigs;
    }

    public void anadirAsignatura(String asig) {
        if (numAsigs < MAX) {
            asignaturas[numAsigs] = asig;
            numAsigs++;
        } else System.out.println("\t¡¡¡¡¡Ha superado el numero de asignaturas permitidas!!!!!");
    }

    public void mostrarAsignaturs() {
        if (numAsigs == 0) System.out.println("\tEl alumno no esta matriculado en ninguna asignatura.");
        else if (numAsigs <= MAX) {
            for (int i = 0; i < numAsigs; i++) {
                System.out.println("\t-" + asignaturas[i] + ".");
            }
        }
    }

    public void mostrarAlumno() {
        System.out.println(apellidos + ", " + nombre + ". Matr:" + matricula + " (" + calificacion + ")");
    }
}