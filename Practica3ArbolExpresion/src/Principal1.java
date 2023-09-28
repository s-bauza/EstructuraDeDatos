public class Principal1 {
    public static void main(String[] args) {
        MetodosAE metodos = new MetodosAE();
        Arbol arbol = metodos.notacInfija("((5 + 2) * (8 - 3)) / 4");
        System.out.println(arbol.postOrden1());
        arbol.ordenCentral();
        arbol.preOrden();
        System.out.println(arbol.calcularValor());
        System.out.println("-----------------------------------------------------");
        Arbol arbol2 = metodos.notacInfija("((9+2)*(7-2))/2");
        System.out.println(arbol2.postOrden1());
        arbol2.ordenCentral();
        arbol2.preOrden();
        System.out.println(arbol2.calcularValor());
        System.out.println("-----------------------------------------------------");
        Arbol arbol3 = metodos.notacInfija("((2*9)+((3-7)*5))/9");
        System.out.println(arbol3.postOrden1());
        arbol3.ordenCentral();
        arbol3.preOrden();
        System.out.println(arbol3.calcularValor());
        System.out.println("-----------------------------------------------------");
    }

}
