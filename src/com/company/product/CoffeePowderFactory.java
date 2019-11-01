package com.company.product;

public class CoffeePowderFactory implements ProductFactory {

  @Override
  public CoffeeProduct manufactureProduct() {
    return new CoffeePowder();
  }
}
