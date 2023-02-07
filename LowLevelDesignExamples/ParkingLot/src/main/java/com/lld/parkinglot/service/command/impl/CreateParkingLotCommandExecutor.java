package com.lld.parkinglot.service.command.impl;

import com.lld.parkinglot.constants.CommandNames;
import com.lld.parkinglot.model.Command;
import com.lld.parkinglot.model.ParkingLot;
import com.lld.parkinglot.service.OutputPrinter;
import com.lld.parkinglot.service.ParkingLotService;
import com.lld.parkinglot.service.command.CommandExecutable;
import com.lld.parkinglot.strategy.impl.NaturalOrder;

import java.util.ArrayList;
import java.util.List;

public class CreateParkingLotCommandExecutor extends CommandExecutable {

    public CreateParkingLotCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
        name = CommandNames.CREATE_PARKING_LOT.getCommandName();
        argsLength = CommandNames.CREATE_PARKING_LOT.getArgsLength();
    }

    @Override
    public void execute(Command command) {
        List<String> args = command.getParams();
        ParkingLot parkingLot = new ParkingLot(1, "best design parking lot", Integer.parseInt(args.get(0)), new ArrayList<>());
        parkingLotService.createParkingLot(parkingLot, new NaturalOrder());
    }

}
