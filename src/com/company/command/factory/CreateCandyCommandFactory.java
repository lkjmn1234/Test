package com.company.command.factory;

import com.company.command.Command;
import com.company.command.CommandFactory;
import com.company.command.implement.CreateCandyCommand;
import com.company.product.CoffeeProduct;

public class CreateCandyCommandFactory implements CommandFactory {

  private CoffeeProduct product;

  public CreateCandyCommandFactory(CoffeeProduct product) {
    this.product = product;
  }

  @Override
  public Command produceCommand() {
    return new CreateCandyCommand(product);
  }

}
