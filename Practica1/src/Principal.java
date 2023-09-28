/**
 * Created by bo0476.
 */
public class Principal {
    public static void main(String[] args) {
//Alumno
        Alumno a1 = new Alumno("Felipe", "Arias Gonzales", "aa1253", 3.50);
        Alumno a2 = new Alumno("Manuel", "Garcia Sacedon", "ax0074", 8.35);
        Alumno a3 = new Alumno("Margarita", "Lopez Medina", "mj7726", 7.70);
        Alumno a4 = new Alumno("Estela", "Sanchez Arellano", "bc2658", 6.75);
        Alumno a5 = new Alumno("Santiago", "Bauzá Hirschler", "bo0476", 10);

        /*     Pruebas de la practica insertar y mostrar datos de alumnos. (1 al 3)
       Para insertar una asignatura llamamos a un alumno ax seguido de un punto ax. y el metodo
       ax.andirAsignatura("la signatura").
       para mostrar los datos hacemos lo mismo llamando a la funcion mostraraAlumo() y la otra
       mostrarAsignaturas().
        */

        a4.anadirAsignatura("Estructura de datos");
        a4.anadirAsignatura("Fisica");
        System.out.println("\n");
        a4.mostrarAsignaturs();
        a1.mostrarAlumno();
        a1.mostrarAsignaturs();
        a4.mostrarAlumno();
        a4.mostrarAsignaturs();
        a5.anadirAsignatura("Estructura de Datos");
        a5.anadirAsignatura("Algebra");
        a5.anadirAsignatura("Seguridad de la informacion");
        a5.anadirAsignatura("Fisica");
        /**************************************************************/
        System.out.println("\n\n\nDESPUES DEL PUNTO 3...\n\n\n");
        /**************************************************************/
//Grupos
        GrupoAlumnos g1 = new GrupoAlumnos(20, "GT13");// grupo con x plazas y, y nombre de gx
//     Manera de insertar un alumno en un grupo ej: g1.insertarAlumno(el alumno)
        g1.insertarAlumno(a1);
        g1.insertarAlumno(a2);
        g1.insertarAlumno(a3);
        g1.insertarAlumno(a4);
        g1.insertarAlumno(a5);
        g1.mostrarGrupo();// Muestra todos los datos del grupo
        System.out.println("\nLa calificacion media del grupo g1 es: " + g1.mediaCalific() + "\n"); //se pueden probar otros valores cambiandolos en calificacion arriba ^
        System.out.println("Primer alumn@ con maxima nota del grupo: ");
        g1.masxclif(); //Muestra la primera persona con mayor calificacion aun habiendo iguales, se pueden probar distintas combinaciones cambiando las calificaciones arriba ^
    }
}