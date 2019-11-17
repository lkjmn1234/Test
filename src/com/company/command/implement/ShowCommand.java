package com.company.command.implement;

import com.company.Service.AppService;
import com.company.command.Command;
import com.company.product.CoffeeCandy;
import com.company.product.CoffeePowder;
import com.company.product.CoffeeProduct;
import java.util.Comparator;
import java.util.List;

public class ShowCommand implements Command {

  private List<CoffeeProduct> product;
  private boolean showAll;

  public ShowCommand(List<CoffeeProduct> product, boolean showAll) {
    this.product = product;
    this.showAll = showAll;
  }

  @Override
  public void execute() {
    if (!showAll) {
      if (product != null) {
        System.out.println(product.get(0));
      } else {
        System.out.println("No product");
      }
    } else if (showAll) {
      System.out.println("Coffee Product information");
      System.out.printf(" %1$-20s ", "ID");
      System.out.printf(" %1$-40s ", "Name");
      System.out.printf(" %1$-30s ", "Quantity");
      System.out.printf(" %1$-20s ", "Other Info");
      System.out.println();
      if (product != null && product.size() > 0) {
        product.sort(Comparator.comparing(CoffeeProduct::getProductID));
        product.forEach(r -> {
          String otherInfo = "";
          if (r instanceof CoffeeCandy) {
            otherInfo =
                ((CoffeeCandy) r).getNoOfCandy() + " candy per package (" + ((CoffeeCandy) r)
                    .getCaloriesPerCandy() + " calories each) ";
          } else if (r instanceof CoffeePowder) {
            otherInfo =
                Math.round(((CoffeePowder) r).getWeight()) + "g";
          }
          System.out.printf(" %1$-20s ", r.getProductID());
          System.out.printf(" %1$-40s ", r.getName());
          System.out.printf(" %1$-30s ", r.getQty());
          System.out.printf(" %1$-20s ", otherInfo);
          System.out.println();
        });
      } else {
        System.out.println("No product");
      }
    }
  }

  @Override
  public void undo() {
    System.out.println("No Action for undo show command");
  }

  @Override
  public String getName() {
    return this.getClass().getSimpleName();
  }
}
