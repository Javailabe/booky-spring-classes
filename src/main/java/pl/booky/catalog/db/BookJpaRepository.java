package pl.booky.catalog.db;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.booky.catalog.domains.Author;
import pl.booky.catalog.domains.Book;

import java.util.List;
import java.util.Optional;

public interface BookJpaRepository extends JpaRepository <Book, Long> {
    Optional<Author> findByTitleStartsWithIgnoreCase(String title);

    @Query(
            " SELECT b FROM Book JOIN b.authors a " +
                    " WHERE " +
                    " lower(a.name) LIKE lower(concat('%', :name, '%')) "
    )
    List<Book> findBuAuthor(@Param("name") String name);
}
