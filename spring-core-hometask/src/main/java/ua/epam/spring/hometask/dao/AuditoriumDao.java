package ua.epam.spring.hometask.dao;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.domain.Auditorium;

/**
 * This is class has a DAO methods to get the Auditorium/Theater by name or All the Auditorium.
 *
 * @author Krishnakanth_Yachare
 */
@Component
public class AuditoriumDao {

  private List<Auditorium> auditoriums;

  @Autowired
  public AuditoriumDao(List<Auditorium> auditoriums) {
    this.auditoriums = auditoriums;
  }

  /**
   * This method can return the requested Auditorium based on given String.
   *
   * @param name String which indicates the One of Auditorium to search.
   * @return Auditorium Object.
   */
  public Auditorium getByName(String name) {
    return Optional.of(auditoriums).isPresent()
        ? auditoriums
            .stream()
            .filter(a -> a.getName().equalsIgnoreCase(name))
            .findFirst()
            .orElse(null)
        : null;
  }

  /** @return Auditorium Set. */
  public Set<Auditorium> getAll() {
    return auditoriums.stream().collect(Collectors.toSet());
  }
}
