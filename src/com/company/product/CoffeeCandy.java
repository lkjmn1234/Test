package com.company.product;

public class CoffeeCandy extends CoffeeProduct {

  private int noOfCandy;
  private int caloriesPerCandy;

  public CoffeeCandy(int productID, String name, int noOfCandy, int caloriesPerCandy) {
    super(name, productID);
    this.noOfCandy = noOfCandy;
    this.caloriesPerCandy = caloriesPerCandy;
  }

  public int getNoOfCandy() {
    return noOfCandy;
  }

  public void setNoOfCandy(int noOfCandy) {
    this.noOfCandy = noOfCandy;
  }

  public int getCaloriesPerCandy() {
    return caloriesPerCandy;
  }

  public void setCaloriesPerCandy(int caloriesPerCandy) {
    this.caloriesPerCandy = caloriesPerCandy;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Product information \n");
    sb.append("ID:").append(super.getProductID()).append("\n");
    sb.append("Name:'").append(super.getName()).append("\n");
    sb.append("Quantity:").append(super.getQty()).append("\n");
    sb.append("Number of candies per package:").append(noOfCandy).append("\n");
    sb.append("Calories Per candy:").append(caloriesPerCandy).append("\n");
    return sb.toString();
  }
}
