package com.company.menu;

import java.util.ArrayList;
import java.util.Scanner;

public class CaseMenu {

  private ArrayList<String> menu = new ArrayList<>();
  private int choice = -1;
  Scanner in = new Scanner(System.in);

  public void setupMenu(String menuLevel) {
    switch (menuLevel) {
      case "Main":
        menu.add("Exit Program");
        menu.add("Create Prodcut");
        menu.add("Show Prodcut");
        menu.add("Buy Prodcut");
        menu.add("Deliver Prodcut");
        menu.add("Undo Last Command");
        menu.add("Redo Last Command");
        menu.add("Display Action List");
        break;
      case "Create Product":
        menu.add("Exit Program");
        menu.add("Return to Main Menu");
        menu.add("Enter Application Codes");
        break;
      case "Show Product":
        menu.add("Exit Program");
        menu.add("Return to Main Menu");
        menu.add("Enter Module Codes");
        break;
      case "Buy Product":
        menu.add("Exit Program");
        menu.add("Return to Main Menu");
        menu.add("Enter Table Codes");
        break;
      case "Deliver Product":
        menu.add("Exit Program");
        menu.add("Return to Main Menu");
        menu.add("Enter Attribute Codes");
        break;
      default:
        System.out.println("Invalid Choice");
    }
  }

  public void displayMenu(String menuLevel) {
    menu.clear();
    setupMenu(menuLevel);
    System.out.println("Coffee inventory management system");
    System.out.println("==================================");
    int i = 0;
    for (String s : menu) {
      System.out.println(i + ". " + s);
      ++i;
    }
    i = i - 1;
    System.out.println("Select an option from 0 to " + i + ":");
  }

  public int getChoice() {
    Scanner in = new Scanner(System.in);
    String inputChoice = in.nextLine();
    choice = Integer.parseInt(inputChoice);
    return choice;
  }
}
