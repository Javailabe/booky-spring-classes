package pl.booky.uploads.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import pl.booky.jpa.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Upload extends BaseEntity {
    private byte[] file;
    private String contentType;
    private String fileName;

    @CreatedDate
    private LocalDateTime createdAt;

    public Upload(byte[] file, String contentType, String fileName) {
        this.file = file;
        this.contentType = contentType;
        this.fileName = fileName;
    }
}
