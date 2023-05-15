import java.util.ArrayList;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program - Kalendarz tygodniowy zadań i spoktań\n");

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
        System.out.println("2 - Dodanie zadania na wybrany dzień");
        System.out.println("3 - Usunięcie wybranego spotkania z wybranego dnia");
        System.out.println("4 - Usunięcie wybranego zadania z wybranego dnia");
        System.out.println("5 - Wyświetlenie wszystkich spotkań w wybranym dniu");
        System.out.println("6 - Wyświetlenie wszystkich zadań w wybranym dniu");
        System.out.println("7 - Wyświetlenie spotkań w wybranym dniu o wybranym priorytecie");
        System.out.println("8 - Wyświetlenie zadań w wybranym dniu o wybranym statusie");
        System.out.println("9 - Wyświetlenie spotkań w wybranym dniu o wybranym priorytecie i zaczynających się nie wcześniej od podanego czasu");
        System.out.println("10 - Wyświetlenie zadań w wybranym dniu o wybranym statusie i kończących się nie później niż do podanego czasu");
        System.out.println("11 - Wyjście z programu");
        System.out.println("--------------------------------------------------------------------------\n");
        System.out.print("Podaj wybór opcji: ");
    }

    private static boolean optionChoice(Kalendarz kalendarz, Scanner input) {
        final int userInput = input.nextInt();
        System.out.println();
        switch (userInput) {
            case 1 -> addNewMeeting(kalendarz, input);
            case 2 -> addNewTask(kalendarz, input);
            case 3 -> deleteMeeting(kalendarz, input);
            case 4 -> deleteTask(kalendarz, input);
            case 5 -> viewMeetings(kalendarz, input);
            case 6 -> viewTasks(kalendarz, input);
            case 7 -> viewMeetingsPriority(kalendarz, input);
            case 8 -> viewTasksStatus(kalendarz, input);
            case 9 -> viewMeetingsSincePriority(kalendarz, input);
            case 10 -> viewTasksUntilStatus(kalendarz, input);
            case 11 -> {
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
        LocalTime earliestHour = Zdarzenie.EARLIEST_HOUR;
        System.out.print("Podaj czas początku (po " + earliestHour + "): ");
        String startTime = input.nextLine();
        if (LocalTime.parse(startTime).isBefore(earliestHour)) {
            System.out.println("[BŁĄD]: Początek ustawiony przed  " + earliestHour);
            return null;
        }
        return LocalTime.parse(startTime);
    }

    private static LocalTime readEndTime(Scanner input, LocalTime startTime) {
        System.out.print("Podaj czas zakończenia: ");
        String endTime = input.nextLine();
        if (LocalTime.parse(endTime).isBefore(startTime)) {
            System.out.println("[BŁĄD]: Zakończenie jest przed jego początkiem");
            return null;
        }
        return LocalTime.parse(endTime);
    }

    private static String readPriority(Scanner input) {
        System.out.print("Podaj priorytet spotkania: ");
        return input.nextLine();
    }

    private static String readStatus(Scanner input) {
        System.out.print("Podaj status zadania: ");
        return input.nextLine();
    }

    private static void addNewMeeting(Kalendarz kalendarz, Scanner input) {
        final int day = readDay(input);

        System.out.print("Podaj opis spotkania: ");
        String desc = input.nextLine();

        LocalTime startTime = readStartTime(input);
        LocalTime endTime = readEndTime(input, startTime);

        String priority = readPriority(input);

        kalendarz.add(day, desc, startTime, endTime, priority);
        System.out.println("Dodano nowe spotkanie");
    }

    private static void addNewTask(Kalendarz kalendarz, Scanner input) {
        final int day = readDay(input);

        System.out.print("Podaj opis zadania: ");
        String desc = input.nextLine();

        LocalTime startTime = readStartTime(input);
        LocalTime endTime = readEndTime(input, startTime);

        String status = readStatus(input);

        kalendarz.add(desc, startTime, endTime, status, day);
        System.out.println("Dodano nowe zadanie");
    }

    private static void deleteMeeting(Kalendarz kalendarz, Scanner input) {
        final int day = readDay(input);

        printEvents(kalendarz.filter(day, s -> s instanceof Spotkanie));

        System.out.print("\nPodaj numer spotkania do usunięcia: ");
        int meetingNumber = input.nextInt();
        kalendarz.delete(day, meetingNumber);
    }

    private static void deleteTask(Kalendarz kalendarz, Scanner input) {
        final int day = readDay(input);

        printEvents(kalendarz.filter(day, z -> z instanceof Zadanie));

        System.out.print("\nPodaj numer zadania do usunięcia: ");
        int meetingNumber = input.nextInt();
        kalendarz.delete(day, meetingNumber);
    }

    private static void viewMeetings(Kalendarz kalendarz, Scanner input) {
        final int day = readDay(input);

        printEvents(kalendarz.filter(day, s -> s instanceof Spotkanie));
    }

    private static void viewTasks(Kalendarz kalendarz, Scanner input) {
        final int day = readDay(input);

        printEvents(kalendarz.filter(day, z -> z instanceof Zadanie));
    }

    private static void viewMeetingsPriority(Kalendarz kalendarz, Scanner input) {
        final int day = readDay(input);

        String priority = readPriority(input);

        printEvents(kalendarz.filter(day, s -> (s instanceof Spotkanie) && ((Spotkanie) s).getPriority().equals(priority)));
    }

    private static void viewTasksStatus(Kalendarz kalendarz, Scanner input) {
        final int day = readDay(input);

        String status = readStatus(input);

        printEvents(kalendarz.filter(day, z -> (z instanceof Zadanie) && ((Zadanie) z).getStatus().equals(status)));
    }

    private static void viewMeetingsSincePriority(Kalendarz kalendarz, Scanner input) {
        final int day = readDay(input);

        LocalTime startTime = readStartTime(input);
        String priority = readPriority(input);

        printEvents(kalendarz.filter(day, s -> (s instanceof Spotkanie) && ((s.getStartTime()).isAfter(startTime)
                || s.getStartTime().equals(startTime)) && ((Spotkanie) s).getPriority().equals(priority)));
    }

    private static void viewTasksUntilStatus(Kalendarz kalendarz, Scanner input) {
        final int day = readDay(input);

        LocalTime startTime = readStartTime(input);
        LocalTime endTime = readEndTime(input, startTime);
        String status = readStatus(input);

        printEvents(kalendarz.filter(day, z -> (z instanceof Zadanie) && ((z.getEndTime()).isBefore(endTime)
                || z.getStartTime().equals(endTime)) && ((Zadanie) z).getStatus().equals(status)));
    }

    private static void printEvents(ArrayList<Zdarzenie> events) {
        if (events.isEmpty()) {
            System.out.println("Brak zdarzeń");
        }

        for (int i = 0; i < events.size(); i++) {
            Zdarzenie event = events.get(i);
            if (events.get(i) instanceof Spotkanie) {
                System.out.println("Numer spotkania: " + i);
            }
            else {
                System.out.println("Numer zadania: " + i);
            }

            System.out.println(event.toString());
        }
    }
}
