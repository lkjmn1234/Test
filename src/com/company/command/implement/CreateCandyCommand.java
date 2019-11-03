package com.company.command.implement;

import com.company.command.Command;
import com.company.product.CoffeePowderFactory;
import com.company.product.CoffeeProduct;

public class CreateCandyProductCommand implements Command {

  CoffeeProduct product;

  public CreateCandyProductCommand(CoffeeProduct product) {
    this.product = product;
  }

  @Override
  public void execute() {
product = CoffeePowderFactory.
  }

}
