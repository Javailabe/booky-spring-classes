package pl.booky.order.domain;

import lombok.*;
import pl.booky.jpa.BaseEntity;

import javax.persistence.Entity;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recipient extends BaseEntity {
    private String email;
    private String name;
    private String phone;
    private String street;
    private String city;
    private String zipCode;
}
