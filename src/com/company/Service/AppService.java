package com.company.Service;


import com.company.product.CoffeeProduct;
import java.util.ArrayList;

public class AppService {

  private static AppService instance = new AppService();
  private ArrayList<CoffeeProduct> allProduct = new ArrayList<>();

  public static AppService getInstance() {
    return instance;
  }

  public static void init() {
  }

  public void updateProduct(CoffeeProduct product) {
    for (CoffeeProduct c : allProduct) {
      if (c.getProductID() == product.getProductID()) {
        c = product;
        break;
      }
    }
  }


  public ArrayList<CoffeeProduct> searchProduct(int productID) {
    ArrayList<CoffeeProduct> result = new ArrayList<>();
    boolean found = false;
    for (CoffeeProduct c : allProduct) {
      if (c.getProductID() == productID) {
        result.add(c);
        found = true;
      }
    }
    if (productID == 0) {
      found = true;
      result = allProduct;
    }
    return (found) ? result : null;
  }

  public boolean addProduct(CoffeeProduct product) {
    boolean isSuccess = allProduct.add(product);
    return isSuccess;
  }

  public boolean removeProduct(int productID) {
    for (CoffeeProduct p : allProduct) {
      if (p.getProductID() == productID) {
        return allProduct.remove(p);
      }
    }
    return false;
  }
}
