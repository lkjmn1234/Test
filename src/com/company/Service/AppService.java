package com.company.Service;

import com.company.product.CoffeeProduct;
import java.util.ArrayList;

public class AppService {

  private static AppService instance = new AppService();
  private ArrayList<CoffeeProduct> allProduct = new ArrayList<>();

  public static AppService getInstance() {
    return instance;
  }

  public static void init() {}

  public void updateProduct(CoffeeProduct product) {
    for (CoffeeProduct c : allProduct) {
      if (c.getProductID() == product.getProductID()) {
        c = product;
        break;
      }
    }
  }

  public ArrayList<CoffeeProduct> getAllProduct() {
    return this.allProduct;
  }

  public ArrayList<CoffeeProduct> searchProduct(int productID) {
    ArrayList<CoffeeProduct> result = new ArrayList<>();
    for (CoffeeProduct c : allProduct) {
      if (c.getProductID() == productID) {
        result.add(c);
      }
    }
    if (productID == -1) {
      result = this.getAllProduct();
    }
    return result;
  }

  public boolean addProduct(CoffeeProduct product) {
    return allProduct.add(product);
  }

  public boolean removeProduct(CoffeeProduct product) {
    return allProduct.remove(product);
  }
}
