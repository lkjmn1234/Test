package com.company.command.implement;

import com.company.Service.AppService;
import com.company.command.Command;
import com.company.product.CoffeeProduct;

public class ReceiveCommand implements Command {

  private CoffeeProduct product;
  private AppService appService = AppService.getInstance();
  private int qty;

  public ReceiveCommand(CoffeeProduct product, int qty) {
    this.product = product;
    this.qty = qty;
  }

  @Override
  public void execute() {
    product.setQty(product.getQty() + qty);
    appService.updateProduct(product);
  }

  @Override
  public void undo() {
    product.setQty(product.getQty() - qty);
    appService.updateProduct(product);
  }

  @Override
  public String getName() {
    return "Received " + qty + " " + product.getName() + " (" + product.getProductID() + ")";
  }
}
