import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program - Oferty sprzedaży mieszkań i domów\n");

        ListaOfert listaOfert = new ListaOfert();
        Scanner input = new Scanner(System.in);

        boolean loop = true;
        while (loop) {
            printInfo();
            try {
                loop = optionChoice(listaOfert, input);
            } catch (NumberFormatException e) {
                System.out.println("[BŁĄD]: Nieprawidłowe polecenie");
            }
            if (loop) {
                System.out.println();
            }
        }

        System.out.println("Koniec programu");
        input.close();
    }

    private static void printInfo() {
        System.out.println("------------------------------ Zestaw opcji ------------------------------");
        System.out.println("1 - Dodanie oferty sprzedaży domu z podaniem parametrów");
        System.out.println("2 - Dodanie oferty sprzedaży mieszkania z podaniem parametrów");
        System.out.println("3 - Wyświetlenie wszystkich aktualnych ofert sprzedaży domów");
        System.out.println("4 - Wyświetlenie wszystkich aktualnych ofert sprzedaży mieszkań");
        System.out.println("5 - Wyświetlenie wszystkich aktualnych ofert sprzedaży domów, w podanej miejscowości, o powierzchni nie mniejszej niż podana wartość");
        System.out.println("6 - Wyświetlenie wszystkich aktualnych ofert sprzedaży mieszkań, w podanej miejscowości, nie droższych niż podana wartość i od podanego piętra wzwyż");
        System.out.println("7 - Wyjście z programu");
        System.out.println("--------------------------------------------------------------------------\n");
        System.out.print("Podaj wybór opcji: ");
    }

    private static boolean optionChoice(ListaOfert listaOfert, Scanner input) {
        final int userInput = input.nextInt();
        input.nextLine();
        System.out.println();
        switch (userInput) {
            case 1 -> addNewHouse(listaOfert, input);
            case 2 -> addNewFlat(listaOfert, input);
            case 3 -> viewHouses(listaOfert);
            case 4 -> viewFlats(listaOfert);
            case 5 -> viewHousesTown(listaOfert, input);
            case 6 -> viewFlatsTown(listaOfert, input);
            case 7 -> {
                return false;
            }
            default -> System.out.println("[BŁĄD]: Nieprawidłowe polecenie!");
        }
        return true;
    }

    private static void addNewHouse(ListaOfert listaOfert, Scanner input) {
        System.out.print("Podaj ulice: ");
        String ulica = input.nextLine();
        System.out.print("Podaj numer domu: ");
        int numerDomu = input.nextInt();
        input.nextLine();
        System.out.print("Podaj miejscowosc: ");
        String miejscowosc = input.nextLine();
        System.out.print("Podaj kod pocztowy: ");
        String kodPocztowy = input.nextLine();
        System.out.print("Podaj powierzchnie: ");
        double powierzchnia = input.nextDouble();
        System.out.print("Podaj cenę: ");
        double cena = input.nextDouble();
        System.out.print("Podaj powierzchnię działki: ");
        double powierzchniaDzialki = input.nextDouble();
        input.nextLine();
        System.out.print("Podaj datę obowiązywania oferty: ");
        String dataObowiazywania = input.nextLine();

        listaOfert.add(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, powierzchniaDzialki, LocalDate.parse(dataObowiazywania));
        System.out.println("Dodano nowy dom");
    }

    private static void addNewFlat(ListaOfert listaOfert, Scanner input) {
        System.out.print("Podaj ulice: ");
        String ulica = input.nextLine();
        System.out.print("Podaj numer domu: ");
        int numerDomu = input.nextInt();
        input.nextLine();
        System.out.print("Podaj numer mieszkania: ");
        int numerMieszkania = input.nextInt();
        input.nextLine();
        System.out.print("Podaj miejscowosc: ");
        String miejscowosc = input.nextLine();
        System.out.print("Podaj kod pocztowy: ");
        String kodPocztowy = input.nextLine();
        System.out.print("Podaj powierzchnie: ");
        double powierzchnia = input.nextDouble();
        System.out.print("Podaj numer piętra: ");
        input.nextLine();
        int numerPietra = input.nextInt();
        System.out.print("Podaj cenę: ");
        double cena = input.nextDouble();
        input.nextLine();
        System.out.print("Podaj datę obowiązywania oferty: ");
        String dataObowiazywania = input.nextLine();

        listaOfert.add(ulica, numerDomu, numerMieszkania, miejscowosc, kodPocztowy, powierzchnia, numerPietra, cena, LocalDate.parse(dataObowiazywania));
        System.out.println("Dodano nowe mieszkanie");
    }

    private static void viewHouses(ListaOfert listaOfert) {
        LocalDate dataBiezaca = LocalDate.now();
        printBuildings(listaOfert.filter(d -> (d instanceof Dom) && ((d.getDataObowiazywania()).isAfter(dataBiezaca)
                || d.getDataObowiazywania().equals(dataBiezaca))));
    }

    private static void viewFlats(ListaOfert listaOfert) {
        LocalDate dataBiezaca = LocalDate.now();
        printBuildings(listaOfert.filter(m -> (m instanceof Mieszkanie) && ((m.getDataObowiazywania()).isAfter(dataBiezaca)
                || m.getDataObowiazywania().equals(dataBiezaca))));
    }

    private static void viewHousesTown(ListaOfert listaOfert, Scanner input) {
        System.out.print("Podaj miejscowosc: ");
        String miejscowosc = input.nextLine();

        System.out.print("Podaj powierzchnie: ");
        double powierzchnia = input.nextDouble();
        input.nextLine();

        LocalDate dataBiezaca = LocalDate.now();
        printBuildings(listaOfert.filter(d -> (d instanceof Dom) && ((d.getDataObowiazywania()).isAfter(dataBiezaca)
                || d.getDataObowiazywania().equals(dataBiezaca)) && d.getMiejscowosc().equals(miejscowosc) && d.getPowierzchnia() >= powierzchnia));
    }

    private static void viewFlatsTown(ListaOfert listaOfert, Scanner input) {
        System.out.print("Podaj miejscowosc: ");
        String miejscowosc = input.nextLine();

        System.out.print("Podaj cena: ");
        double cena = input.nextDouble();

        System.out.print("Podaj numer piętra: ");
        int numerPietra = input.nextInt();
        input.nextLine();

        LocalDate dataBiezaca = LocalDate.now();
        printBuildings(listaOfert.filter(m -> (m instanceof Mieszkanie) && ((m.getDataObowiazywania()).isAfter(dataBiezaca)
                || m.getDataObowiazywania().equals(dataBiezaca)) && m.getMiejscowosc().equals(miejscowosc) && m.getCena() <= cena
                && ((Mieszkanie) m).getNumerPietra() >= numerPietra));
    }

    private static void printBuildings(ArrayList<Budynek> budynki) {
        if (budynki.isEmpty()) {
            System.out.println("Brak ofert");
        }

        for (int i = 0; i < budynki.size(); i++) {
            if (budynki.get(i) instanceof Dom) {
                System.out.println("Dom: " + i);
            }
            else {
                System.out.println("Mieszkanie: " + i);
            }

            System.out.println(budynki.get(i).toString());
        }
    }
}