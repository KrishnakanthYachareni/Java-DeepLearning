package ua.epam.spring.hometask.service;

import java.time.LocalDateTime;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.Ticket;
import ua.epam.spring.hometask.domain.User;

/**
 * @author Yuriy_Tkach
 *     <p>BookingService - Manages tickets, prices, bookings
 *     <p>getTicketsPrice(event, dateTime, user, seats) - returns total price for buying all tickets
 *     for specified event on specific date and time for specified seats. User is needed to
 *     calculate discount (see below) Event is needed to get base price, rating Vip seats should
 *     cost more than regular seats (For example, 2xBasePrice) All prices for high rated movies
 *     should be higher (For example, 1.2xBasePrice) bookTicket(tickets) - Ticket should contain
 *     information about event, air dateTime, seat, and user. The user could be registered or not.
 *     If user is registered, then booking information is stored for that user (in the tickets
 *     collection). Purchased tickets for particular event should be stored.
 *     getPurchasedTicketsForEvent(event, dateTime) - get all purchased tickets for event for
 *     specific date and Time
 */
public interface BookingService {

  /**
   * Getting price when buying all supplied seats for particular event
   *
   * @param event Event to get base ticket price, vip seats and other information
   * @param dateTime Date and time of event air
   * @param user User that buys ticket could be needed to calculate discount. Can be <code>null
   *     </code>
   * @param seats Set of seat numbers that user wants to buy
   * @return total price
   */
  double getTicketsPrice(
      @Nonnull Event event,
      @Nonnull LocalDateTime dateTime,
      @Nullable User user,
      @Nonnull Set<Long> seats);

  /**
   * Books tickets in internal system. If user is not <code>null</code> in a ticket then booked
   * tickets are saved with it
   *
   * @param tickets Set of tickets
   */
  void bookTickets(@Nonnull Set<Ticket> tickets);

  /**
   * Getting all purchased tickets for event on specific air date and time
   *
   * @param event Event to get tickets for
   * @param dateTime Date and time of airing of event
   * @return set of all purchased tickets
   */
  @Nonnull
  Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event, @Nonnull LocalDateTime dateTime);
}
