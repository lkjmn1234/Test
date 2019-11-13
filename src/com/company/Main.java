package com.company;

import com.company.Service.AppService;
import com.company.command.Command;
import com.company.constant.CommandConstant;
import com.company.constant.FactoryConstant;
import com.company.constant.ProductConstant;
import com.company.factory.Factory;
import com.company.factory.FactoryProducer;
import com.company.menu.MenuHandler;
import com.company.product.CoffeeProduct;

public class Main {

  public static void main(String[] args) throws Exception {
    AppService.init();
    Invoker.init();
    MenuHandler menuHandler = new MenuHandler();
    menuHandler.executeMenu();
  }
}
