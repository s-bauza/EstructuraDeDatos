import java.sql.SQLOutput;

public class Principal2 {
    public static void main(String[] args) {
        Alumno a1 = new Alumno("Santiago", "Bauza", 10);
        Alumno a2 = new Alumno("Naruto", "Uzumaki", 10);
        Alumno a3 = new Alumno("Sakura", "Kinomoto", 7);
        Alumno a4 = new Alumno("Arturo", "Pendragon", 8);
        Alumno a5 = new Alumno("Lara", "Croft", 6);
        Alumno a6 = new Alumno("Lady di", "Clavius", 9);
        Alumno a7 = new Alumno("Sasuke", "Uchiha", 6);
        Alumno a8 = new Alumno("Bell", "Cranel", 5);
        Arbol arbol = new Arbol();
        arbol.insertar(5, a1);
        arbol.insertar(7, a2);
        arbol.insertar(2, a3);
        arbol.insertar(4, a4);
        arbol.insertar(1, a5);
        arbol.insertar(6, a6);
        arbol.insertar(3, a7);
        arbol.insertar(8, a8);
        System.out.println("PreOrden...");
        arbol.preOrden();
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("OrdenCentral...");
        arbol.ordenCentral();
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("PostOrden...");
        arbol.postOrden();
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(arbol.calificacionMedia());
        System.out.println("---------------------------------------------------------------------------");
        arbol.maxCalif();
        System.out.println("---------------------------------------------------------------------------");
    }
}