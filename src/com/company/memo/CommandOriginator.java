package com.company.memo;

import com.company.command.Command;
import java.util.LinkedList;

public class Originator {

  private Command command;

  public Originator() {
  }

  public Originator(Command command) {
    this.command = command;
  }

  public void setMemento(Memento<Command> memento) {
    this.command = memento.getMemo();
  }

  public Memento<Command> createMemento() {
    return new Memento(command);
  }
}
