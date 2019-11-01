package com.company.product;

public class CoffeeCandy extends CoffeeProduct{

  private int noOfCandy;
  private int caloriesPerCandy;

  public CoffeeCandy() {
  }

  public CoffeeCandy(int noOfCandy, int caloriesPerCandy) {
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
    final StringBuffer sb = new StringBuffer("CoffeeCandy{");
    sb.append("noOfCandy=").append(noOfCandy);
    sb.append(", caloriesPerCandy=").append(caloriesPerCandy);
    sb.append('}');
    return sb.toString();
  }
}
