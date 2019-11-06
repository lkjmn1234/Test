package com.company.factory;

import com.company.command.Command;
import com.company.constant.ProductConstant;
import com.company.product.CoffeeCandy;
import com.company.product.CoffeePowder;
import com.company.product.CoffeeProduct;

public class CoffeeProductFactory implements Factory {

  @Override
  public CoffeeProduct produceProduct(int product) throws Exception {
    switch (product) {
      case ProductConstant.CANDY:
        return new CoffeeCandy("CoffeeCandy", 1, 5, 100);
      case ProductConstant.POWDER:
        return new CoffeePowder("CoffeePowder", 2, 100);
      default:
        throw new Exception("No Such Product");
    }
  }

  @Override
  public Command produceCommand(CoffeeProduct product, int productType) throws Exception {
    return null;
  }
}
