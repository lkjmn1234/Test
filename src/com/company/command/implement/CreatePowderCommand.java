package com.company.command.implement;

import com.company.Service.AppService;
import com.company.command.Command;
import com.company.product.CoffeePowderFactory;
import com.company.product.CoffeeProduct;
import com.company.product.ProductFactory;

public class CreatePowderCommand implements Command {

  private CoffeeProduct product;
  private AppService appService = AppService.getInstance();

  public CreatePowderCommand(CoffeeProduct product) {
    this.product = product;
  }

  @Override
  public void execute() {
    ProductFactory productFactory = new CoffeePowderFactory();
    product = productFactory.produceProduct();
    appService.addProduct(product);
  }

  @Override
  public void undo() {

  }

  @Override
  public String getName() {
    return this.getName();
  }
}
