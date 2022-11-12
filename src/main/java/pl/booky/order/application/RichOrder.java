package pl.booky.order.application;

import lombok.Value;
import pl.booky.order.application.price.OrderPrice;
import pl.booky.order.domain.OrderItem;
import pl.booky.order.domain.OrderStatus;
import pl.booky.order.domain.Recipient;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Value
public class RichOrder {
    Long id;
    OrderStatus status;
    Set<OrderItem> items;
    Recipient recipient;
    LocalDateTime createdAt;
    OrderPrice orderPrice;
    BigDecimal finalPrice;
}
