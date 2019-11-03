package com.company.command.implement;

import com.company.Service.AppService;
import com.company.command.Command;
import com.company.product.CoffeeCandyFactory;
import com.company.product.CoffeePowderFactory;
import com.company.product.CoffeeProduct;
import com.company.product.ProductFactory;

public class CreateCandyCommand implements Command {

  private CoffeeProduct product;
  private AppService appService = AppService.getInstance();

  public CreateCandyCommand(CoffeeProduct product) {
    this.product = product;
  }

  @Override
  public void execute() {
    ProductFactory productFactory = new CoffeeCandyFactory();
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
