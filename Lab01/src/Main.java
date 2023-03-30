import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program do liczenia silni n! (Aby wyjsc z programu, wpisz 'exit')");

        Scanner input = new Scanner(System.in);

        boolean loop = true;

        while (loop) {
            System.out.print("Podaj liczbe n: ");
            final String userInput = input.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                loop = false;
            }
            else {
                try {
                    final int n = Integer.parseInt(userInput);
                    if (n < 0) {
                        System.out.println("Nie mozna policzyc petli z n < 0");
                    }
                    else {
                        long wynik = silnia(n);
                        System.out.println(n + "! = " + wynik);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Nieprawidlowe polecenie");
                }
            }
        }

        System.out.println("Koniec programu");
    }

    public static long silnia(int n) {
        long result = 1L;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
