package com.company.product;

public class CoffeeProduct {

  private String name;
  private int productID;
  private int qty;

  public CoffeeProduct() {
  }

  public CoffeeProduct(String name, int productID) {
    this.name = name;
    this.productID = productID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getProductID() {
    return productID;
  }

  public void setProductID(int productID) {
    this.productID = productID;
  }

  public int getQty() {
    return qty;
  }

  public void setQty(int qty) {
    this.qty = qty;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("CoffeeProduct{");
    sb.append("name='").append(name).append('\'');
    sb.append(", productID=").append(productID);
    sb.append(", qty=").append(qty);
    sb.append('}');
    return sb.toString();
  }
}
