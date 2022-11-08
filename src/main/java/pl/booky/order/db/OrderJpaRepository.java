package pl.booky.order.db;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.booky.order.domain.Order;
import pl.booky.order.domain.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderJpaRepository extends JpaRepository<Order, Long> {

    List<Order> findByStatusAndCreatedAtLessThanEqual(OrderStatus status, LocalDateTime timestamp);
}
