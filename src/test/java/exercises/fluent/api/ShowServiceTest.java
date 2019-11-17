package exercises.fluent.api;

import exercises.fluent.api.model.Event;
import exercises.fluent.api.model.Show;
import exercises.fluent.api.model.Venue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;

class ShowServiceTest {
    private ShowService showService = new ShowService();

    private List<Show> validShows;

    private Random random = new Random();

    private Venue venue;

    @BeforeEach
    public void setUp() {
        validShows = new ArrayList<>();
        venue = new Venue();
    }

    @DisplayName("It should find two matching shows.")
    @Test
    public void getShowsTwoMatching() {
        LocalDateTime searchedDate =  LocalDateTime.MIN;
        venue.setShows(createMockShowList(2, 10, searchedDate));

        List<Show> result = showService.getShows(venue, searchedDate);

        assertThat(result, hasSize(2));
        assertThat(result, equalTo(validShows));
    }

    @DisplayName("It should find first five matching shows from ten existing.")
    @Test
    public void getShowsFiveMatching() {
        LocalDateTime searchedDate =  LocalDateTime.MIN;
        venue.setShows(createMockShowList(10, 15, searchedDate));

        final var result = showService.getShows(venue, searchedDate);

        assertThat(result, hasSize(5));
        assertThat(validShows, hasItems(result.toArray(new Show[0])));
    }

    @DisplayName("It should return empty collection.")
    @Test
    public void getShowsNoneMatching() {
        LocalDateTime searchedDate =  LocalDateTime.MIN;
        venue.setShows(createMockShowList(0, 10, searchedDate));

        List<Show> result = showService.getShows(venue, searchedDate);

        assertThat(result, empty());
    }

    private List<Show> createMockShowList(
            int numberOfMatchingShows, int numberOfNotMatchingShows, LocalDateTime searchedEventDate) {

        validShows = createListOfShowsForDate(numberOfMatchingShows, searchedEventDate);
        List<Show> shows = new ArrayList<>(validShows);
        for (int i = 0; i < numberOfNotMatchingShows; ++i) {
            shows.add(createMockShow(LocalDateTime.now()));
        }
        return shows;

    }

    private List<Show> createListOfShowsForDate(int numberOfShows, LocalDateTime eventTime) {
        List<Show> shows = new ArrayList<>();
        for (int i = 0; i < numberOfShows; ++i) {
            shows.add(createMockShow(eventTime));
        }
        return shows;
    }

    private Show createMockShow(LocalDateTime eventTime) {
        final var show = new Show();
        //plusHours forces to create new object instead of use old reference.
        show.setEvents(createMockEvents(eventTime.plusHours(0)));

        return show;
    }

    private List<Event> createMockEvents(LocalDateTime oneEventDate) {
        List<Event> events = new ArrayList<>();
        events.add(new Event(oneEventDate));
        final var numberOfAdditionalEvents = random.nextInt(11);
        for (int i = 0; i < numberOfAdditionalEvents; ++i) {
            events.add(new Event(LocalDateTime.now().plusDays(i)));
        }
        Collections.shuffle(events);

        return events;
    }
}