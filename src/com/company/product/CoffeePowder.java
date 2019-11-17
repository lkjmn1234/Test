package com.company.product;

public class CoffeePowder extends CoffeeProduct {

  private double weight;

  public CoffeePowder(int productID, String name, double weight) {
    super(name, productID);
    this.weight = weight;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Product information ");
    sb.append("ID:").append(super.getProductID()).append("\n");
    sb.append("Name:").append(super.getName()).append("\n");
    sb.append("Quantity:").append(super.getQty()).append("\n");
    sb.append("Weight=").append(weight).append("\n");
    return sb.toString();
  }
}
