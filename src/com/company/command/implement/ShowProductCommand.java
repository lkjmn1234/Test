package com.company.command.implement;

import com.company.actor.Actor;
import com.company.command.Command;

public class ShowProductCommand implements Command {

  Actor actor;

  public ShowProductCommand(Actor actor) {
    this.actor = actor;
  }

  @Override
  public void execute() {

  }

  @Override
  public void unExecute() {

  }
}
