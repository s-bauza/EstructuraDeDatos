import java.util.Scanner;
import java.util.Stack;


public class Comprobador3 {
    //    Atributos
    private String frase;
    private Stack p1, p2;

    //  Metodos

    public Comprobador3() {
        this.frase = "";
        p1 = new Stack();
        p2 = new Stack();
    }

    public Comprobador3(String frase) {
        this.frase = frase;
        p1 = new Stack();
        p2 = new Stack();
    }

    public boolean esPalindromo() {
        boolean result = true;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) != 32)
                p1.push(frase.charAt(i));
        }if (frase.length() % 2 == 0) {
            int numElem1 = p1.size();
            for (int i = 1; i <= numElem1 / 2; i++) {
                p2.push(p1.pop());
            }
        } else {
            int numElem = p1.size();
            for (int i = 1; i <= (numElem - 1) / 2; i++) {
                p2.push(p1.pop());
            }
            p1.pop();
        }
        while ((p1.size() != 0) && (p2.size() != 0) && result != false) {
            if (p1.pop() == p2.pop()) {
                result = true;
            } else result = false;
        }
        return result;
    }

    public void leerFrase() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribir la frase a continuación: ");
        frase = sc.nextLine();
    }
}
