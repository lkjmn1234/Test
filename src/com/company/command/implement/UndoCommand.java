package com.company.command.implement;

import com.company.actor.Actor;
import com.company.command.Command;

public class UndoCommand implements Command {

  Actor actor;

  public UndoCommand(Actor actor) {
    this.actor = actor;
  }

  @Override
  public void execute() {

  }

  @Override
  public void unExecute() {

  }
}
