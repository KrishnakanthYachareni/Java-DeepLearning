package ua.epam.spring.hometask.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import ua.epam.spring.hometask.dao.AuditoriumDao;
import ua.epam.spring.hometask.domain.Auditorium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Configuration
@ComponentScan("ua.epam.spring.hometask")
@PropertySource({"classpath:theaters.properties"})
public class AppConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    /* Auditorium One Properties */

    @Value("${theaterOne.name}")
    private String auditorium1Name;

    @Value("${theaterOne.numOfSeats}")
    private String auditorium1NumOfSeats;

    @Value("#{'${theaterOne.vipSeats}'.split(',')}")
    private Set<Long> auditorium1VipSeats;

    /* Auditorium Two Properties */

    @Value("${theaterTwo.name}")
    private String auditorium2Name;

    @Value("${theaterTwo.numOfSeats}")
    private String auditorium2NumOfSeats;

    @Value("#{'${theaterTwo.vipSeats}'.split(',')}")
    private Set<Long> auditorium2VipSeats;

    /* Auditorium Three Properties */

    @Value("${theaterThree.name}")
    private String auditorium3Name;

    @Value("${theaterThree.numOfSeats}")
    private String auditorium3NumOfSeats;

    @Value("#{'${theaterThree.vipSeats}'.split(',')}")
    private Set<Long> auditorium3VipSeats;

    @Autowired
    @Qualifier("auditoriumOne")
    private Auditorium auditoriumOne;

    @Autowired
    @Qualifier("auditoriumTwo")
    private Auditorium auditoriumTwo;

    @Autowired
    @Qualifier("auditoriumThree")
    private Auditorium auditoriumThree;

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Auditorium auditoriumOne() {
        return createAuditorium(auditorium1Name, Long.parseLong(auditorium1NumOfSeats), auditorium1VipSeats);
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Auditorium auditoriumTwo() {
        return createAuditorium(auditorium2Name, Long.parseLong(auditorium2NumOfSeats), auditorium2VipSeats);
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Auditorium auditoriumThree() {
        return createAuditorium(auditorium3Name, Long.parseLong(auditorium3NumOfSeats), auditorium3VipSeats);
    }

    public List<Auditorium> auditoriums() {
        return new ArrayList<>(Arrays.asList(auditoriumOne, auditoriumTwo, auditoriumThree));
    }

    @Bean
    public AuditoriumDao auditoriumDao() {
        return new AuditoriumDao(auditoriums());
    }

    public Auditorium createAuditorium(String name, Long seats, Set<Long> vipSeats) {
        Auditorium auditorium = new Auditorium();
        auditorium.setName(name);
        auditorium.setNumberOfSeats(seats);
        auditorium.setVipSeats(vipSeats);
        return auditorium;
    }
}
