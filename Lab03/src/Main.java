import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program do operacji matematycznych na Walcu");

        Walec walec = new Walec();

        Menu(walec);

        System.out.println("Koniec programu");
    }

    public static void Menu(Walec walec) {
        Scanner input = new Scanner(System.in);

        boolean loop = true;
        while (loop) {
            printInfo();
            try {
                loop = optionChoice(walec, input);
            } catch (NumberFormatException e) {
                System.out.println("Nieprawidlowe polecenie");
            }
            if (loop) System.out.println();
        }
    }

    public static boolean optionChoice(Walec walec, Scanner input) {
        final int userInput = Integer.parseInt(input.nextLine());
        System.out.println();
        switch (userInput) {
            case 1 -> printValues(walec);
            case 2 -> changeValues(walec, input);
            case 3 -> printAreas(walec);
            case 4 -> {
                return false;
            }
            default -> System.out.println("Nieprawidlowe polecenie");
        }
        return true;
    }

    public static void printInfo() {
        System.out.println("----- Zestaw opcji -----");
        System.out.println("1 - wyswietlenie wartosci zmiennych instacji obiektu klasy Walec");
        System.out.println("2 - zmiana wartosci zmiennych instancji obiektu klasy Walec");
        System.out.println("3 - wyliczanie i wyswietlanie na konsoli pol powierzchni i objetosci obiektu klasy Walec");
        System.out.println("4 - wyjscie z programu\n");
        System.out.print("Podaj wybor opcji: ");
    }

    public static void printValues(Walec walec) {
        System.out.println("Promien podstawy: " + walec.getBaseRadius());
        System.out.println("Wysokosc: " + walec.getHeight());
    }

    public static void changeValues(Walec walec, Scanner input) {
        System.out.print("Podaj promien walca: ");
        final float radius = Float.parseFloat(input.nextLine());
        walec.setBaseRadius(radius);
        System.out.print("Podaj wysokosc walca: ");
        final float height = Float.parseFloat(input.nextLine());
        walec.setHeight(height);
    }

    public static void printAreas(Walec walec) {
        System.out.println("Pole powierzchni podstawy: " + walec.getBaseSurfaceArea());
        System.out.println("Pole powierzchni bocznej: " + walec.getSideSurfaceArea());
        System.out.println("Pole powierzchni calkowitej: " + walec.getTotalSurfaceArea());
        System.out.println("Objetosc " + walec.getVolume());
    }
}