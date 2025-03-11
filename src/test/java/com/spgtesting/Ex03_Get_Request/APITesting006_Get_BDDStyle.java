package com.spgtesting.Ex03_Get_Request;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

public class APITesting006_Get_BDDStyle {

    @Description("Verify valid pincode with BBDStyle")
    @Test
    public void test_BDD_GET(){
        String Pincode="560016";
        RestAssured.given().
                baseUri("https://api.zippopotam.us")
                .basePath("IN/"+Pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }
}
