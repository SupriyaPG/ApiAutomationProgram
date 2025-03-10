package com.spgtesting.Ex02_RA_TestNG_AllureReport;

import io.restassured.RestAssured;

import org.testng.annotations.Test;

public class APITesting004_multiple_Testcases_TestNG {

    @Test
    //@Description("TC#1 - Verify that the valid Pincode gives 200 OK")
    public void test_get_positive_TC1(){
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("IN/411038")
                .get().
                then().log().all().statusCode(200);

    }

    @Test
   // @Description("TC#1 - Verify that the nagative Pincode gives 200 OK")
    public void test_get_negative_TC2(){
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("IN/-1")
                .get().
                then().log().all().statusCode(200);

    }

    @Test
   // @Description(value = "TC#1 - Verify that the invalid Pincode gives 200 OK")
    public void test_get_negative_TC3(){
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("IN/@")
                .get().
                then().log().all().statusCode(200);

    }
}
