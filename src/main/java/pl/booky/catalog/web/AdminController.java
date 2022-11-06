package pl.booky.catalog.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.booky.catalog.application.port.CatalogInitializerUseCase;

@Slf4j
@RestController
@RequestMapping("/admin")
@Secured("ROLE_ADMIN")
@AllArgsConstructor
public class AdminController {
    private final CatalogInitializerUseCase initializer;

    public void initialize() {
        initializer.initialize();
    }
}
