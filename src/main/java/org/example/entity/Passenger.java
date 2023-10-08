package org.example.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.base.domain.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Passenger extends BaseEntity<Long> {

    String firstName;
    String lastName;
    String username;
    String password;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
            @JoinColumn(name = "passenger_id")
    List<Ticket> ticketList = new ArrayList<>();

    @Override
    public String toString() {
        return "Passenger{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
