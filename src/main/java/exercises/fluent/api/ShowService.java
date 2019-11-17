package exercises.fluent.api;

import exercises.fluent.api.model.Event;
import exercises.fluent.api.model.Show;
import exercises.fluent.api.model.Venue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ShowService {
    public List<Show> getShows(Venue v, LocalDateTime givenDate) {
        return v.getShows()
                .stream().filter(show -> isShowInGivenDate(show, givenDate))
                .limit(5)
                .collect(Collectors.toList());
    }

    private boolean isShowInGivenDate(Show show, LocalDateTime givenDate) {
        return show.getEvents()
                .stream()
                .map(Event::getDateTime)
                .anyMatch(givenDate::isEqual);
    }
}
