package ua.epam.spring.hometask.service.impl.discount;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;

/**
 * @author Krishnakanth_Yachare
 *
 */
@Component
public class BirthdayDiscountStrategy implements DiscountStrategy {

    private static final int PER_DISCOUNT_PERCENT = 5;
    private static final int BEWTEEN_BIRTHDAY_DAYS = 5;

    /* (non-Javadoc)
     * @see ua.epam.spring.hometask.service.impl.discount.DiscountStrategy#getFlatDiscountPercent(ua.epam.spring.hometask.domain.User, ua.epam.spring.hometask.domain.Event, java.time.LocalDateTime, long)
     */
    @Override
    public byte getFlatDiscountPercent(User user, Event event,
            LocalDateTime airDateTime, long numberOfTickets) {

        if (user == null) {
            return 0;
        }

        LocalDate birthday = user.getBirthday().toLocalDate();
        LocalDate airDate = airDateTime.toLocalDate();
        LocalDate curBirthday = birthday.withYear(airDate.getYear());
        long between = Math.abs(ChronoUnit.DAYS.between(airDate, curBirthday));
        if (between <= BEWTEEN_BIRTHDAY_DAYS) {
            return PER_DISCOUNT_PERCENT;
        } else {
            return 0;
        }

    }

}
