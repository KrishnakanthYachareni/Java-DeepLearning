package ua.epam.spring.hometask.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.spring.hometask.dao.TicketDao;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.EventRating;
import ua.epam.spring.hometask.domain.Ticket;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.BookingService;
import ua.epam.spring.hometask.service.DiscountService;

/** @author Krishnakanth_Yachare */
@Service
public class BookingServiceImpl implements BookingService {

  private DiscountService discountService;
  private TicketDao ticketDAO;

  @Autowired
  public BookingServiceImpl(DiscountService discountService, TicketDao ticketDao) {
    this.discountService = discountService;
    this.ticketDAO = ticketDao;
  }

  /*
   * User is needed to calculate discount (see below) Event is needed to get
   * base price, rating Vip seats should cost more than regular seats (For
   * example, 2xBasePrice) All prices for high rated movies should be higher
   * (For example, 1.2xBasePrice)
   */
  @Override
  public double getTicketsPrice(Event event, LocalDateTime dateTime, User user, Set<Long> seats) {

    double basePrice = event.getBasePrice();
    double ratedPrice = event.getRating() == EventRating.HIGH ? basePrice * 1.2 : basePrice;
    double totalPrice =
        seats
            .stream()
            .mapToDouble(
                seat ->
                    event.getAuditoriums().get(dateTime).getVipSeats().contains(seat)
                        ? ratedPrice * 2
                        : ratedPrice)
            .reduce(
                0.0,
                (acc, seatPrice) -> {
                  return acc += seatPrice;
                });
    byte discount = discountService.getDiscount(user, event, dateTime, seats.size());

    return totalPrice * discount / 100;
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * ua.epam.spring.hometask.service.BookingService#bookTickets(java.util.Set)
   */
  @Override
  public void bookTickets(Set<Ticket> tickets) {
    tickets
        .stream()
        .map(
            t -> {
              Optional.of(t.getUser()).ifPresent(u -> u.getTickets().add(t));
              return t;
            });
    this.ticketDAO.save(tickets);
  }

  /*
   * (non-Javadoc)
   *
   * @see ua.epam.spring.hometask.service.BookingService#
   * getPurchasedTicketsForEvent(ua.epam.spring.hometask.domain.Event,
   * java.time.LocalDateTime)
   */
  @Override
  public Set<Ticket> getPurchasedTicketsForEvent(Event event, LocalDateTime dateTime) {
    return ticketDAO
        .getAll()
        .stream()
        .filter(t -> t.getEvent().getId() == event.getId() && t.getDateTime().isEqual(dateTime))
        .collect(Collectors.toSet());
  }
}
