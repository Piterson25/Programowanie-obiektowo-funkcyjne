import java.time.LocalTime;
import java.util.ArrayList;
import java.util.function.Predicate;

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
    }

    public void deleteMeeting(int day, int meetingNumber) {
        this.calendar[day].remove(meetingNumber);
    }

    public ArrayList<Spotkanie> filter(int day, Predicate<Spotkanie> pred) {
        ArrayList<Spotkanie> meetings = new ArrayList<>();
        for (Spotkanie spotkanie : this.calendar[day]) {
            if (pred.test(spotkanie)) {
                meetings.add(spotkanie);
            }
        }

        return meetings;
    }

}
