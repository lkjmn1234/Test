package com.company.command;

import com.company.command.Command;
import com.company.command.CommandFactory;
import com.company.command.implement.CreateCommand;
import com.company.command.implement.DeliverCommand;
import com.company.command.implement.ReceiveCommand;
import com.company.command.implement.ShowCommand;
import com.company.constant.CommandConstant;
import com.company.product.CoffeeProduct;

public class CreateCommandFactory implements CommandFactory {

  @Override
  public Command produceCommand(CoffeeProduct product, int productType) throws Exception {
    switch (productType) {
      case CommandConstant.CREATE:
        return new CreateCommand(product);
      case CommandConstant.DELIVER:
        return new DeliverCommand(product);
      case CommandConstant.RECEIVE:
        return new ReceiveCommand(product);
      case CommandConstant.SHOW:
        return new ShowCommand(product);
      default:
        throw new Exception("No Such Command");
    }
  }
}
