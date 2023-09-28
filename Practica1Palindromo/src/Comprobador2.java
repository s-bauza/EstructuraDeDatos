import java.util.Scanner;

public class Comprobador2 {
    //    Atributos
    private String frase;
    PilaCaracteres p1;
    ColaCaracteres c1;
//    Metodos


    public Comprobador2() {
        this.frase = "";
        p1 = new PilaCaracteres();
        c1 = new ColaCaracteres();
    }

    public Comprobador2(String frase) {
        this.frase = frase;
        p1 = new PilaCaracteres();
        c1 = new ColaCaracteres();
    }

    public boolean esPalindromo() {
        boolean result = true;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) != 32) {
                p1.apilar(frase.charAt(i));
                c1.encolar(frase.charAt(i));
            }
        }
        while ((p1.numElemPila() != 0) && (c1.numElemCola() != 0)&&(result!=false)) {
            if (p1.desapilar() == c1.desencolar()) {
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
