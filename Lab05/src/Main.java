import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program - Oceny studenta");

        GradeList listaOcen = new GradeList();

        Menu(listaOcen);

        System.out.println("Koniec programu");
    }

    public static void Menu(GradeList listaOcen) {
        Scanner input = new Scanner(System.in);

        boolean loop = true;
        while (loop) {
            printInfo();
            try {
                loop = optionChoice(listaOcen, input);
            } catch (NumberFormatException e) {
                System.out.println("Nieprawidłowe polecenie");
            }
            if (loop) System.out.println();
        }
    }

    public static void printInfo() {
        System.out.println("----- Zestaw opcji -----");
        System.out.println("1 - Dodanie nowej oceny");
        System.out.println("2 - Średnia ze wszystkich ocen");
        System.out.println("3 - Najwyższa ocena ze wszystkich ocen");
        System.out.println("4 - Najniższa ocena ze wszystkich ocen");
        System.out.println("5 - Wyjście z programu\n");
        System.out.print("Podaj wybór opcji: ");
    }

    public static boolean optionChoice(GradeList listaOcen, Scanner input) {
        final int userInput = input.nextInt();
        System.out.println();
        switch (userInput) {
            case 1 -> addNewGrade(listaOcen, input);
            case 2 -> gradesAverage(listaOcen);
            case 3 -> gradesMax(listaOcen);
            case 4 -> gradesMin(listaOcen);
            case 5 -> {
                return false;
            }
            default -> System.out.println("Nieprawidłowe polecenie!");
        }
        return true;
    }

    public static void addNewGrade(GradeList listaOcen, Scanner input) {
        System.out.print("Podaj nową ocenę do dodania: ");
        final double grade = input.nextDouble();
        listaOcen.addGrade(grade);
    }

    public static void gradesAverage(GradeList listaOcen) {
        final double average = listaOcen.average();
        if (average == 0.0) {
            System.out.println("Lista ocen jest pusta");
        }
        else {
            System.out.println("Średnia ocen: " + average);
        }
    }

    public static void gradesMax(GradeList listaOcen) {
        final double max = listaOcen.max();
        if (max == 0.0) {
            System.out.println("Lista ocen jest pusta");
        }
        else {
            System.out.println("Najwyższa ocena: " + max);
        }
    }

    public static void gradesMin(GradeList listaOcen) {
        final double min = listaOcen.min();
        if (min == 0.0) {
            System.out.println("Lista ocen jest pusta");
        }
        else {
            System.out.println("Najniższa ocena: " + min);
        }
    }
}
