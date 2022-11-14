package pl.booky.users.db;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.booky.users.domain.UserEntity;

import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsernameIgnoreCase(String username);
}
