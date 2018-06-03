package ua.epam.spring.hometask.service;

import java.time.LocalDateTime;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;

/**
 * @author Yuriy_Tkach
 * 
 * 
 DiscountService - Counts different discounts for purchased tickets

getDiscount(user, event, dateTime, numberOfTickets) - 
returns total discount (from 0 to 100) that can be applied to the user buying specified number of tickets for specific event and air dateTime
DiscountStrategy - single class with logic for calculating discount
   Birthday strategy - give 5% if user has birthday within 5 days of air date
   Every 10th ticket - give 50% for every 10th ticket purchased by user. 
   This strategy can also be applied for not-registered users if 10 or more tickets are bought
All discount strategies should be injected as list into the DiscountService. 
The getDiscount method will execute each strategy to get max available discount. Discounts should not add up. 
So, if one strategy returns 20% and another 30%, final discount would be 30%.
Define DiscountService with all strategies as separate beans in separate XML configuration
 * 
 * 
 * 
 * 
 * 
 * 
 */
public interface DiscountService {

    /**
     * Getting discount based on some rules for user that buys some number of
     * tickets for the specific date time of the event
     * 
     * @param user
     *            User that buys tickets. Can be <code>null</code>
     * @param event
     *            Event that tickets are bought for
     * @param airDateTime
     *            The date and time event will be aired
     * @param numberOfTickets
     *            Number of tickets that user buys
     * @return discount value from 0 to 100
     */
    byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets);

}
