package com.company.Test;

import static org.junit.Assert.assertEquals;

import com.company.Invoker;
import com.company.Service.AppService;
import com.company.command.Command;
import com.company.constant.CommandConstant;
import com.company.constant.FactoryConstant;
import com.company.constant.ProductConstant;
import com.company.factory.Factory;
import com.company.factory.FactoryProducer;
import com.company.product.CoffeeCandy;
import com.company.product.CoffeePowder;
import com.company.product.CoffeeProduct;
import org.junit.Before;
import org.junit.Test;

public class TestUndo {


  Factory productFactory = null;
  Factory commandFactory = null;

  Invoker invoker = null;
  AppService appService = null;

  @Before
  public void setUp() throws Exception {
    productFactory = FactoryProducer.getFactory(FactoryConstant.PRODUCT);
    commandFactory = FactoryProducer.getFactory(FactoryConstant.COMMAND);
    invoker = Invoker.getInstance();
    appService = AppService.getInstance();
  }

  @Test
  public void testUndo() throws Exception {
    CoffeeCandy candy = (CoffeeCandy) productFactory
        .produceProduct(ProductConstant.CANDY, "1001, Premium Coffee Candy, 50, 15");
    Command createCandy = commandFactory.produceCommand(candy, CommandConstant.CREATE, 0);
    invoker.execute(createCandy);
    Command receive = commandFactory.produceCommand(candy, CommandConstant.RECEIVE, 10);
    invoker.execute(receive);
    assertEquals(1001, candy.getProductID());
    assertEquals("Premium Coffee Candy", candy.getName());
    assertEquals(50, candy.getNoOfCandy());
    assertEquals(15, candy.getCaloriesPerCandy());
    assertEquals(10, candy.getQty());
    invoker.undo();
    assertEquals(1001, candy.getProductID());
    assertEquals("Premium Coffee Candy", candy.getName());
    assertEquals(50, candy.getNoOfCandy());
    assertEquals(15, candy.getCaloriesPerCandy());
    assertEquals(0, candy.getQty());
  }

  @Test
  public void testUndo2() throws Exception {
    CoffeeCandy candy = (CoffeeCandy) productFactory
        .produceProduct(ProductConstant.CANDY, "1006, Premium Coffee Candy, 50, 15");
    CoffeePowder powder = (CoffeePowder) productFactory
        .produceProduct(ProductConstant.POWDER, "2004, Colombia Coffee, 250\n");
    Command createCandy = commandFactory.produceCommand(candy, CommandConstant.CREATE, 0);
    invoker.execute(createCandy);
    Command createPowder = commandFactory.produceCommand(powder, CommandConstant.CREATE, 0);
    invoker.execute(createPowder);
    assertEquals(1006, candy.getProductID());
    assertEquals("Premium Coffee Candy", candy.getName());
    assertEquals(50, candy.getNoOfCandy());
    assertEquals(15, candy.getCaloriesPerCandy());
    assertEquals(0, candy.getQty());
    assertEquals(2004, powder.getProductID());
    assertEquals("Colombia Coffee", powder.getName());
    assertEquals(250d, powder.getWeight(), 0);
    assertEquals(0, powder.getQty());
    invoker.undo();
    powder = (CoffeePowder) appService.searchProduct(powder.getProductID());
    assertEquals(null, powder);
  }
}
