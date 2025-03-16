package com.spgtesting.Ex09_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting_24_TestNG_assertions {

    //Hard Assertions
    @Test
    public  void test_hardAssertExample(){

        System.out.println("Start of the program.");
        Boolean is_neeru_male=false;
        Assert.assertEquals("pramod","Pramod");
        System.out.println("End of the program");
    }

    //Soft Assertions

    @Test
    public void test_softAssertExample(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(false);
        System.out.println("End of the program");
        softAssert.assertAll();
    }

}
