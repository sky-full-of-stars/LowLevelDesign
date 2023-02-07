package com.lld.parkinglot.service.command.impl;

import com.lld.parkinglot.constants.CommandNames;
import com.lld.parkinglot.model.Command;
import com.lld.parkinglot.service.OutputPrinter;
import com.lld.parkinglot.service.ParkingLotService;
import com.lld.parkinglot.service.command.CommandExecutable;

import java.util.List;

public class UnParkCommandExecutor extends CommandExecutable {

    public UnParkCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
        name = CommandNames.UN_PARK.getCommandName();
        argsLength = CommandNames.UN_PARK.getArgsLength();
    }

    @Override
    public void execute(Command command) {
        List<String> args = command.getParams();
        parkingLotService.unPark(args.get(0));
    }
}
