package com.company;

import com.company.Service.AppService;
import com.company.command.Command;
import com.company.command.CommandFactory;
import com.company.command.CreateCommandFactory;
import com.company.constant.CommandConstant;
import com.company.constant.ProductConstant;
import com.company.product.CoffeeProduct;
import com.company.product.CoffeeProductFactory;

public class Main {

  public static void main(String[] args) throws Exception {
    AppService.init();
    Invoker.init();

    CoffeeProductFactory coffeeProductFactory = new CoffeeProductFactory();
    CommandFactory createCommandFactory = new CreateCommandFactory();

    CoffeeProduct candy = coffeeProductFactory.produceProduct(ProductConstant.CANDY);
    CoffeeProduct powder = coffeeProductFactory.produceProduct(ProductConstant.POWDER);

    Command createCandy = createCommandFactory.produceCommand(candy, CommandConstant.CREATE);
    Command createPowder = createCommandFactory.produceCommand(powder, CommandConstant.CREATE);
    Command deliverCandy = createCommandFactory.produceCommand(candy, CommandConstant.CREATE);
    Command deliverPowder = createCommandFactory.produceCommand(powder, CommandConstant.CREATE);
    Command receiveCandy = createCommandFactory.produceCommand(candy, CommandConstant.CREATE);
    Command receivePowder = createCommandFactory.produceCommand(powder, CommandConstant.CREATE);
    Command showCandy = createCommandFactory.produceCommand(candy, CommandConstant.CREATE);
    Command showPowder = createCommandFactory.produceCommand(powder, CommandConstant.CREATE);

    Invoker invoker = Invoker.getInstance();
    AppService appService = AppService.getInstance();


  }
}
