import java.time.LocalTime;

public class Spotkanie {

    private String desc;

    private LocalTime startTime;

    private LocalTime endTime;

    private String priority;

    public static final LocalTime EARLIEST_HOUR = LocalTime.of(8, 0);

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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Opis: " + this.getDesc() + "\n");
        builder.append("(" + this.getStartTime() + " - " + this.getEndTime() + ")\n");
        builder.append("Priorytet: " + this.getPriority() + "\n");

        return builder.toString();
    }

}
