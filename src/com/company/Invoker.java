package com.company;

import com.company.command.Command;
import com.company.memo.Caretaker;
import com.company.memo.CommandMemento;
import com.company.memo.CommandOriginator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Invoker {

  private CommandOriginator commandOriginator;

  private static Invoker instance = new Invoker();
  private Caretaker<CommandMemento> caretakerNormal;
  private Caretaker<CommandMemento> caretakerReverse;

  private List<String> actionHistory;

  public static Invoker getInstance() {
    if (instance != null) {
      return instance;
    }
    return new Invoker();
  }

  public static void init() {}

  private Invoker() {
    caretakerNormal = new Caretaker<>();
    caretakerReverse = new Caretaker<>();
    commandOriginator = new CommandOriginator();
    actionHistory = new ArrayList<>();
  }

  void execute(Command command) {
    commandOriginator.setCommand(command);
    commandOriginator.getCommand().execute();
    caretakerNormal.push(commandOriginator.createMemento());
    actionHistory.add(command.getName() + " - execute");
  }

  void undo() {
    Optional<CommandMemento> targetCommand = caretakerNormal.pop();
    targetCommand.ifPresent(
        a -> {
          commandOriginator.saveMemento(a);
          commandOriginator.getCommand().undo();
          caretakerReverse.push(a);
          actionHistory.add(a.getCommand().getName() + " - undo");
        });
  }

  void redo() {
    Optional<CommandMemento> targetCommand = caretakerReverse.pop();
    targetCommand.ifPresent(
        a -> {
          commandOriginator.saveMemento(a);
          commandOriginator.getCommand().execute();
          caretakerNormal.push(a);
          actionHistory.add(a.getCommand().getName() + " - redo");
        });
  }

  List<String> getCommandHistory() {
    return actionHistory;
  }
}
