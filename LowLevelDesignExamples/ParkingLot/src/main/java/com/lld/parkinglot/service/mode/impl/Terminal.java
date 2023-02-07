package com.lld.parkinglot.service.mode.impl;

import com.lld.parkinglot.exceptions.BadCommandException;
import com.lld.parkinglot.model.Command;
import com.lld.parkinglot.service.command.CommandExecutable;
import com.lld.parkinglot.service.command.CommandFactory;
import com.lld.parkinglot.service.mode.ModeExecutable;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Terminal extends ModeExecutable {

    public Terminal(CommandFactory commandFactory) {
        super(commandFactory);
    }

    @Override
    public void getInput() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String commandLine = sc.nextLine();
            Command command = getCommandFromInputLine(commandLine);
            executeCommand(command);
        }
    }


}
