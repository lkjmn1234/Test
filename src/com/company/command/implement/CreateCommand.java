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
    appService.addProduct(product);
  }

  @Override
  public void undo() {
    appService.removeProduct(product.getProductID());
  }

  @Override
  public String getName() {
    return this.getClass().getSimpleName();
  }
}
