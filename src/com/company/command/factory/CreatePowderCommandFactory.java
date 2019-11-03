package com.company.command.factory;

import com.company.command.Command;
import com.company.command.CommandFactory;
import com.company.command.implement.CreatePowderCommand;
import com.company.product.CoffeeProduct;

public class CreatePowderCommandFactory implements CommandFactory {

  private CoffeeProduct product;

  public CreatePowderCommandFactory(CoffeeProduct product) {
    this.product = product;
  }

  @Override
  public Command produceCommand() {
    return new CreatePowderCommand(product);
  }

}
