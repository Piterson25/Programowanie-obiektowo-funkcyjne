import java.time.LocalTime;

public class Spotkanie {

    private final String desc;

    private final LocalTime startTime;

    private final LocalTime endTime;

    private final String priority;

    public static final LocalTime earliestHour = LocalTime.of(8, 0);

    public Spotkanie(String desc, LocalTime startTime, LocalTime endTime, String priority) {
        this.desc = desc;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
    }

    public String getDesc() {
        return this.desc;
    }

    public LocalTime getStartTime() {
        return this.startTime;
    }

    public LocalTime getEndTime() {
        return this.endTime;
    }

    public String getPriority() {
        return this.priority;
    }

}
