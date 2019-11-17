package exercises.fluent.api.model;

import java.time.LocalDateTime;

public class Event {
    private LocalDateTime dateTime;

    public Event(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
