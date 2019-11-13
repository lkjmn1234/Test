package com.company.menu;

import com.company.Invoker;
import com.company.Service.AppService;
import com.company.command.Command;
import com.company.constant.CommandConstant;
import com.company.constant.FactoryConstant;
import com.company.constant.ProductConstant;
import com.company.factory.Factory;
import com.company.factory.FactoryProducer;
import com.company.product.CoffeeProduct;

public class MenuHandler {
  CaseMenu rMenu = new CaseMenu();
  boolean isValid = true;
  int countExec = 0;

  Factory productFactory = FactoryProducer.getFactory(FactoryConstant.PRODUCT);
  Factory commandFactory = FactoryProducer.getFactory(FactoryConstant.COMMAND);

  CoffeeProduct candy = productFactory.produceProduct(ProductConstant.CANDY);
  CoffeeProduct powder = productFactory.produceProduct(ProductConstant.POWDER);
  CoffeeProduct base = productFactory.produceProduct(ProductConstant.DEFAULT);

  Command createCandy = commandFactory.produceCommand(candy, CommandConstant.CREATE);
  Command createPowder = commandFactory.produceCommand(powder, CommandConstant.CREATE);
  Command deliverCandy = commandFactory.produceCommand(candy, CommandConstant.DELIVER);
  Command deliverPowder = commandFactory.produceCommand(powder, CommandConstant.DELIVER);
  Command receiveCandy = commandFactory.produceCommand(candy, CommandConstant.RECEIVE);
  Command receivePowder = commandFactory.produceCommand(powder, CommandConstant.RECEIVE);
  Command showCandy = commandFactory.produceCommand(candy, CommandConstant.SHOW);
  Command showPowder = commandFactory.produceCommand(powder, CommandConstant.SHOW);
  Command showAll = commandFactory.produceCommand(base, CommandConstant.SHOW);

  Invoker invoker = Invoker.getInstance();
  AppService appService = AppService.getInstance();

  public MenuHandler() throws Exception {}

  public void executeMenu() {
    do {
      countExec++;
      System.out.println("\n\nExecute Menu = [Main] ");
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
        invoker.execute(createCandy);
        break;
      case 3:
        invoker.execute(createPowder);
        break;
      default:
        isValid = false;
        System.out.println("Invalid Choice");
        break;
    }
  }

  public void showProduct(int choice) {
    switch (choice) {
      case -1:
        invoker.execute(showAll);
        break;
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
        invoker.execute(showCandy);
        break;
      case 3:
        invoker.execute(showPowder);
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
        invoker.execute(receiveCandy);
        break;
      case 3:
        invoker.execute(receivePowder);
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
        invoker.execute(deliverCandy);
        break;
      case 3:
        invoker.execute(deliverPowder);
        break;
      default:
        isValid = false;
        System.out.println("Invalid Choice");
        break;
    }
  }

  public void undoLastCommand() {
    invoker.undo();
  }

  public void redoLastCommand() {
    invoker.redo();
  }

  public void displayActionList() {
    System.out.println(invoker.getCommandHistory());
  }
}
