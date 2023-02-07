package com.lld.parkinglot.service.mode;

import com.lld.parkinglot.exceptions.BadCommandException;
import com.lld.parkinglot.model.Command;
import com.lld.parkinglot.service.command.CommandExecutable;
import com.lld.parkinglot.service.command.CommandFactory;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ModeExecutable {
    protected static final String SPACE = " ";
    protected CommandFactory commandFactory;

    protected ModeExecutable(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public abstract void getInput();

    protected Command getCommandFromInputLine(String commandLine) {
        List<String> args = Arrays.stream(commandLine.trim().split(SPACE)).map(String::trim).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(args)) {
            throw new BadCommandException();
        }
        String commandName = args.get(0);
        args.remove(0);

        return new Command(commandName, args);
    }

    protected void executeCommand(Command command) {
        CommandExecutable commandExecutor = commandFactory.getCommandExecutorService(command);
        if(commandExecutor.isValid(command)) {
            commandExecutor.execute(command);
        }
        else {
            throw new BadCommandException();
        }
    }
}
