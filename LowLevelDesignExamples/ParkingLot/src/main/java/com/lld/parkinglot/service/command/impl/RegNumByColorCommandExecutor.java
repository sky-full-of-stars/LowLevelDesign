package com.lld.parkinglot.service.command.impl;

import com.lld.parkinglot.constants.CommandNames;
import com.lld.parkinglot.enums.Color;
import com.lld.parkinglot.model.Command;
import com.lld.parkinglot.service.OutputPrinter;
import com.lld.parkinglot.service.ParkingLotService;
import com.lld.parkinglot.service.command.CommandExecutable;

import java.util.List;

public class RegNumByColorCommandExecutor extends CommandExecutable {

    public RegNumByColorCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
        name = CommandNames.REG_NUM_BY_COLOR.getCommandName();
        argsLength = CommandNames.REG_NUM_BY_COLOR.getArgsLength();
    }

    @Override
    public void execute(Command command) {
        List<String> args = command.getParams();
        parkingLotService.regNumByColor(Color.getColor(args.get(0)));
    }

}
