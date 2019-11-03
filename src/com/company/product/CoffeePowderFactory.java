package com.company.product;

public class CoffeePowderFactory implements ProductFactory {

  @Override
  public CoffeeProduct produceProduct() {
    return new CoffeePowder("CoffeePowder", 2, 50);
  }
}
