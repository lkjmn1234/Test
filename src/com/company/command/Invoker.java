package com.company.command;

import java.util.LinkedList;

public class Invoker {

  private LinkedList<Command> orders = new LinkedList<>();

  public void addOrder(Command command) {
    orders.offer(command);
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
