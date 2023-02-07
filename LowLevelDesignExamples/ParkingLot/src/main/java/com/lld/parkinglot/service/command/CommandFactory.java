package com.lld.parkinglot.service.command;

import com.lld.parkinglot.constants.CommandNames;
import com.lld.parkinglot.model.Command;
import com.lld.parkinglot.service.OutputPrinter;
import com.lld.parkinglot.service.ParkingLotService;
import com.lld.parkinglot.service.command.impl.*;

import static com.lld.parkinglot.constants.CommandNames.*;

public class CommandFactory {

    private final ParkingLotService parkingLotService;
    private final OutputPrinter outputPrinter;

    public CommandFactory(ParkingLotService parkingLotService, OutputPrinter outputPrinter) {
        this.parkingLotService = parkingLotService;
        this.outputPrinter = outputPrinter;
    }

    public CommandExecutable getCommandExecutorService(Command command) {

        return switch (CommandNames.getCommandName(command.getName())) {
            case PARK -> new ParkComandExecutor(parkingLotService, outputPrinter);
            case UN_PARK -> new UnParkCommandExecutor(parkingLotService, outputPrinter);
            case SLOT_BY_REG_NUM -> new SlotByRegNumCommandExecutor(parkingLotService, outputPrinter);
            case REG_NUM_BY_COLOR -> new RegNumByColorCommandExecutor(parkingLotService, outputPrinter);
            case CREATE_PARKING_LOT -> new CreateParkingLotCommandExecutor(parkingLotService, outputPrinter);
            case EXIT -> new ExitCommandExecutor(parkingLotService, outputPrinter);
            case STATUS-> new StatusCommandExecutor(parkingLotService, outputPrinter);
            default -> new ExitCommandExecutor(parkingLotService, outputPrinter);
        };
    }
}
