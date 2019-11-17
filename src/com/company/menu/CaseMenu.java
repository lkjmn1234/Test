package com.company.menu;

import java.util.ArrayList;
import java.util.Scanner;

public class CaseMenu {

  private String choice = "";
  Scanner in = new Scanner(System.in);

  public void setupMenu(String menuLevel) {
    switch (menuLevel) {
      case "Main":
        System.out.println("Coffee inventory management system");
        System.out.println("Please enter command: [a | v | c | s | u | r | sl | x]");
        System.out
            .println("a = add product, v = view products, c = collect product, s = ship product,");
        System.out.println("u = undo, r = redo, sl = show list undo/redo, x = exit system\n");
        break;
      case "add product":
        System.out.println("Enter Coffee type (cc=Coffee Candy/cp=Coffee Powder)");
        break;
      case "view products":
        System.out.println("Enter product Id. (* to show all):");
        break;
      case "collect product":
        System.out.println("Enter code:");
        break;
      case "ship product":
        System.out.println("Enter code:");
        break;
      default:
        System.out.println("Invalid Choice");
    }
  }

  public void displayMenu(String menuLevel) {
    setupMenu(menuLevel);
  }

  public String getChoice() {
    in = new Scanner(System.in);
    choice = in.nextLine();
    return choice;
  }
}
