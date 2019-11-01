package com.company.product;

public class CoffeeCandyFactory implements ProductFactory{

  @Override
  public CoffeeProduct manufactureProduct() {
    return new CoffeeCandy();
  }
}
