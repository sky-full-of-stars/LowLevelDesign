package com.lld.parkinglot.service.command.impl;

import com.lld.parkinglot.constants.CommandNames;
import com.lld.parkinglot.model.Command;
import com.lld.parkinglot.service.OutputPrinter;
import com.lld.parkinglot.service.ParkingLotService;
import com.lld.parkinglot.service.command.CommandExecutable;

import java.util.List;

public class SlotByRegNumCommandExecutor extends CommandExecutable {

    public SlotByRegNumCommandExecutor(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
        name = CommandNames.SLOT_BY_REG_NUM.getCommandName();
        argsLength = CommandNames.SLOT_BY_REG_NUM.getArgsLength();
    }

    @Override
    public void execute(Command command) {
        List<String> args = command.getParams();
        int slotNumber = parkingLotService.getSlotByRegistrationNumber(args.get(0));
        System.out.format("Slot number for vehicle with registration num %s is %d %n", args.get(0), slotNumber);
    }

}
