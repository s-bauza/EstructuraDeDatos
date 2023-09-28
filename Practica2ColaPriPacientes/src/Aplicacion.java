
public class Aplicacion {

    public static void main(String[] args) {
        Paciente p1 = new Paciente("Alberto", "Frecuentes mareos");
        Paciente p2 = new Paciente("Ana", "Infección resistente");
        Paciente p3 = new Paciente("Eva", "Problemas digestivos");
        Paciente p4 = new Paciente("Ernesto", "Problemas cardiovasculares");
        Cola c1 = new Cola();
        c1.encolar(p1);
        c1.encolar(p2);
        c1.encolar(p3);
        System.out.println("CONTENIDO DE LA COLA:");
        c1.verCola();
        System.out.println("DESENCOLAMOS LA COLA");
        int numC = c1.numElemCola();
        for (int i = 0; i < numC; i++) {
            c1.desencolar();
        }
        System.out.println("¿Cola vacia?\n" + c1.colaVacia());
        System.out.println("--------------------");
        System.out.println("CONTENIDO DE LA COLA:");
        c1.verCola();
        System.out.println("--------------------");
        ColaPrioridades c2 = new ColaPrioridades();
        ColaPrioridades c3 = new ColaPrioridades();
        c2.encolar(4, p1);
        c2.encolar(2, p2);
        c2.encolar(4, p3);
        c2.verColaPrioridades();
        System.out.println("--------------------");
        System.out.println("PACIENTE ATENDIDO:");
        c2.desencolar().verPaciente();
        System.out.println("--------------------");
        c2.verColaPrioridades();
        System.out.println("--------------------");
        System.out.println("LLEGA ERNESTO CON PRIORIDAD 1");
        c2.encolar(1, p4);
        System.out.println("--------------------");
        c2.verColaPrioridades();
        System.out.println("--------------------");
    }

}

