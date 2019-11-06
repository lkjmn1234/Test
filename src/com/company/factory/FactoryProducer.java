package com.company.factory;

import com.company.constant.FactoryConstant;

public class FactoryProducer {
  public static Factory getFactory(int Factory) throws Exception {
    switch (Factory) {
      case FactoryConstant.COMMAND:
        return new CommandFactory();
      case FactoryConstant.PRODUCT:
        return new CoffeeProductFactory();
      default:
        throw new Exception("No Such Factory");
    }
  }
}
