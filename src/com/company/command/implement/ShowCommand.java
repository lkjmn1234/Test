package com.company.command.implement;

import com.company.command.Command;
import com.company.product.CoffeeProduct;

public class ShowProductCommand implements Command {

  CoffeeProduct product;

  public ShowProductCommand(CoffeeProduct product) {
    this.product = product;
  }

  @Override
  public void execute() {

  }
}
