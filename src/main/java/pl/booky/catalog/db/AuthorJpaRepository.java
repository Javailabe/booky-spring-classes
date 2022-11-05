package pl.booky.catalog.db;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.booky.catalog.domains.Author;

import java.util.Optional;

public interface AuthorJpaRepository extends JpaRepository <Author, Long> {
    Optional<Author> findByNameIgnoreCase(String name);
}
