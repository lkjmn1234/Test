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

    Factory productFactory = FactoryProducer.getFactory(FactoryConstant.PRODUCT);
    Factory commandFactory = FactoryProducer.getFactory(FactoryConstant.COMMAND);

    CoffeeProduct candy = productFactory.produceProduct(ProductConstant.CANDY);
    CoffeeProduct powder = productFactory.produceProduct(ProductConstant.POWDER);

    Command createCandy = commandFactory.produceCommand(candy, CommandConstant.CREATE);
    Command createPowder = commandFactory.produceCommand(powder, CommandConstant.CREATE);
    Command deliverCandy = commandFactory.produceCommand(candy, CommandConstant.CREATE);
    Command deliverPowder = commandFactory.produceCommand(powder, CommandConstant.CREATE);
    Command receiveCandy = commandFactory.produceCommand(candy, CommandConstant.CREATE);
    Command receivePowder = commandFactory.produceCommand(powder, CommandConstant.CREATE);
    Command showCandy = commandFactory.produceCommand(candy, CommandConstant.CREATE);
    Command showPowder = commandFactory.produceCommand(powder, CommandConstant.CREATE);

    Invoker invoker = Invoker.getInstance();
    AppService appService = AppService.getInstance();

    MenuHandler menuHandler = new MenuHandler();
    menuHandler.executeMenu();
  }
}
