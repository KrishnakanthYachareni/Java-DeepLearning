package ua.epam.spring.hometask.service.impl.discount;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;

/**
 * @author Krishnakanth_Yachare
 */
@Component
public class Every10DiscountStrategy implements DiscountStrategy {

    private static final int PER_DISCOUNT_PERCENT = 5;

    /*
     * (non-Javadoc)
     *
     * @see ua.epam.spring.hometask.service.impl.discount.DiscountStrategy#
     * getFlatDiscountPercent(ua.epam.spring.hometask.domain.User,
     * ua.epam.spring.hometask.domain.Event, java.time.LocalDateTime, long)
     */
    @Override
    public byte getFlatDiscountPercent(User user, Event event,
                                       LocalDateTime airDateTime, long numberOfTickets) {
        long discountNums = numberOfTickets / 10;
        return (byte) (discountNums * PER_DISCOUNT_PERCENT / numberOfTickets);
    }

}
