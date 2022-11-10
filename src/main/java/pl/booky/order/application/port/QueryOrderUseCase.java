package pl.booky.order.application.port;

import java.util.Optional;

public interface QueryOrderUseCase {

    List<RichOrder> finadAll();

    Optional<RichOrder> findById(Long id);
}
