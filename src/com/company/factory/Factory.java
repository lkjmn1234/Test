package com.company.factory;

import com.company.command.Command;
import com.company.product.CoffeeProduct;

public interface Factory {

  CoffeeProduct produceProduct(int product) throws Exception;

  Command produceCommand(CoffeeProduct product, int productType) throws Exception;
}
