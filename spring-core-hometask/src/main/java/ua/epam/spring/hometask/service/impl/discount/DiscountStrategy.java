package ua.epam.spring.hometask.service.impl.discount;

import java.time.LocalDateTime;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;

/**
 * @author Krishnakanth_Yachare
 *
 */
public interface DiscountStrategy {
	byte getFlatDiscountPercent(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets);
}
