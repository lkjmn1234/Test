package com.company.command.implement;

import com.company.actor.Actor;
import com.company.command.Command;

public class CreateProductCommand implements Command {

  Actor actor;

  public CreateProductCommand(Actor actor) {
    this.actor = actor;
  }

  @Override
  public void execute() {

  }

  @Override
  public void unExecute() {

  }
}
