package com.spgtesting.Ex08_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting_21_invocationTime
{

    @Test(invocationCount = 3)
    public  void test01()
    {
        Assert.assertTrue(true);
    }
}
