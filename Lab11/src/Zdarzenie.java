import java.time.LocalTime;

public abstract sealed class Zdarzenie permits Spotkanie, Zadanie {
    protected String desc;

    protected LocalTime startTime;

    protected LocalTime endTime;

    protected static final LocalTime EARLIEST_HOUR = LocalTime.of(8, 0);

    protected abstract String getDesc();

    protected abstract LocalTime getStartTime();

    protected abstract LocalTime getEndTime();
}
