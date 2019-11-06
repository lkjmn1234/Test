package com.company.product;

import com.company.constant.ProductConstant;

public class CoffeeProductFactory implements ProductFactory {

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
}
