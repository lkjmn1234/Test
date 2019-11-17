package com.company.command.implement;

import com.company.Service.AppService;
import com.company.command.Command;
import com.company.product.CoffeeProduct;

public class CreateCommand implements Command {

  private CoffeeProduct product;
  private AppService appService = AppService.getInstance();

  public CreateCommand(CoffeeProduct product) throws Exception {
    if (product == null) {
      throw new Exception("product cannot null");
    }
    this.product = product;
  }

  @Override
  public void execute() {
    if (appService.searchProduct(product.getProductID()) == null) {
      appService.addProduct(product);
      System.out.println("New product record created.\n");
    } else {
      System.out.println("Product already created\n");
    }
  }

  @Override
  public void undo() {
    appService.removeProduct(product);
  }

  @Override
  public String getName() {
    return "Add " + product.getProductID() + " " + product.getName();
  }
}
