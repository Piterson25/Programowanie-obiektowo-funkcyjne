import java.time.LocalTime;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Kalendarz {

    private final ArrayList<Zdarzenie>[] calendar;

    public Kalendarz() {
        this(7);
    }

    public Kalendarz(int days) {
        this.calendar = new ArrayList[days];
        for (int i = 0; i < days; i++) {
            this.calendar[i] = new ArrayList<>();
        }
    }

    public void add(int day, String desc, LocalTime startTime, LocalTime endTime, String priority) {
        this.calendar[day].add(new Spotkanie(desc, startTime, endTime, priority));
    }

    public void add(String desc, LocalTime startTime, LocalTime endTime, String status, int day) {
        this.calendar[day].add(new Zadanie(desc, startTime, endTime, status));
    }

    public void delete(Zdarzenie deleteEvent, int day) {
        this.calendar[day].remove(deleteEvent);
    }

    public ArrayList<Zdarzenie> filter(int day, Predicate<Zdarzenie> pred) {
        ArrayList<Zdarzenie> events = new ArrayList<>();
        for (Zdarzenie event : this.calendar[day]) {
            if (pred.test(event)) {
                events.add(event);
            }
        }

        return events;
    }

}
