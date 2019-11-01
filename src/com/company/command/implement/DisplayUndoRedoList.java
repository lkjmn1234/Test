package com.company.command.implement;

import com.company.actor.Actor;
import com.company.command.Command;

public class DisplayUndoRedoList implements Command {

  Actor actor;

  public DisplayUndoRedoList(Actor actor) {
    this.actor = actor;
  }

  @Override
  public void execute() {

  }

  @Override
  public void unExecute() {

  }
}
