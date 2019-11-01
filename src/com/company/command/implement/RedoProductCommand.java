package com.company.command.implement;

import com.company.actor.Actor;
import com.company.command.Command;

public class RedoProductCommand implements Command {

  Actor actor;

  public RedoProductCommand(Actor actor) {
    this.actor = actor;
  }

  public void execute() {

  }

  public void unExecute() {

  }
}
