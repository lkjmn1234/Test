package com.company.command.implement;

import com.company.Service.AppService;
import com.company.command.Command;
import com.company.product.CoffeeProduct;

public class DeliverCommand implements Command {

  private CoffeeProduct product;
  private int qty;
  private AppService appService = AppService.getInstance();

  public DeliverCommand(CoffeeProduct product, int qty) throws Exception {
    if (product == null) {
      throw new Exception("product cannot null");
    }
    if (qty < 0) {
      throw new Exception("quantity cannot negative");
    }
    this.product = product;
    this.qty = qty;
  }

  @Override
  public void execute() throws Exception {
    if (product.getQty() - qty < 0) {
      throw new Exception("quantity cannot negative");
    }
    product.setQty(product.getQty() - qty);
    appService.updateProduct(product);
  }

  @Override
  public void undo() {
    product.setQty(product.getQty() + qty);
    appService.updateProduct(product);
  }

  @Override
  public String getName() {
    return "Shipped " + qty + " " + product.getName() + " (" + product.getProductID() + ")";
  }
}
