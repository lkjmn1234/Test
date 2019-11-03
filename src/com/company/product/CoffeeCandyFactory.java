package com.company.product;

public class CoffeeCandyFactory implements ProductFactory {

  @Override
  public CoffeeProduct produceProduct() {
    return new CoffeeCandy("CoffeeCandy", 1, 5, 100);
  }
}
