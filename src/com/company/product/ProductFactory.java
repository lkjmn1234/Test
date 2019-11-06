package com.company.product;

public interface ProductFactory {

  CoffeeProduct produceProduct(int product) throws Exception;
}
