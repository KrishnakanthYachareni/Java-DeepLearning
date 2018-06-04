package ua.epam.spring.hometask.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.domain.Ticket;

/** @author Krishnakanth_Yachare */
@Component
public class TicketDao {

  private static final Map<Long, Ticket> tickets = new HashMap<>();

  public Ticket save(Ticket ticket) {
    tickets.put(ticket.getId(), ticket);
    return ticket;
  }

  public Set<Ticket> save(Set<Ticket> tickets) {
    return tickets.stream().map(t -> this.save(t)).collect(Collectors.toSet());
  }

  public void remove(Long id) {
    tickets.remove(id);
  }

  public Ticket getById(Long id) {
    return tickets.get(id);
  }

  public Set<Ticket> getAll() {
    return tickets.values().stream().collect(Collectors.toSet());
  }
}
