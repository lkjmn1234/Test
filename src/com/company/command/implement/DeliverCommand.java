package com.company.command.implement;

import com.company.Service.AppService;
import com.company.command.Command;
import com.company.product.CoffeeProduct;

public class DeliverCommand implements Command {

  private CoffeeProduct product;
  private AppService appService = AppService.getInstance();

  public DeliverCommand(CoffeeProduct product) {
    this.product = product;
  }

  @Override
  public void execute() {
    product.setQty(product.getQty()-1);
    appService.updateProduct(product);
  }

  @Override
  public void undo() {
    product.setQty(product.getQty()+1);
    appService.updateProduct(product);
  }

  @Override
  public String getName() {
    return this.getClass().getSimpleName();
  }
}
