package com.company.menu;

public class MenuHandler {
  CaseMenu rMenu = new CaseMenu();
  boolean isValid = true;
  int countExec = 0;

  public void executeMenu() {
    do {
      countExec++;
      System.out.println("Execute Menu = [Main] ");
      rMenu.displayMenu("Main");
      choiceHandler("Main");
    } while (isValid);
  }

  public void choiceHandler(String menuLevel) {
    switch (menuLevel) {
      case "Main":
        mainMenu(menuLevel, rMenu.getChoice());
        break;
      case "Create Product":
        createProduct(menuLevel, rMenu.getChoice());
        break;
      case "Show Product":
        showProduct(rMenu.getChoice());
        break;
      case "Buy Product":
        buyProduct(rMenu.getChoice());
        break;
      case "Deliver Product":
        deliverProduct(rMenu.getChoice());
        break;
      case "Undo Last Command":
        undoLastCommand();
        break;
      case "Redo Last Command":
        redoLastCommand();
        break;
      case "Display Action List":
        displayActionList();
        break;
      default:
        isValid = false;
        System.out.println("Error in choice Handling");
    }
  }

  public void mainMenu(String menuLevel, int choice) {
    switch (choice) {
      case 0:
        System.out.println("Exiting Program");
        isValid = false;
        break;
      case 1:
        rMenu.displayMenu("Create Product");
        choiceHandler("Create Product");
        break;
      case 2:
        rMenu.displayMenu("Show Product");
        choiceHandler("Show Product");
        break;
      case 3:
        rMenu.displayMenu("Buy Product");
        choiceHandler("Buy Product");
        break;
      case 4:
        rMenu.displayMenu("Deliver Product");
        choiceHandler("Deliver Product");
        break;
      case 5:
        choiceHandler("Undo Last Command");
        break;
      case 6:
        choiceHandler("Redo Last Command");
        break;
      case 7:
        choiceHandler("Display Action List");
        break;
      default:
        System.out.println("Invalid Choice");
    }
  }

  public void createProduct(String menuLevel, int choice) {
    switch (choice) {
      case 0:
        System.out.println("Exiting Program");
        isValid = false;
        break;
      case 1:
        menuLevel = "Main";
        System.out.println("Applications option 1");
        rMenu.displayMenu(menuLevel);
        choiceHandler("Main");
        break;
      case 2:
        break;
      case 3:
        break;
      default:
        isValid = false;
        System.out.println("Invalid Choice");
        break;
    }
  }

  public void showProduct(int choice) {
    switch (choice) {
      case 0:
        System.out.println("Exiting Program");
        isValid = false;
        break;
      case 1:
        System.out.println("Now in Modules");
        rMenu.displayMenu("Main");
        choiceHandler("Main");
        break;
      case 2:
        System.out.println("Sub Routine to enter Module Codes");
        isValid = false;
        break;
      case 3:
        break;
      default:
        isValid = false;
        System.out.println("Invalid Choice");
        break;
    }
  }

  public void buyProduct(int choice) {
    switch (choice) {
      case 0:
        System.out.println("Exiting Program");
        isValid = false;
        break;
      case 1:
        rMenu.displayMenu("Main");
        choiceHandler("Main");
        break;
      case 2:
        System.out.println("Sub Routine to enter Table Codes");
        isValid = false;
        break;
      case 3:
        break;
      default:
        isValid = false;
        System.out.println("Invalid Choice");
        break;
    }
  }

  public void deliverProduct(int choice) {
    switch (choice) {
      case 0:
        System.out.println("Exiting Program");
        isValid = false;
        break;
      case 1:
        rMenu.displayMenu("Main");
        choiceHandler("Main");
        break;
      case 2:
        System.out.println("Sub Routine to enter Attribute Codes");
        isValid = false;
        break;
      case 3:
        break;
      default:
        isValid = false;
        System.out.println("Invalid Choice");
        break;
    }
  }

  public void undoLastCommand() {
    isValid = true;
  }

  public void redoLastCommand() {
    isValid = true;
  }

  public void displayActionList() {
    isValid = true;
  }
}
