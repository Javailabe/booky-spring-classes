package pl.booky.order.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.booky.order.application.port.QueryOrderUseCase;
import pl.booky.order.application.price.OrderPrice;
import pl.booky.order.application.price.PriceService;
import pl.booky.order.db.OrderJpaRepository;
import pl.booky.order.domain.Order;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QueryOrderService implements QueryOrderUseCase {
    private final OrderJpaRepository repository;
    private final PriceService priceService;

    @Transactional
    public List<RichOrder> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toRichOrder)
                .collect(Collectors.toList());
    }

    @Transactional
    public Optional<RichOrder> findById(Long id) {
        return repository.findById(id)
                .map(this::toRichOrder);
    }

    private RichOrder toRichOrder(Order order) {
        OrderPrice orderPrice = priceService.calculatePrice(order);
        return new RichOrder(
                order.getId(),
                order.getStatus(),
                order.getItems(),
                order.getRecipient(),
                order.getCreateAt(),
                orderPrice,
                orderPrice.finalPrice()
        );
    }
}
