package com.company.command.implement;

import com.company.actor.Actor;
import com.company.command.Command;

public class DeliverProductCommand implements Command {

  Actor actor;

  public DeliverProductCommand(Actor actor) {
    this.actor = actor;
  }

  @Override
  public void execute() {

  }

  @Override
  public void unExecute() {

  }
}
