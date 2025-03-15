package com.spgtesting.Ex08_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting_17_dependsOnMethods {

    @Test
    public  void serverStartedOk()
    {
        System.out.println("I will run first.");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public  void method1()
    {
        System.out.println("method 1");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public  void method2()
    {
        System.out.println("method 2");
        Assert.assertTrue(true);
    }

}
