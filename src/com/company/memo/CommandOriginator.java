package com.company.memo;

import com.company.command.Command;

public class CommandOriginator {

  private Command command;

  public CommandOriginator() {
  }

  public CommandOriginator(Command command) {
    this.command = command;
  }

  public Command getCommand() {
    return command;
  }

  public void setCommand(Command command) {
    this.command = command;
  }

  public void saveMemento(CommandMemento commandMemento) {
    this.command = commandMemento.getCommand();
  }

  public CommandMemento createMemento() {
    return new CommandMemento(command);
  }
}
