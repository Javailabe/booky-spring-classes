package pl.booky.catalog.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.booky.catalog.application.port.AuthorsUseCase;
import pl.booky.catalog.db.AuthorJpaRepository;
import pl.booky.catalog.domains.Author;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorsService implements AuthorsUseCase {
    private final AuthorJpaRepository repository;

    @Override
    public List<Author> findAll() {
        return repository.findAll();
    }
}
