import java.time.LocalTime;
import java.util.ArrayList;

public class Kalendarz {

    private final ArrayList<Spotkanie>[] calendar;

    public Kalendarz() {
        this(7);
    }

    public Kalendarz(int days) {
        this.calendar = new ArrayList[days];
        for (int i = 0; i < days; i++) {
            this.calendar[i] = new ArrayList<>();
        }
    }

    public void addMeeting(int day, String desc, String startTime, String endTime, String priority) {
        this.calendar[day].add(new Spotkanie(desc, LocalTime.parse(startTime), LocalTime.parse(endTime), priority));

        System.out.println("Dodano nowe spotkanie");
    }

    public void deleteMeeting(int day, int meetingNumber) {
        if (!this.isEmpty(day) && meetingNumber < this.calendar[day].size()) {
            this.calendar[day].remove(meetingNumber);
        }
        else {
            System.out.println("Nie ma tego spotkania w tym dniu!");
        }
    }

    public void viewMeeting(int day) {
        if (!this.isEmpty(day)) {
            int number = 0;
            System.out.println("\nDzien " + day);
            System.out.println("-------------");
            for (Spotkanie spotkanie : this.calendar[day]) {
                System.out.println("Numer spotkania: " + number);
                System.out.println("Opis: " + spotkanie.getDesc());
                System.out.println("(" + spotkanie.getStartTime() + " - " + spotkanie.getEndTime() + ")");
                System.out.println("Priorytet: " + spotkanie.getPriority());
                number++;
            }
        }
        else {
            System.out.println("Nie ma spotkań w tym dniu!");
        }
    }

    public void viewMeetingPriority(int day, String priority) {
        if (!this.isEmpty(day)) {
            int number = 0;
            boolean findAnyPriority = false;
            for (Spotkanie spotkanie : this.calendar[day]) {
                if (priority.equals(spotkanie.getPriority())) {
                    System.out.println("Numer spotkania: " + number);
                    System.out.println("Opis: " + spotkanie.getDesc());
                    System.out.println("(" + spotkanie.getStartTime() + " - " + spotkanie.getEndTime() + ")");
                    System.out.println("Priorytet: " + spotkanie.getPriority());
                    findAnyPriority = true;
                }
                number++;
            }
            if (!findAnyPriority) {
                System.out.println("Nie ma spotkań tego dnia z tym priorytetem!");
            }
        }
        else {
            System.out.println("Nie ma spotkań w tym dniu!");
        }
    }

    public boolean isEmpty(int day) {
        return this.calendar[day].isEmpty();
    }

}
