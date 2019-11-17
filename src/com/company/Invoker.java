package com.company;

import com.company.command.Command;
import com.company.command.implement.ShowCommand;
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

  public static Invoker getInstance() {
    if (instance != null) {
      return instance;
    }
    return new Invoker();
  }

  public static void init() {
  }

  private Invoker() {
    caretakerNormal = new Caretaker<>();
    caretakerReverse = new Caretaker<>();
    commandOriginator = new CommandOriginator();
  }

  public void execute(Command command) throws Exception {
    commandOriginator.setCommand(command);
    commandOriginator.getCommand().execute();
    if (!(command instanceof ShowCommand)) {
      caretakerReverse.push(commandOriginator.createMemento());
    }
  }

  public void undo() {
    Optional<CommandMemento> targetCommand = caretakerReverse.pop();
    targetCommand.ifPresent(
        a -> {
          commandOriginator.saveMemento(a);
          commandOriginator.getCommand().undo();
          caretakerNormal.push(a);
        });
    System.out.println("undo completed.");
  }

  public void redo() {
    Optional<CommandMemento> targetCommand = caretakerNormal.pop();
    targetCommand.ifPresent(
        a -> {
          commandOriginator.saveMemento(a);
          try {
            commandOriginator.getCommand().execute();
          } catch (Exception e) {
            e.printStackTrace();
          }
          caretakerReverse.push(a);
        });
    System.out.println("redo completed.");
  }

  public void clear() {
    caretakerNormal = new Caretaker<>();
    caretakerReverse = new Caretaker<>();
  }

  public void getCommandHistory() {
    System.out.println("Undo List:");
    if (caretakerReverse.getMemento().size() > 0) {
      caretakerReverse.getMemento().forEach(m -> {
        System.out.println(m.getCommand().getName());
      });
    } else {
      System.out.println("Empty\n");
    }
    System.out.println();
    System.out.println("Redo List:");
    if (caretakerNormal.getMemento().size() > 0) {
      caretakerNormal.getMemento().forEach(m -> {
        System.out.println(m.getCommand().getName());
      });
    } else {
      System.out.println("Empty\n");
    }
  }
}
