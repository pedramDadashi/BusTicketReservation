package org.example.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.base.domain.BaseEntity;
import org.example.entity.enums.Gender;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket extends BaseEntity<Long> {

    @ManyToOne
    Passenger passenger;
    String firstName;
    String lastName;
    @Enumerated
    Gender passengerGender;

    @ManyToOne
    Travel travel;

    @Override
    public String toString() {
        return "Ticket{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passengerGender=" + passengerGender +
                ", travel=" + travel +
                '}';
    }
}
