import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program - Kalendarz tygodniowy spotkań\n");

        Kalendarz kalendarz = new Kalendarz();

        Scanner input = new Scanner(System.in);

        boolean loop = true;
        while (loop) {
            printInfo();
            try {
                loop = optionChoice(kalendarz, input);
            } catch (NumberFormatException e) {
                System.out.println("Nieprawidłowe polecenie");
            }
            if (loop) System.out.println();
        }

        System.out.println("Koniec programu");
    }

    private static void printInfo() {
        System.out.println("------------------------------ Zestaw opcji ------------------------------");
        System.out.println("1 - Dodanie spotkania na wybrany dzień");
        System.out.println("2 - Usunięcie wybranego spotkania z wybranego dnia");
        System.out.println("3 - Wyświetlenie wszystkich spotkań w wybranym dniu");
        System.out.println("4 - Wyświetlenie wszystkich spotkań w wybranym dniu o wybranym priorytecie");
        System.out.println("5 - Wyjście z programu");
        System.out.println("--------------------------------------------------------------------------\n");
        System.out.print("Podaj wybór opcji: ");
    }

    private static boolean optionChoice(Kalendarz kalendarz, Scanner input) {
        final int userInput = input.nextInt();
        System.out.println();
        switch (userInput) {
            case 1 -> addNewMeeting(kalendarz, input);
            case 2 -> deleteMeeting(kalendarz, input);
            case 3 -> viewMeetings(kalendarz, input);
            case 4 -> viewMeetingsPriority(kalendarz, input);
            case 5 -> {
                return false;
            }
            default -> System.out.println("Nieprawidłowe polecenie!");
        }
        return true;
    }

    private static int checkDay(Scanner input) {
        System.out.print("Podaj dzien tygodnia (0-6): ");
        int day = input.nextInt();
        while (day > 6) {
            System.out.print("Nieprawidłowy dzień! Sprobuj jeszcze raz: ");
            day = input.nextInt();
        }
        input.nextLine();

        return day;
    }

    private static void addNewMeeting(Kalendarz kalendarz, Scanner input) {
        int day = checkDay(input);

        System.out.print("Podaj opis spotkania: ");
        String desc = input.nextLine();

        LocalTime earliestHour = Spotkanie.EARLIEST_HOUR;
        System.out.print("Podaj czas poczatku spotkania (po " + earliestHour + "): ");
        String startTime = input.nextLine();
        while (LocalTime.parse(startTime).isBefore(earliestHour)) {
            System.out.print("Spotkanie ustawione za wczesnie! Sprobuj jeszcze raz: ");
            startTime = input.nextLine();
        }

        System.out.print("Podaj czas zakonczenia spotkania: ");
        String endTime = input.nextLine();

        System.out.print("Podaj priorytet spotkania (niski | sredni | wysoki): ");
        String priotity = input.nextLine();

        kalendarz.addMeeting(day, desc, startTime, endTime, priotity);
    }

    private static void deleteMeeting(Kalendarz kalendarz, Scanner input) {
        int day = checkDay(input);
        kalendarz.viewMeeting(day);

        if (!kalendarz.isEmpty(day)) {
            System.out.print("\nPodaj numer spotkania do usunięcia (liczone od 0): ");
            int meetingNumber = input.nextInt();
            kalendarz.deleteMeeting(day, meetingNumber);
        }
    }

    private static void viewMeetings(Kalendarz kalendarz, Scanner input) {
        int day = checkDay(input);

        kalendarz.viewMeeting(day);
    }

    private static void viewMeetingsPriority(Kalendarz kalendarz, Scanner input) {
        int day = checkDay(input);

        System.out.print("Podaj priorytet: ");
        String priority = input.nextLine();

        kalendarz.viewMeetingPriority(day, priority);
    }
}