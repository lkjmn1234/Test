package com.company;

public class OperationMenu {

  private static final String EXIT = "Input 0 to Exit the System.";
  public static final String ADD = "Input 1 to Add new Product.";
  public static final String SHOW = "Input 2 to Show Product.";
  public static final String BUY = "Input 3 to Buy Product.";
  public static final String DELIVER = "Input 4 to Deliver Product.";
  public static final String REDO = "Input 5 to Redo.";
  public static final String UNDO = "Input 6 to Undo.";
  public static final String SHOW_REDO_UNDO = "Input 7 to Show undo/redo list.";

  private static final String[] cmdOrder = {EXIT, OperationMenu.ADD,
      OperationMenu.SHOW, OperationMenu.BUY, OperationMenu.DELIVER, OperationMenu.REDO,
      OperationMenu.UNDO, OperationMenu.SHOW_REDO_UNDO};

  private String[] menuCombination;


  public void display() {
    String menu = "";

    for (int i = 0; i < menuCombination.length; i++) {
      int num = i + 1;
      menu += (num + ". ");
      menu += menuCombination[i];
    }

    menu += EXIT;

    System.out.println(menu);
  }

  public boolean handleInput(String s) {
    int option = Integer.parseInt(s) - 1;
    boolean contineueLoop = false;

    if (option != -1) {
      int commandIndex = -1;
      for (int i = 0; i < cmdOrder.length; i++) {
        if ((cmdOrder[i]).equals(menuCombination[option])) {
          commandIndex = i;
          break;
        }
      }
    }

    return contineueLoop;
  }
}
