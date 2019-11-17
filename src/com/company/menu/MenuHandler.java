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
import java.util.Scanner;

public class MenuHandler {

  CaseMenu rMenu = new CaseMenu();
  boolean isValid = true;
  int countExec = 0;

  Factory productFactory = FactoryProducer.getFactory(FactoryConstant.PRODUCT);
  Factory commandFactory = FactoryProducer.getFactory(FactoryConstant.COMMAND);

  Invoker invoker = Invoker.getInstance();
  AppService appService = AppService.getInstance();

  public MenuHandler() throws Exception {
  }

  public void executeMenu() {
    do {
      countExec++;
      rMenu.displayMenu("Main");
      choiceHandler("Main");
    } while (isValid);
  }

  public void choiceHandler(String menuLevel) {
    switch (menuLevel) {
      case "Main":
        mainMenu(menuLevel, rMenu.getChoice());
        break;
      case "add product":
        createProduct(rMenu.getChoice());
        break;
      case "view products":
        showProduct(rMenu.getChoice());
        break;
      case "collect product":
        buyProduct(rMenu.getChoice());
        break;
      case "ship product":
        deliverProduct(rMenu.getChoice());
        break;
      case "undo":
        undoLastCommand();
        break;
      case "redo":
        redoLastCommand();
        break;
      case "show list undo/redo":
        displayActionList();
        break;
      default:
        System.out.println("Error in choice Handling");
    }
  }

  public void mainMenu(String menuLevel, String choice) {
    switch (choice) {
      case "x":
        System.out.println("Thanks for using Coffee Inventory Management System!!");
        isValid = false;
        break;
      case "a":
        rMenu.displayMenu("add product");
        choiceHandler("add product");
        break;
      case "v":
        rMenu.displayMenu("view products");
        choiceHandler("view products");
        break;
      case "c":
        rMenu.displayMenu("collect product");
        choiceHandler("collect product");
        break;
      case "s":
        rMenu.displayMenu("ship product");
        choiceHandler("ship product");
        break;
      case "u":
        choiceHandler("undo");
        break;
      case "r":
        choiceHandler("redo");
        break;
      case "sl":
        choiceHandler("show list undo/redo");
        break;
      default:
        System.out.println("Invalid Choice");
    }
  }

  public void createProduct(String choice) {
    switch (choice) {
      case "cc":
        System.out.println("Enter product Id, name, number of candy and calories per candy: ");
        try {
          Scanner in = new Scanner(System.in);
          CoffeeProduct candy = productFactory.produceProduct(ProductConstant.CANDY, in.nextLine());
          Command createCandy = commandFactory.produceCommand(candy, CommandConstant.CREATE, 0);
          invoker.execute(createCandy);
        } catch (Exception e) {
          System.out.println("Invalid input\n");
        }
        break;
      case "cp":
        System.out.println("Enter product Id , name and weight(g): ");
        try {
          Scanner in = new Scanner(System.in);
          CoffeeProduct powder = productFactory
              .produceProduct(ProductConstant.POWDER, in.nextLine());
          Command createPowder = commandFactory.produceCommand(powder, CommandConstant.CREATE, 0);
          invoker.execute(createPowder);
        } catch (Exception e) {
          System.out.println("Invalid input\n");
        }
        break;
      default:
        System.out.println("Invalid Choice\n");
        break;
    }
  }

  public void showProduct(String choice) {
    try {
      Command show = commandFactory
          .produceCommand(appService.searchProduct(choice),
              CommandConstant.SHOW, choice.equals("*"));
      invoker.execute(show);
    } catch (Exception e) {
      System.out.println("Invalid input\n");
    }
  }

  public void buyProduct(String choice) {
    try {
      CoffeeProduct product = appService.searchProduct(Integer.parseInt(choice));
      if (product != null) {
        System.out.println("Quantity to receive:");
        Scanner in = new Scanner(System.in);
        int qtyBuy = Integer.parseInt(in.nextLine());
        Command receive = commandFactory.produceCommand(product, CommandConstant.RECEIVE, qtyBuy);
        invoker.execute(receive);
        System.out.println(
            "Received " + qtyBuy + " packs of Premium Coffee Candy. Current quantity is " + product
                .getQty());
      } else {
        System.out.println("No product\n");
      }
    } catch (Exception e) {
      System.out.println("Invalid input\n");
    }
  }

  public void deliverProduct(String choice) {
    try {
      CoffeeProduct product = appService.searchProduct(Integer.parseInt(choice));
      if (product != null) {
        System.out.println("Quantity to ship:");
        Scanner in = new Scanner(System.in);
        int qtyDeliver = Integer.parseInt(in.nextLine());
        if (product.getQty() > qtyDeliver) {
          Command deliver = commandFactory
              .produceCommand(product, CommandConstant.DELIVER, qtyDeliver);
          invoker.execute(deliver);
          System.out.println(
              "Shipped " + qtyDeliver + " packs of Premium Coffee Candy. Current quantity is  "
                  + product.getQty());
        } else {
          System.out.println(
              "Invalid quantity (current balance is less than required quantity). Try again!!!\n");
        }

      } else {
        System.out.println("No product\n");
      }
    } catch (Exception e) {
      System.out.println("Invalid input\n");
    }
  }

  public void undoLastCommand() {
    invoker.undo();
  }

  public void redoLastCommand() {
    invoker.redo();
  }

  public void displayActionList() {
    invoker.getCommandHistory();
  }
}
