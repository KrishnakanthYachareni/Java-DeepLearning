package ua.epam.spring.hometask;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.epam.spring.hometask.config.AppConfig;
import ua.epam.spring.hometask.dao.AuditoriumDao;

public class App2 {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.print(context.getBean("auditoriumDao",AuditoriumDao.class).getByName("PVR").getVipSeats());

    }
}
