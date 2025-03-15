package com.spgtesting.Ex08_TestNGExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting_18_parameter {

    @Parameters("browser")
    @Test
    public void demo1(String value)
    {
        System.out.println("Demo 1 TC");

        if(value.equalsIgnoreCase("chrome")){
            System.out.println("Starts the chrome browser.");
        }

        if(value.equalsIgnoreCase("firefox")){
            System.out.println("Starts the firefox browser.");
        }
    }
}
