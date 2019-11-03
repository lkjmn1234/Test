package com.company.command.implement;

import com.company.command.Command;
import com.company.product.CoffeeProduct;

public class DeliverProductCommand implements Command {

  CoffeeProduct product;

  public DeliverProductCommand(CoffeeProduct product) {
    this.product = product;
  }

  @Override
  public void execute() {

  }
}
