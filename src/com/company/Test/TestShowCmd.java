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

public class TestShowCmd {


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
  public void testCreateCandyError5() throws Exception {
    CoffeeCandy candy = null;
      candy = (CoffeeCandy) productFactory
          .produceProduct(ProductConstant.CANDY, "1001, Premium Coffee Candy, 50, 15");
    try {
      Command createCandy = commandFactory.produceCommand(candy, 5, 0);
    } catch (Exception e) {
      assertEquals(e.getMessage(), "No Such Command");
    }

  }

  @Test
  public void testCreateCandyError6() throws Exception {
    CoffeeCandy candy = null;
      candy = (CoffeeCandy) productFactory
          .produceProduct(ProductConstant.CANDY, "1001, Premium Coffee Candy, 50, 15");
    try {
      Command createCandy = commandFactory.produceCommand(null, CommandConstant.CREATE, 0);
    } catch (Exception e) {
      assertEquals(e.getMessage(), "product cannot null");
    }
  }
}
