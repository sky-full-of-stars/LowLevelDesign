package com.lld.parkinglot.service.command.impl;

import com.lld.parkinglot.constants.CommandNames;
import com.lld.parkinglot.model.Command;
import com.lld.parkinglot.service.OutputPrinter;
import com.lld.parkinglot.service.ParkingLotService;
import com.lld.parkinglot.service.command.CommandExecutable;

import java.util.List;

public class ParkComandExecutor extends CommandExecutable {

    public ParkComandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
        name = CommandNames.PARK.getCommandName();
        argsLength = CommandNames.PARK.getArgsLength();
    }

    @Override
    public void execute(Command command) {
        List<String> args = command.getParams();
        parkingLotService.park(args.get(0), args.get(1));
    }

}
