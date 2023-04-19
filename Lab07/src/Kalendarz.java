import java.time.LocalTime;
import java.util.ArrayList;

public class Kalendarz {

    private static ArrayList<Spotkanie>[] calendar;

    public Kalendarz() {
        calendar = new ArrayList[7];
        for (int i = 0; i < calendar.length; i++) {
            calendar[i] = new ArrayList<>();
        }
    }

    public void addMeeting(int day, String desc, String startTime, String endTime, String priority) {
        calendar[day].add(new Spotkanie(desc, LocalTime.parse(startTime), LocalTime.parse(endTime), priority));

        System.out.println("Dodano nowe spotkanie");
    }

    public void deleteMeeting(int day, int meetingNumber) {
        if (!calendar[day].isEmpty() && meetingNumber < calendar[day].size()) {
            calendar[day].remove(meetingNumber);
        }
        else {
            System.out.println("Nie ma spotkań w tym dniu!");
        }
    }

    public void viewMeeting(int day) {
        if (!calendar[day].isEmpty()) {
            int number = 0;
            System.out.println("Dzien " + day);
            System.out.println("-------------");
            for (Spotkanie spotkanie : calendar[day]) {
                System.out.println("Numer spotkania: " + number);
                System.out.println("Opis: " + spotkanie.getDesc());
                System.out.println("(" + spotkanie.getStartTime() + " - " + spotkanie.getEndTime() + ")");
                System.out.println("Priorytet: " + spotkanie.getPriority() + "\n");
                number++;
            }
        }
        else {
            System.out.println("Nie ma spotkań w tym dniu!");
        }
    }

    public void viewMeetingPriority(int day, String priority) {
        if (!calendar[day].isEmpty()) {
            int number = 0;
            for (Spotkanie spotkanie : calendar[day]) {
                if (priority.equals(spotkanie.getPriority())) {
                    System.out.println("Numer spotkania: " + number);
                    System.out.println("Opis: " + spotkanie.getDesc());
                    System.out.println("(" + spotkanie.getStartTime() + " - " + spotkanie.getEndTime() + ")");
                    System.out.println("Priorytet: " + spotkanie.getPriority() + "\n");
                }
                number++;
            }
        }
        else {
            System.out.println("Nie ma spotkań w tym dniu!");
        }
    }

}
