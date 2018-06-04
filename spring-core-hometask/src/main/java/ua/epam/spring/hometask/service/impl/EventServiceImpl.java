package ua.epam.spring.hometask.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.spring.hometask.dao.EventDao;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.service.EventService;

/*
 * getForDateRange(from, to) - returns events for specified date range
 * (OPTIONAL) getNextEvents(to) - returns events from now till the ‘to’ date
 * (OPTIONAL)
 */

/** @author Krishnakanth_Yachare */
@Service
public class EventServiceImpl implements EventService {

  private EventDao eventDao;

  @Autowired
  public EventServiceImpl(EventDao eventDao) {
    this.eventDao = eventDao;
  }

  @Override
  public Event save(Event e) {
    return this.eventDao.save(e);
  }

  @Override
  public void remove(Event e) {
    this.eventDao.remove(e);
  }

  @Override
  public Event getById(Long id) {
    return this.eventDao.getById(id);
  }

  @Override
  public Collection<Event> getAll() {
    return this.eventDao.getAll();
  }

  @Override
  public Event getByName(String name) {
    return this.eventDao.getByName(name);
  }

  @Override
  public Set<Event> getForDateRange(LocalDate from, LocalDate to) {
    return this.eventDao.getForDateRange(from, to);
  }

  /*
   * Optional for implementation
   */
  @Override
  public Set<Event> getNextEvents(LocalDateTime to) {
    return null;
  }
}
