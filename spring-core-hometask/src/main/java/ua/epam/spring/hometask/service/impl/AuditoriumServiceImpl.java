package ua.epam.spring.hometask.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.spring.hometask.dao.AuditoriumDao;
import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.service.AuditoriumService;

import java.util.Set;

/** @author Krishnakanth_Yachare */
@Service
public class AuditoriumServiceImpl implements AuditoriumService {

  private AuditoriumDao auditoriumDAO;

  @Autowired
  public AuditoriumServiceImpl(AuditoriumDao auditoriumDao) {
    this.auditoriumDAO = auditoriumDao;
  }

  /*
   * (non-Javadoc)
   *
   * @see ua.epam.spring.hometask.service.AuditoriumService#getAll()
   */
  @Override
  public Set<Auditorium> getAll() {
    return auditoriumDAO.getAll();
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * ua.epam.spring.hometask.service.AuditoriumService#getByName(java.lang.
   * String)
   */
  @Override
  public Auditorium getByName(String name) {
    return auditoriumDAO.getByName(name);
  }
}
