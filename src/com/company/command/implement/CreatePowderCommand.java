package com.company.command.implement;

import com.company.command.Command;
import com.company.product.CoffeeProduct;

public class CreatePowderProductCommand implements Command {

  CoffeeProduct product;

  public CreatePowderProductCommand(CoffeeProduct product) {
    this.product = product;
  }

  @Override
  public void execute() {

  }

}
