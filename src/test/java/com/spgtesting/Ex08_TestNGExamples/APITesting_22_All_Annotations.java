package com.spgtesting.Ex08_TestNGExamples;

import org.testng.annotations.*;

public class APITesting_22_All_Annotations {

    @BeforeSuite
    public void demo01()
    {
        System.out.println("BeforeSuite");
    }

    @BeforeTest
    public void demo02()
    {
        System.out.println("BeforeTest");
    }
    @BeforeClass
    public void demo03()
    {
        System.out.println("BeforeClass");
    }
    @BeforeMethod
    public void demo04()
    {
        System.out.println("BeforeMethod");
    }
    @Test
    public void demo05()
    {
        System.out.println("Test");
    }
    @AfterMethod
    public void demo06()
    {
        System.out.println("AfterMethod");
    }
    @AfterClass
    public void demo07()
    {
        System.out.println("AfterClass");
    }
    @AfterTest
    public void demo08()
    {
        System.out.println("AfterTest");
    }

    @AfterSuite
    public void demo09()
    {
        System.out.println("AfterSuite");
    }
}
