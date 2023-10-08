package org.example.converter;

import org.example.base.domain.BaseEntity;
import org.example.command.BaseCommand;

public interface BaseConverter <C extends BaseCommand, E extends BaseEntity<Long>>{
    E convert(C c);
}
