import java.util.ArrayList;
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
        System.out.println("1 - Dodanie spotkania na wybrany dzień");
        System.out.println("2 - Usunięcie wybranego spotkania z wybranego dnia");
        System.out.println("3 - Wyświetlenie wszystkich spotkań w wybranym dniu");
        System.out.println("4 - Wyświetlenie wszystkich spotkań w wybranym dniu o wybranym priorytecie");
        System.out.println("5 - Wyświetlenie wszystkich spotkań w wybranym dniu od podanego czasu");
        System.out.println("6 - Wyświetlenie wszystkich spotkań w wybranym dniu pomiedzy podanymi czasami");
        System.out.println("7 - Wyświetlenie wszystkich spotkań w wybranym dniu o wybranym priorytecie i od podanego czasu");
        System.out.println("8 - Wyjście z programu");
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
            case 5 -> viewMeetingsSince(kalendarz, input);
            case 6 -> viewMeetingsBetween(kalendarz, input);
            case 7 -> viewMeetingsSincePriority(kalendarz, input);
            case 8 -> {
                return false;
            }
            default -> System.out.println("[BŁĄD]: Nieprawidłowe polecenie!");
        }
        return true;
    }

    private static int readDay(Scanner input) {
        System.out.print("Podaj dzień tygodnia (0-6): ");
        int day = input.nextInt();
        input.nextLine();
        return day;
    }

    private static LocalTime readStartTime(Scanner input) {
        LocalTime earliestHour = Spotkanie.EARLIEST_HOUR;
        System.out.print("Podaj czas początku spotkania (po " + earliestHour + "): ");
        String startTime = input.nextLine();
        if (LocalTime.parse(startTime).isBefore(earliestHour)) {
            System.out.println("[BŁĄD]: Początek spotkania ustawiony przed  " + earliestHour);
            return null;
        }
        return LocalTime.parse(startTime);
    }

    private static LocalTime readEndTime(Scanner input, LocalTime startTime) {
        System.out.print("Podaj czas zakończenia spotkania: ");
        String endTime = input.nextLine();
        if (LocalTime.parse(endTime).isBefore(startTime)) {
            System.out.println("[BŁĄD]: Zakończenie spotkania jest przed jego początkiem");
            return null;
        }
        return LocalTime.parse(endTime);
    }

    private static String readPriority(Scanner input) {
        System.out.print("Podaj priorytet spotkania ( niski | średni | wysoki ): ");
        return input.nextLine();
    }

    private static void addNewMeeting(Kalendarz kalendarz, Scanner input) {
        final int day = readDay(input);

        System.out.print("Podaj opis spotkania: ");
        String desc = input.nextLine();

        LocalTime startTime = readStartTime(input);
        LocalTime endTime = readEndTime(input, startTime);

        String priority = readPriority(input);

        kalendarz.addMeeting(day, desc, startTime.toString(), endTime.toString(), priority);
        System.out.println("Dodano nowe spotkanie");
    }

    private static void deleteMeeting(Kalendarz kalendarz, Scanner input) {
        final int day = readDay(input);

        printMeetings(kalendarz.filter(day, (s) -> true));

        System.out.print("\nPodaj numer spotkania do usunięcia (liczone od 0): ");
        int meetingNumber = input.nextInt();
        kalendarz.deleteMeeting(day, meetingNumber);
    }

    private static void viewMeetings(Kalendarz kalendarz, Scanner input) {
        final int day = readDay(input);

        printMeetings(kalendarz.filter(day, (s) -> true));
    }

    private static void viewMeetingsPriority(Kalendarz kalendarz, Scanner input) {
        final int day = readDay(input);

        String priority = readPriority(input);

        printMeetings(kalendarz.filter(day, (s) -> (s.getPriority()).equals(priority)));
    }

    private static void viewMeetingsSince(Kalendarz kalendarz, Scanner input) {
        final int day = readDay(input);

        LocalTime startTime = readStartTime(input);

        printMeetings(kalendarz.filter(day, (s) -> (s.getStartTime()).isAfter(startTime)
                || s.getStartTime().equals(startTime)));
    }

    private static void viewMeetingsBetween(Kalendarz kalendarz, Scanner input) {
        final int day = readDay(input);

        LocalTime startTime = readStartTime(input);
        LocalTime endTime = readEndTime(input, startTime);

        printMeetings(kalendarz.filter(day, (s) -> ((s.getStartTime()).isAfter(startTime)
                || s.getStartTime().equals(startTime)) && (s.getEndTime().isBefore(endTime)
                || s.getStartTime().equals(endTime))));
    }

    private static void viewMeetingsSincePriority(Kalendarz kalendarz, Scanner input) {
        final int day = readDay(input);

        LocalTime startTime = readStartTime(input);
        String priority = readPriority(input);

        printMeetings(kalendarz.filter(day, (s) -> ((s.getStartTime()).isAfter(startTime)
                || s.getStartTime().equals(startTime)) && s.getPriority().equals(priority)));
    }

    private static void printMeetings(ArrayList<Spotkanie> meetings) {
        if (meetings.isEmpty()) {
            System.out.println("Brak spotkań");
        }

        for (int i = 0; i < meetings.size(); i++) {
            Spotkanie spotkanie = meetings.get(i);
            System.out.println("Numer spotkania: " + i);
            System.out.println(spotkanie.toString());
        }
    }
}
