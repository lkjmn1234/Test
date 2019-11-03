package com.company.memo;

import com.company.command.Command;
import java.util.LinkedList;

public class CommandMemento {

  private Command command;

  public CommandMemento(Command command) {
    this.command = command;
  }

  public Command getCommand() {
    return command;
  }

  public void setCommand(Command command) {
    this.command = command;
  }
}
