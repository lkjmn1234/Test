package com.company.command.implement;

import com.company.command.Command;
import com.company.product.CoffeeProduct;

public class ReceiveProductCommand implements Command {
  CoffeeProduct coffeeProduct;

  public ReceiveProductCommand(CoffeeProduct coffeeProduct) {
    this.coffeeProduct = coffeeProduct;
  }

  @Override
  public void execute() {

  }
}
