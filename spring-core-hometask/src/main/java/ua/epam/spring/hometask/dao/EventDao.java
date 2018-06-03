package ua.epam.spring.hometask.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.domain.Event;

/**
 * This class can have methods like save, remove, getById, getByName, getAll for
 * the Events.
 * 
 * @author Krishnakanth_Yachare
 *
 */
@Component
public class EventDao {

    /**
     * This map holds the all the events.
     */
    private static final Map<Long, Event> events = new HashMap<>();

    public Event save(Event event) {
        events.put(event.getId(), event);
        return event;
    }

    /**
     * This method can remove the event from the Map.
     * 
     * @param event
     */
    public void remove(Event event) {
        events.remove(event.getId());
    }

    /**
     * Get the Event based on given ID.
     * 
     * @param id
     * @return
     */
    public Event getById(Long id) {
        return events.get(id);
    }

    /**
     * This method can return the Event based on given input string.
     * 
     * @param name
     * @return Event
     */
    public Event getByName(String name) {
        return events.values().stream()
                .filter(e -> e.getName().equalsIgnoreCase(name)).findFirst()
                .orElse(null);
    }

    /**
     * @return set of events.
     */
    public Set<Event> getAll() {
        return events.values().stream().collect(Collectors.toSet());
    }

    /**
     * Get the events in between range date.
     * 
     * @param from Date
     * @param to Date
     * @return Set of Events.
     */
    public Set<Event> getForDateRange(LocalDate from, LocalDate to) {
        return events.values().stream()
                .filter(e -> e.getAirDates().higher(from.atStartOfDay()) != null
                        && e.getAirDates().lower(to.atStartOfDay()) != null)
                .collect(Collectors.toSet());
    }

    /**
     * This method can returns the next upcoming events.
     * 
     * @param to
     * @return
     */
    public Set<Event> getNextEvents(LocalDateTime to) {
        return getForDateRange(LocalDate.now(), to.toLocalDate());
    }
}
