/**
 * Created by alumno on 09/05/2019.
 */
public class Principal {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Juan", "123456", "Albufera");
        Persona persona2 = new Persona("José", "231465", "Princesa");
        Persona persona3 = new Persona("Eva", "321654", "Gaztambide");
        Persona persona4 = new Persona("Alicia", "789456", "Castellana");
        Persona persona5 = new Persona("Ernesto", "654321", "Arboleda");
        Persona persona6 = new Persona("Guillermo", "159267", "Arapiles");
        Persona persona7 = new Persona("Alberto", "123456", "Gaztambide");
        Persona persona8 = new Persona("Lucas", "231465", "Princesa");
        Persona persona9 = new Persona("Clara", "789456", "Castellana");
        Persona persona10 = new Persona("Santiago", "625812", "Pedroñeras");
        GramETSISI gramETSISI = new GramETSISI(18);
        gramETSISI.insertaVertice(persona1);
        gramETSISI.insertaVertice(persona2);
        gramETSISI.insertaVertice(persona3);
        gramETSISI.insertaVertice(persona4);
        gramETSISI.insertaVertice(persona5);
        gramETSISI.insertaVertice(persona6);
        gramETSISI.insertaVertice(persona7);
        gramETSISI.insertaVertice(persona8);
        gramETSISI.insertaVertice(persona9);
        gramETSISI.insertaVertice(persona10);
        gramETSISI.insertaArista(0, 1);
        gramETSISI.insertaArista(0, 4);
        gramETSISI.insertaArista(0, 5);
        gramETSISI.insertaArista(1, 4);
        gramETSISI.insertaArista(4, 5);
        gramETSISI.insertaArista(2, 8);
        gramETSISI.insertaArista(2, 9);
        gramETSISI.insertaArista(8, 9);
        gramETSISI.insertaArista(3, 6);
        gramETSISI.insertaArista(6, 7);
        gramETSISI.imprimirGrafo();
        System.out.println("------------------------------------------------------------");
        System.out.println("El numero de grupo(s): " + gramETSISI.contarGrupos(gramETSISI));
        System.out.println("------------------------------------------------------------");
        gramETSISI.mostrarAmigos("Eva");
        System.out.println("------------------------------------------------------------");
        gramETSISI.mayorGrupo(gramETSISI);
        System.out.println("------------------------------------------------------------");


    }
}
