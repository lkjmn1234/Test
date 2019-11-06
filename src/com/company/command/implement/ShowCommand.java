package com.company.command.implement;

import com.company.Service.AppService;
import com.company.command.Command;
import com.company.product.CoffeeProduct;

public class ShowCommand implements Command {

  private CoffeeProduct product;
  private AppService appService = AppService.getInstance();

  public ShowCommand(CoffeeProduct product) {
    this.product = product;
  }

  @Override
  public void execute() {
    appService.searchProduct(product.getProductID());
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
