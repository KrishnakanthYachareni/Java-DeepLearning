package ua.epam.spring.hometask;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.service.AuditoriumService;
import ua.epam.spring.hometask.service.BookingService;
import ua.epam.spring.hometask.service.EventService;
import ua.epam.spring.hometask.service.UserService;

/** @author Krishnakanth_Yachare */
public class App {

  private UserService userService;
  private EventService eventService;
  private BookingService bookingService;
  private AuditoriumService auditoriumService;

  public App(
      UserService userService,
      EventService eventService,
      BookingService bookingService,
      AuditoriumService auditoriumService) {
    this.userService = userService;
    this.eventService = eventService;
    this.bookingService = bookingService;
    this.auditoriumService = auditoriumService;
  }

  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring.xml");
    App app = ctx.getBean("app", App.class);
    Set<Auditorium> set = app.auditoriumService.getAll();

    set.stream().forEach(audi -> System.out.println(audi.getName()));

    // Closing application context
    ((ClassPathXmlApplicationContext) ctx).close();
  }
}
