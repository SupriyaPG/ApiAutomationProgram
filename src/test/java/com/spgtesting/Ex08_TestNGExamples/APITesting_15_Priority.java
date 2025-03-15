package com.spgtesting.Ex08_TestNGExamples;


import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class APITesting_15_Priority
{

    // For put Request we need -
    // 1. getToken
    // 2. getBooking
    // 3. test_PUT (Which will use the above two methods)
    // 4. closeAllThings


   // Step 1
    @Test(priority = 1)
    public  void  t1()
    {
        System.out.println("1");
    }

   @Test(priority=2)
    public void t2()
    {
        System.out.println("2");
    }

    @Test(priority=3)  // Step 3
    public void t3()
    {
        System.out.println("Test");
    }
    @Test(priority = 4) // Step 4
    public void t4()
    {
        System.out.println("Close");
    }

}
