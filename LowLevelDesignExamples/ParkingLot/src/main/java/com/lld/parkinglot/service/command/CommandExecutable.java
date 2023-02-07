package com.lld.parkinglot.service.command;

import com.lld.parkinglot.model.Command;
import com.lld.parkinglot.service.OutputPrinter;
import com.lld.parkinglot.service.ParkingLotService;
import lombok.Data;

@Data
public abstract class CommandExecutable {

    protected static String name;
    protected static int argsLength;
    protected ParkingLotService parkingLotService;
    protected OutputPrinter outputPrinter;

    protected CommandExecutable(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        this.parkingLotService = parkingLotService;
        this.outputPrinter = outputPrinter;
    }

    public abstract void execute(Command command);

    public boolean isValid(Command command){
        return argsLength == command.getParams().size();
    }
}
