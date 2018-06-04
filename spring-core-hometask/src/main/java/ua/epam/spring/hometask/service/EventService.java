package ua.epam.spring.hometask.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import ua.epam.spring.hometask.domain.Event;

/**
 * @author Yuriy_Tkach
 *     <p>EventService - Manages events (movie shows). Event contains only basic information, like
 *     name, base price for tickets, rating (high, mid, low). Event can be presented on several
 *     dates and several times within each day. For each dateTime an Event will be presented only in
 *     single Auditorium.
 *     <p>save, remove, getById, getByName, getAll getForDateRange(from, to) - returns events for
 *     specified date range (OPTIONAL) getNextEvents(to) - returns events from now till the ‘to’
 *     date (OPTIONAL)
 */
public interface EventService extends AbstractDomainObjectService<Event> {

  /**
   * Finding event by name
   *
   * @param name Name of the event
   * @return found event or <code>null</code>
   */
  @Nullable
  Event getByName(@Nonnull String name);

  /*
   * Finding all events that air on specified date range
   *
   * @param from Start date
   *
   * @param to End date inclusive
   *
   * @return Set of events
   */
  @Nonnull
  Set<Event> getForDateRange(@Nonnull LocalDate from, @Nonnull LocalDate to);

  /*
   * Return events from 'now' till the the specified date time
   *
   * @param to End date time inclusive
   * s
   * @return Set of events
   */
  @Nonnull
  Set<Event> getNextEvents(@Nonnull LocalDateTime to);
}
