import java.time.LocalTime;

public final class Spotkanie extends Zdarzenie {

    private String priority;

    public Spotkanie(String desc, LocalTime startTime, LocalTime endTime, String priority) {
        this.desc = desc;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
    }

    public String getDesc() {
        return super.desc;
    }

    public LocalTime getStartTime() {
        return super.startTime;
    }

    public LocalTime getEndTime() {
        return super.endTime;
    }

    public String getPriority() {
        return this.priority;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Opis: " + this.desc + "\n");
        builder.append("(" + this.startTime + " - " + this.endTime + ")\n");
        builder.append("Priorytet: " + this.priority + "\n");

        return builder.toString();
    }

}
