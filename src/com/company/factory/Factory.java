package com.company.factory;

import com.company.command.Command;
import com.company.product.CoffeeProduct;
import java.util.List;

public interface Factory {

  CoffeeProduct produceProduct(int product, String param) throws Exception;

  Command produceCommand(CoffeeProduct product, int productType, int qty) throws Exception;

  Command produceCommand(List<CoffeeProduct> product, int productType, boolean showAll)
      throws Exception;
}
