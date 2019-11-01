package com.company.command;

import com.company.actor.Actor;
import com.company.command.implement.CreateProductCommand;
import com.company.command.implement.DeliverProductCommand;
import com.company.command.implement.DisplayUndoRedoList;
import com.company.command.implement.ReceiveProductCommand;
import com.company.command.implement.RedoProductCommand;
import com.company.command.implement.ShowProductCommand;
import com.company.command.implement.UndoCommand;
import com.company.constant.CommandConstant;

public class CommandFactory {

  public Command createCommand(String commandName, Actor actor) throws Exception {
    switch (commandName) {
      case CommandConstant.CREATE:
        return new CreateProductCommand(actor);
      case CommandConstant.DELIVER:
        return new DeliverProductCommand(actor);
      case CommandConstant.SHOW:
        return new ShowProductCommand(actor);
      case CommandConstant.DISPLAY_REDO_UNDO_LIST:
        return new DisplayUndoRedoList(actor);
      case CommandConstant.RECEIVE:
        return new ReceiveProductCommand(actor);
      case CommandConstant.REDO:
        return new RedoProductCommand(actor);
      case CommandConstant.UNDO:
        return new UndoCommand(actor);
      default:
        throw new Exception(CommandConstant.NO_SUCH_COMMENT);
    }
  }
}
