package com.company;

import com.company.command.Command;
import com.company.command.implement.UndoCommand;
import java.util.LinkedList;

public class Invoker {

  private LinkedList<Command> orders = new LinkedList<>();
  private LinkedList<Command> history = new LinkedList<>();

  public void addOrder(Command command) {
    orders.add(command);
  }

  public void cancelOrder(Command command) {
    orders.remove(command);
  }

  public void sendOrders() {

    while (!orders.isEmpty()) {
      Command cmd = orders.poll();
      cmd.execute();
    }
  }
}
