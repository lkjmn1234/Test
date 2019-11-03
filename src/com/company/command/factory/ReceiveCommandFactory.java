package com.company.command.factory;

import com.company.command.Command;
import com.company.command.CommandFactory;
import com.company.command.implement.ReceiveCommand;
import com.company.product.CoffeeProduct;

public class ReceiveCommandFactory implements CommandFactory {

  private CoffeeProduct product;

  public ReceiveCommandFactory(CoffeeProduct product) {
    this.product = product;
  }

  @Override
  public Command produceCommand() {
    return new ReceiveCommand(product);
  }

}
