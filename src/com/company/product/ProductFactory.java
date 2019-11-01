package com.company.product;

public abstract class ProductFactory {

  public CoffeeProduct createCarFromColor(String productName) {
    switch (productName) {
      case "Candy":
        return new CoffeeCandy();
      case "Powder":
        return new CoffeePowder();
      default:
        return new CoffeeProduct();
    }
  }
}
