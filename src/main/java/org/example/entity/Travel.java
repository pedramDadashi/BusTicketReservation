package org.example.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.base.domain.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Travel extends BaseEntity<Long> {

    String source;

    String destination;

    LocalDate startDate;

    LocalTime startHour;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "travel_id")
    List<Ticket> ticketList = new ArrayList<>();

    @Override
    public String toString() {
        return "Travel{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", startDate=" + startDate +
                ", startHour=" + startHour +
                ", ticketList=" + ticketList +
                '}';
    }
}
