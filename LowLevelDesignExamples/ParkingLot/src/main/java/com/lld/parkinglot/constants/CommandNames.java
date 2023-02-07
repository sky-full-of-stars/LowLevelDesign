package com.lld.parkinglot.constants;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

public enum CommandNames {
    PARK("park", 2),
    UN_PARK("un_park", 1),
    REG_NUM_BY_COLOR("reg_num_by_color", 1),
    CREATE_PARKING_LOT("create_parking_lot", 1),
    EXIT("exit",0),
    SLOT_BY_REG_NUM("slot_by_reg_num", 1),
    STATUS("status",0);

    @Getter
    String commandName;
    @Getter
    int argsLength;

    CommandNames(String commandName, int argsLength) {
        this.commandName = commandName;
        this.argsLength = argsLength;
    }

    public static CommandNames getCommandName(String name) {
        Optional<CommandNames> command = Arrays.stream(values()).filter(v -> v.getCommandName().equalsIgnoreCase(name)).findFirst();
        return command.orElse(null);
    }

}
