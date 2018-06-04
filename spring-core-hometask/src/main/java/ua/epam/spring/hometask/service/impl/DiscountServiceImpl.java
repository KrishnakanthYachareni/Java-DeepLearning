package ua.epam.spring.hometask.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.DiscountService;
import ua.epam.spring.hometask.service.impl.discount.DiscountStrategy;

import java.time.LocalDateTime;
import java.util.List;

/** @author Krishnakanth_Yachare */
@Service
public class DiscountServiceImpl implements DiscountService {

  private List<DiscountStrategy> discountStrategies;

  @Autowired
  public DiscountServiceImpl(List<DiscountStrategy> discountStrategies) {
    this.discountStrategies = discountStrategies;
  }

  /* (non-Javadoc)
   * @see ua.epam.spring.hometask.service.DiscountService#getDiscount(ua.epam.spring.hometask.domain.User, ua.epam.spring.hometask.domain.Event, java.time.LocalDateTime, long)
   */
  @Override
  public byte getDiscount(User user, Event event, LocalDateTime airDateTime, long numberOfTickets) {
    return (byte)
        discountStrategies
            .stream()
            .mapToInt(n -> n.getFlatDiscountPercent(user, event, airDateTime, numberOfTickets))
            .max()
            .orElse(0);
  }
}
