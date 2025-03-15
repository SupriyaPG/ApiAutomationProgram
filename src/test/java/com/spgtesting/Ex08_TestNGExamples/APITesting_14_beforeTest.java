package com.spgtesting.Ex08_TestNGExamples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting_14_beforeTest {

    // For put Request we need -
    // 1. getToken
    // 2. getBooking
    // 3. test_PUT (Which will use the above two methods)
    // 4. closeAllThings

    @BeforeTest  // Step 1
    public  void  test_getToken()
    {
        System.out.println("1");
    }

    @BeforeTest  // Step 2
    public void test_getBooking()
    {
        System.out.println("2");
    }

    @Test  // Step 3
    public void test_PUT()
    {
        System.out.println("Test");
    }
    @AfterTest  // Step 4
    public void test_closeAllThings()
    {
        System.out.println("Close");
    }

}
