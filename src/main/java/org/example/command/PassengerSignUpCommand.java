package org.example.command;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.entity.Ticket;
import org.example.entity.enums.Gender;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString()
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PassengerSignUpCommand extends BaseCommand {

    String firstName;

    String lastName;

    String username;

    String password;

    Gender gender;

    List<Ticket> ticketList = new ArrayList<>();
}
