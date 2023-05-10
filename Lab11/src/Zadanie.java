import java.time.LocalTime;

public final class Zadanie extends Zdarzenie {

    private String status;

    public Zadanie(String desc, LocalTime startTime, LocalTime endTime, String status) {
        this.desc = desc;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
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

    public String getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Opis: " + this.desc + "\n");
        builder.append("(" + this.startTime + " - " + this.endTime + ")\n");
        builder.append("Status: " + this.status + "\n");

        return builder.toString();
    }
}
