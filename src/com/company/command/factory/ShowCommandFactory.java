package com.company.command.factory;

import com.company.command.Command;
import com.company.command.CommandFactory;
import com.company.command.implement.CreateCandyCommand;
import com.company.command.implement.ShowCommand;
import com.company.product.CoffeeProduct;

public class ShowCommandFactory implements CommandFactory {

  private CoffeeProduct product;

  public ShowCommandFactory(CoffeeProduct product) {
    this.product = product;
  }

  @Override
  public Command produceCommand() {
    return new ShowCommand(product);
  }
}
