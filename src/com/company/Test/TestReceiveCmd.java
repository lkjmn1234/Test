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
import org.junit.Before;
import org.junit.Test;

public class TestReceiveCmd {

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
  public void testReceiveCandy() throws Exception {
    CoffeeCandy candy =
        (CoffeeCandy)
            productFactory.produceProduct(
                ProductConstant.CANDY, "1004, Premium Coffee Candy, 50, 15");
    Command createCandy = commandFactory.produceCommand(candy, CommandConstant.CREATE, 0);
    invoker.execute(createCandy);
    Command receiveCandy = commandFactory.produceCommand(candy, CommandConstant.RECEIVE, 10);
    invoker.execute(receiveCandy);
    candy = (CoffeeCandy) appService.searchProduct(candy.getProductID());
    assertEquals(1004, candy.getProductID());
    assertEquals("Premium Coffee Candy", candy.getName());
    assertEquals(50, candy.getNoOfCandy());
    assertEquals(15, candy.getCaloriesPerCandy());
    assertEquals(10, candy.getQty());
  }

  @Test
  public void testReceivePowder() throws Exception {
    CoffeePowder powder =
        (CoffeePowder)
            productFactory.produceProduct(ProductConstant.POWDER, "2002, Colombia Coffee, 250");
    Command createPowder = commandFactory.produceCommand(powder, CommandConstant.CREATE, 0);
    invoker.execute(createPowder);
    Command receivePowder = commandFactory.produceCommand(powder, CommandConstant.RECEIVE, 10);
    invoker.execute(receivePowder);
    powder = (CoffeePowder) appService.searchProduct(powder.getProductID());
    assertEquals(2002, powder.getProductID());
    assertEquals("Colombia Coffee", powder.getName());
    assertEquals(250d, powder.getWeight(), 0);
    assertEquals(10, powder.getQty());
  }

  @Test
  public void testReceiveCandyError1() {
    CoffeeCandy candy = null;
    try {
      candy =
          (CoffeeCandy)
              productFactory.produceProduct(
                  ProductConstant.CANDY, "1001, Premium Coffee Candy, abc, 15");
    } catch (Exception e) {
      assertEquals(e.getClass().getSimpleName(), "NumberFormatException");
    }
  }

  @Test
  public void testReceiveCandyError2() {
    CoffeeCandy candy = null;
    try {
      candy =
          (CoffeeCandy)
              productFactory.produceProduct(
                  ProductConstant.CANDY, "1001, Premium Coffee Candy, 50, abv");
    } catch (Exception e) {
      assertEquals(e.getClass().getSimpleName(), "NumberFormatException");
    }
  }

  @Test
  public void testReceiveCandyError3() {
    CoffeeCandy candy = null;
    try {
      candy =
          (CoffeeCandy)
              productFactory.produceProduct(
                  ProductConstant.CANDY, "1001, Premium Coffee Candy, 50");
    } catch (Exception e) {
      assertEquals(e.getClass().getSimpleName(), "ArrayIndexOutOfBoundsException");
    }
  }

  @Test
  public void testReceiveCandyError4() {
    CoffeeCandy candy = null;
    try {
      candy = (CoffeeCandy) productFactory.produceProduct(5, "1001, Premium Coffee Candy, 50, 5");
    } catch (Exception e) {
      assertEquals(e.getMessage(), "No Such Product");
    }
  }

  @Test
  public void testReceiveCandyError5() throws Exception {
    CoffeeCandy candy = null;

    candy =
        (CoffeeCandy)
            productFactory.produceProduct(
                ProductConstant.CANDY, "1001, Premium Coffee Candy, 50, 15");

    try {
      Command receiveCandy = commandFactory.produceCommand(candy, 5, 0);
    } catch (Exception e) {
      assertEquals(e.getMessage(), "No Such Command");
    }
  }

  @Test
  public void testReceiveCandyError6() throws Exception {
    CoffeeCandy candy = null;

    candy =
        (CoffeeCandy)
            productFactory.produceProduct(
                ProductConstant.CANDY, "1001, Premium Coffee Candy, 50, 15");

    try {
      Command receiveCandy = commandFactory.produceCommand(null, CommandConstant.RECEIVE, 0);
    } catch (Exception e) {
      assertEquals(e.getMessage(), "product cannot null");
    }
  }

  @Test
  public void testDeliverCandyError7() throws Exception {
    CoffeeCandy candy = null;

    candy =
        (CoffeeCandy)
            productFactory.produceProduct(
                ProductConstant.CANDY, "1001, Premium Coffee Candy, 50, 15");

    try {
      Command deliverCandy = commandFactory.produceCommand(candy, CommandConstant.RECEIVE, -10);
      invoker.execute(deliverCandy);
    } catch (Exception e) {
      assertEquals(e.getMessage(), "quantity cannot negative");
    }
  }
}
