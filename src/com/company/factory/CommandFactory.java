package com.company.factory;

import com.company.command.Command;
import com.company.command.implement.CreateCommand;
import com.company.command.implement.DeliverCommand;
import com.company.command.implement.ReceiveCommand;
import com.company.command.implement.ShowCommand;
import com.company.constant.CommandConstant;
import com.company.product.CoffeeProduct;
import java.util.List;

public class CommandFactory implements Factory {

  @Override
  public CoffeeProduct produceProduct(int product, String param) {
    return null;
  }

  @Override
  public Command produceCommand(CoffeeProduct product, int productType, int qty)
      throws Exception {
    switch (productType) {
      case CommandConstant.CREATE:
        return new CreateCommand(product);
      case CommandConstant.DELIVER:
        return new DeliverCommand(product, qty);
      case CommandConstant.RECEIVE:
        return new ReceiveCommand(product, qty);
      default:
        throw new Exception("No Such Command");
    }
  }

  @Override
  public Command produceCommand(List<CoffeeProduct> product, int productType, boolean showAll)
      throws Exception {
    switch (productType) {
      case CommandConstant.SHOW:
        return new ShowCommand(product, showAll);
      default:
        throw new Exception("No Such Command");
    }
  }


}
