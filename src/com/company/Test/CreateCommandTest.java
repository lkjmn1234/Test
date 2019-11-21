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
import org.junit.*;

public class CreateCommandTest {


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
  public void testCreateCandy() throws Exception {
    CoffeeCandy candy = (CoffeeCandy) productFactory
        .produceProduct(ProductConstant.CANDY, "1002, Premium Coffee Candy, 50, 15");
    Command createCandy = commandFactory.produceCommand(candy, CommandConstant.CREATE, 0);
    invoker.execute(createCandy);
    candy = (CoffeeCandy) appService.searchProduct(candy.getProductID());
    assertEquals(1002, candy.getProductID());
    assertEquals("Premium Coffee Candy", candy.getName());
    assertEquals(50, candy.getNoOfCandy());
    assertEquals(15, candy.getCaloriesPerCandy());
    assertEquals(0, candy.getQty());
  }

  @Test
  public void testCreatePowder() throws Exception {
    CoffeePowder powder = (CoffeePowder) productFactory
        .produceProduct(ProductConstant.POWDER, "2001, Colombia Coffee, 250");
    Command createCandy = commandFactory.produceCommand(powder, CommandConstant.CREATE, 0);
    invoker.execute(createCandy);
    powder = (CoffeePowder) appService.searchProduct(powder.getProductID());
    assertEquals(2001, powder.getProductID());
    assertEquals("Colombia Coffee", powder.getName());
    assertEquals(250d, powder.getWeight(), 0);
    assertEquals(0, powder.getQty());
  }

  @Test
  public void testCreateCandyError1() {
    CoffeeCandy candy = null;
    try {
      candy = (CoffeeCandy) productFactory
          .produceProduct(ProductConstant.CANDY, "1001, Premium Coffee Candy, abc, 15");
    } catch (Exception e) {
      assertEquals(e.getClass().getSimpleName(), "NumberFormatException");
    }
  }

  @Test
  public void testCreateCandyError2() {
    CoffeeCandy candy = null;
    try {
      candy = (CoffeeCandy) productFactory
          .produceProduct(ProductConstant.CANDY, "1001, Premium Coffee Candy, 50, abv");
    } catch (Exception e) {
      assertEquals(e.getClass().getSimpleName(), "NumberFormatException");
    }
  }

  @Test
  public void testCreateCandyError3() {
    CoffeeCandy candy = null;
    try {
      candy = (CoffeeCandy) productFactory
          .produceProduct(ProductConstant.CANDY, "1001, Premium Coffee Candy, 50");
    } catch (Exception e) {
      assertEquals(e.getClass().getSimpleName(), "ArrayIndexOutOfBoundsException");
    }
  }

  @Test
  public void testCreateCandyError4() {
    CoffeeCandy candy = null;
    try {
      candy = (CoffeeCandy) productFactory
          .produceProduct(5, "1001, Premium Coffee Candy, 50, 5");
    } catch (Exception e) {
      assertEquals(e.getMessage(), "No Such Product");
    }
  }

  @Test
  public void testCreateCandyError5() {
    CoffeeCandy candy = null;
    try {
      candy = (CoffeeCandy) productFactory
          .produceProduct(ProductConstant.CANDY, "1001, Premium Coffee Candy, 50, 15");
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      Command createCandy = commandFactory.produceCommand(candy, 5, 0);
    } catch (Exception e) {
      assertEquals(e.getMessage(), "No Such Command");
    }

  }

  @Test
  public void testCreateCandyError6() {
    CoffeeCandy candy = null;
    try {
      candy = (CoffeeCandy) productFactory
          .produceProduct(ProductConstant.CANDY, "1001, Premium Coffee Candy, 50, 15");
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      Command createCandy = commandFactory.produceCommand(null, CommandConstant.CREATE, 0);
    } catch (Exception e) {
      assertEquals(e.getMessage(), "product cannot null");
    }
  }

  @Test
  public void testCreateCandyError7() throws Exception {
    CoffeeCandy candy = (CoffeeCandy) productFactory
        .produceProduct(ProductConstant.CANDY, "1001, Premium Coffee Candy, 50, 15");
    candy.setQty(1);
    Command createCandy = commandFactory.produceCommand(candy, CommandConstant.CREATE, 0);
    invoker.execute(createCandy);
    candy = (CoffeeCandy) appService.searchProduct(candy.getProductID());
    assertEquals(1001, candy.getProductID());
    assertEquals("Premium Coffee Candy", candy.getName());
    assertEquals(50, candy.getNoOfCandy());
    assertEquals(15, candy.getCaloriesPerCandy());
    assertEquals(1, candy.getQty());
  }
}
