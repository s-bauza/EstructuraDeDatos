import java.util.Scanner;

public class DivisoresEnteros {
    public static void main(String[] args) {
        int num;
        Scanner lectura = new Scanner(System.in);
        System.out.print("Introduzca un valor entero positivo: ");
        num = lectura.nextInt();
        if (num < 1) {
            System.out.println("Número no válido");
        } else {
            visualizarDivisores(num);
        }
    }

    public static void visualizarDivisores(int valor) {
        int i;
        for (i = 2; i < valor; i++) {
            if ((valor % i) == 0)
                System.out.println(i);
        }
    }
}