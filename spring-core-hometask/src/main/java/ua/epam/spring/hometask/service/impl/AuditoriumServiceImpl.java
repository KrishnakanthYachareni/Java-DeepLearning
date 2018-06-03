package ua.epam.spring.hometask.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.dao.AuditoriumDao;
import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.service.AuditoriumService;

/**
 * @author Krishnakanth_Yachare
 */
@Component
public class AuditoriumServiceImpl implements AuditoriumService {


    private AuditoriumDao auditoriumDAO;

    @Autowired
    public AuditoriumServiceImpl(AuditoriumDao auditoriumDAO) {
        this.auditoriumDAO = auditoriumDAO;
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
