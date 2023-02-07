package com.lld.parkinglot.service.command.impl;

import com.lld.parkinglot.constants.CommandNames;
import com.lld.parkinglot.model.Command;
import com.lld.parkinglot.service.OutputPrinter;
import com.lld.parkinglot.service.ParkingLotService;
import com.lld.parkinglot.service.command.CommandExecutable;

import java.util.List;

public class StatusCommandExecutor extends CommandExecutable {

    public StatusCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
        name = CommandNames.STATUS.getCommandName();
        argsLength = CommandNames.STATUS.getArgsLength();
    }

    @Override
    public void execute(Command command) {
        parkingLotService.status();
    }
}
