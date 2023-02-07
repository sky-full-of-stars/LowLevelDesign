package com.lld.parkinglot.service.command.impl;

import com.lld.parkinglot.constants.CommandNames;
import com.lld.parkinglot.model.Command;
import com.lld.parkinglot.service.OutputPrinter;
import com.lld.parkinglot.service.ParkingLotService;
import com.lld.parkinglot.service.command.CommandExecutable;


public class ExitCommandExecutor extends CommandExecutable {
    public ExitCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
        name = CommandNames.EXIT.getCommandName();
        argsLength = CommandNames.EXIT.getArgsLength();
    }

    @Override
    public void execute(Command command) {
        parkingLotService.exit();
    }
}
