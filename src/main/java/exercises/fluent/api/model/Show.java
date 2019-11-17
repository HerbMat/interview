package exercises.fluent.api.model;

import java.util.List;

public class Show {
    private String showName;
    List<Event> events;

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
