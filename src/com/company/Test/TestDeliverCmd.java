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
import org.junit.Before;
import org.junit.Test;

public class TestDeliverCmd {

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
  public void testDeliverCandy() throws Exception {
    CoffeeCandy candy =
        (CoffeeCandy)
            productFactory.produceProduct(
                ProductConstant.CANDY, "1003, Premium Coffee Candy, 50, 15");
    Command createCandy = commandFactory.produceCommand(candy, CommandConstant.CREATE, 0);
    invoker.execute(createCandy);
    candy.setQty(10);
    Command deliverCandy = commandFactory.produceCommand(candy, CommandConstant.DELIVER, 10);
    invoker.execute(deliverCandy);
    candy = (CoffeeCandy) appService.searchProduct(candy.getProductID());
    assertEquals(1003, candy.getProductID());
    assertEquals("Premium Coffee Candy", candy.getName());
    assertEquals(50, candy.getNoOfCandy());
    assertEquals(15, candy.getCaloriesPerCandy());
    assertEquals(0, candy.getQty());
  }

  @Test
  public void testDeliverCandyError1() {
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
  public void testDeliverCandyError2() {
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
  public void testDeliverCandyError3() {
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
  public void testDeliverCandyError4() {
    CoffeeCandy candy = null;
    try {
      candy = (CoffeeCandy) productFactory.produceProduct(5, "1001, Premium Coffee Candy, 50, 5");
    } catch (Exception e) {
      assertEquals(e.getMessage(), "No Such Product");
    }
  }

  @Test
  public void testDeliverCandyError5() throws Exception {
    CoffeeCandy candy = null;
    candy =
        (CoffeeCandy)
            productFactory.produceProduct(
                ProductConstant.CANDY, "1001, Premium Coffee Candy, 50, 15");
    try {
      Command deliverCandy = commandFactory.produceCommand(candy, 5, 0);
    } catch (Exception e) {
      assertEquals(e.getMessage(), "No Such Command");
    }
  }

  @Test
  public void testDeliverCandyError6() throws Exception {
    CoffeeCandy candy = null;
    candy =
        (CoffeeCandy)
            productFactory.produceProduct(
                ProductConstant.CANDY, "1001, Premium Coffee Candy, 50, 15");

    try {
      Command deliverCandy = commandFactory.produceCommand(null, CommandConstant.DELIVER, 0);
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
      Command deliverCandy = commandFactory.produceCommand(candy, CommandConstant.DELIVER, 10);
      invoker.execute(deliverCandy);
    } catch (Exception e) {
      assertEquals(e.getMessage(), "quantity cannot negative");
    }
  }

  @Test
  public void testDeliverCandyError8() throws Exception {
    CoffeeCandy candy = null;
    candy =
        (CoffeeCandy)
            productFactory.produceProduct(
                ProductConstant.CANDY, "1001, Premium Coffee Candy, 50, 15");

    try {
      Command deliverCandy = commandFactory.produceCommand(candy, CommandConstant.DELIVER, -10);
      invoker.execute(deliverCandy);
    } catch (Exception e) {
      assertEquals(e.getMessage(), "quantity cannot negative");
    }
  }
}
