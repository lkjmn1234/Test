package com.company.command;

import com.company.command.implement.CreateProductCommand;
import com.company.command.implement.DeliverProductCommand;
import com.company.command.implement.DisplayUndoRedoList;
import com.company.command.implement.ReceiveProductCommand;
import com.company.command.implement.RedoProductCommand;
import com.company.command.implement.ShowProductCommand;
import com.company.command.implement.UndoCommand;
import com.company.constant.CommandConstant;

public class CommandFactory {

  public Command createCommand(String commandName) throws Exception {
    switch (commandName) {
      case CommandConstant.CREATE:
        return new CreateProductCommand();
      case CommandConstant.DELIVER:
        return new DeliverProductCommand();
      case CommandConstant.SHOW:
        return new ShowProductCommand();
      case CommandConstant.DISPLAY_REDO_UNDO_LIST:
        return new DisplayUndoRedoList();
      case CommandConstant.RECEIVE:
        return new ReceiveProductCommand();
      case CommandConstant.REDO:
        return new RedoProductCommand();
      case CommandConstant.UNDO:
        return new UndoCommand();
      default:
        throw new Exception("no such command");
    }
  }
}
