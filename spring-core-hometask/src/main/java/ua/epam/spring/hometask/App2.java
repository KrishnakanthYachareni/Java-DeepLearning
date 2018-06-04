package ua.epam.spring.hometask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.epam.spring.hometask.config.AppConfig;
import ua.epam.spring.hometask.dao.AuditoriumDao;
import ua.epam.spring.hometask.dao.EventDao;

public class App2 {

  @Autowired private AuditoriumDao auditoriumDao;

  public static void main(String[] args) {
    ConfigurableApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);
    System.out.println(
        context.getBean("auditoriumDao", AuditoriumDao.class).getByName("PVR").getVipSeats());
    System.out.println(context.getBean("eventDao", EventDao.class));
  }
}
