package com.company.product;

public class CoffeePowder extends CoffeeProduct {

  private double weight;

  public CoffeePowder() {
  }

  public CoffeePowder(String name, int productID, double weight) {
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
    final StringBuffer sb = new StringBuffer("CoffeePowder{");
    sb.append("weight=").append(weight);
    sb.append(", name='").append(super.getName()).append('\'');
    sb.append(", productID=").append(super.getProductID());
    sb.append(", qty=").append(super.getQty());
    sb.append('}');
    return sb.toString();
  }
}
