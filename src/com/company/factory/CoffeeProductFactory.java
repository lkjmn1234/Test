package com.company.factory;

import com.company.command.Command;
import com.company.constant.ProductConstant;
import com.company.product.CoffeeCandy;
import com.company.product.CoffeePowder;
import com.company.product.CoffeeProduct;
import java.util.List;

public class CoffeeProductFactory implements Factory {

  @Override
  public CoffeeProduct produceProduct(int product, String param) throws Exception {
    switch (product) {
      case ProductConstant.DEFAULT:
        return new CoffeeProduct("default", -1);
      case ProductConstant.CANDY:
        return new CoffeeCandy(Integer.parseInt(param.split(",")[0].trim()),
            param.split(",")[1].trim(), Integer.parseInt(param.split(",")[2].trim()),
            Integer.parseInt(param.split(",")[3].trim()));
      case ProductConstant.POWDER:
        return new CoffeePowder(Integer.parseInt(param.split(",")[0].trim()),
            param.split(",")[1].trim(), Double.parseDouble(param.split(",")[2].trim()));
      default:
        throw new Exception("No Such Product");
    }
  }

  @Override
  public Command produceCommand(CoffeeProduct product, int productType, int qty) throws Exception {
    return null;
  }

  @Override
  public Command produceCommand(List<CoffeeProduct> product, int productType, boolean showAll)
      throws Exception {
    return null;
  }

}
