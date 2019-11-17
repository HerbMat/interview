package exercises.fluent.api.model;

import exercises.fluent.api.model.Show;

import java.util.List;

public class Venue { // represents particular theater
    private String city;
    private String venueName;
    List<Show> shows;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}
