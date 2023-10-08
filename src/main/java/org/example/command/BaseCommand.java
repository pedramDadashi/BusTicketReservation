package org.example.command;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString()
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseCommand {

    Long id;
}
