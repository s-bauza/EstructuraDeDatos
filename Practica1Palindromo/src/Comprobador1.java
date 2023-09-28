import java.util.Scanner;

public class Comprobador1 {
    //    Atributos
    private String frase;
    private PilaCaracteres p1, p2;

    //  Metodos
    public Comprobador1() {
        this.frase = " ";
        p1 = new PilaCaracteres();
        p2 = new PilaCaracteres();
    }

    public Comprobador1(String frase) {
        this.frase = frase;
        p1 = new PilaCaracteres();
        p2 = new PilaCaracteres();
    }

    public boolean esPalindromo() {
        boolean result = true;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) != 32)
                p1.apilar(frase.charAt(i));
        }
        if (frase.length() % 2 == 0) {
            int numElem1 = p1.numElemPila();
            for (int i = 1; i <= numElem1 / 2; i++) {
                p2.apilar(p1.desapilar());
            }
        } else {
            int numElem = p1.numElemPila();
            for (int i = 1; i <= (numElem - 1) / 2; i++) {
                p2.apilar(p1.desapilar());
            }
            p1.desapilar();
        }
        while ((p1.numElemPila() != 0) && (p2.numElemPila() != 0) && result != false) {
            if (p1.desapilar() == p2.desapilar()) {
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
