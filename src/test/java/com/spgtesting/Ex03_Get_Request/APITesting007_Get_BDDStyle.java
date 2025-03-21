package com.spgtesting.Ex03_Get_Request;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

public class APITesting007_Get_BDDStyle {

    @Description("Verify positive pincode with BDDStyle")
    @Test
    public void test_BDD_GET_TC1() {
        String Pincode = "560016";
        RestAssured.given().
                baseUri("https://api.zippopotam.us")
                .basePath("IN/" + Pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }

    @Description("Verify negative pincode with BDDStyle")
        @Test
        public void test_BDD_GET_TC2 () {
            String Pincode = "-1";
            RestAssured.given().
                    baseUri("https://api.zippopotam.us")
                    .basePath("IN/" + Pincode)
                    .when().log().all().get()
                    .then().log().all().statusCode(404);
        }
    }