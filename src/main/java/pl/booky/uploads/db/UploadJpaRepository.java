package pl.booky.uploads.db;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.booky.uploads.domain.Upload;

public interface UploadJpaRepository extends JpaRepository<Upload, Long> {
}
