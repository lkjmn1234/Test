package com.company.command.implement;

import com.company.Service.AppService;
import com.company.command.Command;
import com.company.product.CoffeeProduct;

public class CreateCommand implements Command {

  private CoffeeProduct product;
  private AppService appService = AppService.getInstance();

  public CreateCommand(CoffeeProduct product) {
    this.product = product;
  }

  @Override
  public void execute() {
    if (appService.searchProduct(product.getProductID()).size() == 0) {
      appService.addProduct(product);
      System.out.println("CreateCommand executed");
    }
    else
    {
      System.out.println("Product already created");
    }
  }

  @Override
  public void undo() {
    appService.removeProduct(product);
    System.out.println("CreateCommand undo");
  }

  @Override
  public String getName() {
    return this.getClass().getSimpleName();
  }
}
