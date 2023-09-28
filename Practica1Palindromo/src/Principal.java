public class Principal {
    public static void main(String[] args) {
        System.out.println("Comprobador1");
        Comprobador1 cp1 = new Comprobador1("aroma a mora");
        Comprobador1 cp2 = new Comprobador1("camino a casa");
        Comprobador1 cp3 = new Comprobador1("dabale arroz a la zorra el abad");
        Comprobador1 cp4 = new Comprobador1();
        System.out.println("(cp1) La frase es un palindromo?\n" + cp1.esPalindromo());
        System.out.println("(cp2) La frase es un palindromo?\n" + cp2.esPalindromo());
        System.out.println("(cp3) La frase es un palindromo?\n" + cp3.esPalindromo());
        cp4.leerFrase();
        System.out.println("(cp4) La frase es un palindromo?\n" + cp4.esPalindromo());
        System.out.println("Comprobador2");
        Comprobador2 cp21 = new Comprobador2("aroma a mora");
        Comprobador2 cp22 = new Comprobador2("camino a casa");
        Comprobador2 cp23 = new Comprobador2("dabale arroz a la zorra el abad");
        Comprobador2 cp24 = new Comprobador2();
        System.out.println("(cp21) La frase es un palindromo?\n" + cp21.esPalindromo());
        System.out.println("(cp22) La frase es un palindromo?\n" + cp22.esPalindromo());
        System.out.println("(cp23) La frase es un palindromo?\n" + cp23.esPalindromo());
        cp24.leerFrase();
        System.out.println("(cp24) La frase es un palindromo?\n" + cp24.esPalindromo());
        System.out.println("Comprobador3");
        Comprobador3 cp31 = new Comprobador3("aroma a mora");
        Comprobador3 cp32 = new Comprobador3("camino a casa");
        Comprobador3 cp33 = new Comprobador3("dabale arroz a la zorra el abad");
        Comprobador3 cp34 = new Comprobador3();
        System.out.println("(cp31) La frase es un palindromo?\n" + cp31.esPalindromo());
        System.out.println("(cp32) La frase es un palindromo?\n" + cp32.esPalindromo());
        System.out.println("(cp33) La frase es un palindromo?\n" + cp33.esPalindromo());
        cp34.leerFrase();
        System.out.println("(cp34) La frase es un palindromo?\n" + cp34.esPalindromo());
    }
}
