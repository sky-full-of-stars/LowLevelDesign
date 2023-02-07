package com.lld.parkinglot.service.mode.impl;

import com.lld.parkinglot.exceptions.InputFileException;
import com.lld.parkinglot.model.Command;
import com.lld.parkinglot.service.command.CommandFactory;
import com.lld.parkinglot.service.mode.ModeExecutable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class File extends ModeExecutable {

    public File(CommandFactory commandFactory) {
        super(commandFactory);
    }

    @Override
    public void getInput() {
        try {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
            while ((line = reader.readLine()) != null) {
                Command command = getCommandFromInputLine(line);
                executeCommand(command);
            }
            reader.close();
        }
        catch(Exception e) {
            throw new InputFileException();
        }
    }
}
