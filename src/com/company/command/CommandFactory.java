package com.company.command;

import com.company.product.CoffeeProduct;

public interface CommandFactory {

  Command produceCommand(CoffeeProduct product, int productType) throws Exception;
}
