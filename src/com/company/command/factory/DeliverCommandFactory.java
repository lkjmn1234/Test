package com.company.command.factory;

import com.company.command.Command;
import com.company.command.CommandFactory;
import com.company.command.implement.DeliverCommand;
import com.company.product.CoffeeProduct;

public class DeliverCommandFactory implements CommandFactory {

  private CoffeeProduct product;

  public DeliverCommandFactory(CoffeeProduct product) {
    this.product = product;
  }

  @Override
  public Command produceCommand() {
    return new DeliverCommand(product);
  }

}
