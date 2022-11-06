package pl.booky.catalog.application.port;

import pl.booky.catalog.domains.Author;

import java.util.List;

public interface AuthorsUseCase {

    List<Author> findAll();
}
